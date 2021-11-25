package com.example.halanchallenge.ui.productdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.halanchallenge.databinding.ItemImageViewBinding

class ImagesAdapter(private val images: List<String>) :
    RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemImageViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        images[position].let { holder.bindTo(it) }

    // total number of rows
    override fun getItemCount(): Int = images.size


    class ViewHolder(private val binding: ItemImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTo(imageUrl: String) {
            binding.url = imageUrl
        }
    }

}