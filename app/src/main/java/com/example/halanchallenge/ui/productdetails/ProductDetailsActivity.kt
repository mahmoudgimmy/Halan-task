package com.example.halanchallenge.ui.productdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.halanchallenge.databinding.ActivityProductDetailsBinding
import com.example.halanchallenge.model.Product
import com.example.halanchallenge.ui.productslist.activities.ProductListActivity

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductDetailsBinding
    lateinit var product: Product
    lateinit var imagesAdapter: ImagesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
        prepareRecycleView()
        initializeClickListeners()
        binding.apply {
            arIndicator.attachTo(rvProductImagesBanner, true)
        }

    }

    private fun getExtras() {
        product = intent.extras?.getParcelable(ProductListActivity.PRODUCT)!!
        binding.product = product
    }

    private fun prepareRecycleView() {
        imagesAdapter = ImagesAdapter(product.images!!)
        binding.rvProductImagesBanner.apply {
            layoutManager =
                LinearLayoutManager(
                    this@ProductDetailsActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            adapter = imagesAdapter
        }
    }

    private fun initializeClickListeners() {
        binding.materialButton.setOnClickListener {
            finish()
        }
    }
}