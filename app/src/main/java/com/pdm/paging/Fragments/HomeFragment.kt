package com.pdm.paging.Fragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdm.paging.Adapter.ImageAdapter

import com.pdm.paging.R
import com.pdm.paging.ViewModel.ImageViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    private lateinit var imageViewModel:ImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        init(view)
        return view
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    fun init(view: View){
        imageViewModel = ViewModelProviders.of(this).get(ImageViewModel::class.java)

        var adapter = ImageAdapter(view.context)
        val recyclerView = view.recyclerviewImages
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        imageViewModel.retrieveImages()

        imageViewModel.allImages.observe(this, Observer { images->
            images?.let { adapter.setImages(it) }
        })

    }
}
