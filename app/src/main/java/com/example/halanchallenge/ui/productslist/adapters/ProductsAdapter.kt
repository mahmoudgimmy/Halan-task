package com.example.halanchallenge.ui.productslist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.halanchallenge.databinding.ItemProductBinding
import com.example.halanchallenge.model.Product

class ProductsAdapter(private val itemProductClicks: ItemProductClicks) :
    ListAdapter<Product, ProductsAdapter.ProductViewHolder>(DiffCheck.Products_DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        getItem(position)?.let { holder.bindTo(it, itemProductClicks) }
    }

    class ProductViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindTo(product: Product, itemProductClicks: ItemProductClicks) {
            binding.apply {
                this.product = product
                this.productClicks = itemProductClicks
            }
        }
    }

}

object DiffCheck {
    var Products_DIFF_CALLBACK: DiffUtil.ItemCallback<Product> =
        object :
            DiffUtil.ItemCallback<Product>() {

            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id
            }
        }
}

interface ItemProductClicks {
    fun onProductClicked(product: Product)
}
