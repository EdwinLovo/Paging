package com.pdm.paging.ViewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.pdm.paging.Repository.ImageRepository
import com.pdm.paging.Room.Entities.Image
import com.pdm.paging.Room.ImageDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageViewModel(private val app:Application): AndroidViewModel(app) {

    private val repository:ImageRepository
    val allImages:LiveData<List<Image>>

    init {
        val imageDao = ImageDB.getInstance(app).imageDao()
        repository = ImageRepository(imageDao)
        allImages = repository.allMovies
    }

    fun insertImage(image: Image) = viewModelScope.launch(Dispatchers.IO){
        repository.insertImage(image)
    }

    fun retrieveImages() = viewModelScope.launch(Dispatchers.IO){
        val response = repository.retrieveImages().await()

        if (response.isSuccessful) with(response.body()?.image){
            this?.forEach {
                this@ImageViewModel.insertImage(it)
                Log.d("CODIGO", "Path: "+it.path)
            }
        } else with(response){
            when(this.code()){
                404->{
                    Toast.makeText(app, "Images not found", Toast.LENGTH_LONG).show()

                }
            }
            Log.d("CODIGO", "ERROR")
        }
    }

}