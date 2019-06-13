package com.pdm.paging.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pdm.paging.R
import com.pdm.paging.Room.Entities.Image
import kotlinx.android.synthetic.main.image.view.*

class ImageAdapter internal constructor(private val context: Context):RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){

    private var inflater = LayoutInflater.from(context)
    private var images = emptyList<Image>()

    override fun getItemCount() = images.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView = inflater.inflate(R.layout.image,parent,false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentImage = images[position]

        Glide.with(context)
                .load(currentImage.path)
                .crossFade()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.image)
    }

    inner class ImageViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val image = itemView.image
    }

    internal fun setImages(images:List<Image>){
        this.images = images
        notifyDataSetChanged()
    }

}