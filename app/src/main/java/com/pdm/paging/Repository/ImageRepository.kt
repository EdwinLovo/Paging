package com.pdm.paging.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.pdm.paging.Retrofit.ImageService
import com.pdm.paging.Retrofit.Images
import com.pdm.paging.Room.Dao.ImageDao
import com.pdm.paging.Room.Entities.Image
import kotlinx.coroutines.Deferred
import retrofit2.Response

class ImageRepository(private val imageDao: ImageDao) {

    val allMovies:LiveData<List<Image>> = imageDao.getAllImages()

    @WorkerThread
    suspend fun insertImage(image: Image) = imageDao.insert(image)

    fun retrieveImages():Deferred<Response<Images>> =
            ImageService.getMovieService().getImages()

}