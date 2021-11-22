package com.example.halanchallenge.ui.productslist.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.halanchallenge.ProductDetailsActivity
import com.example.halanchallenge.databinding.ActivityProductsListBinding
import com.example.halanchallenge.model.Product
import com.example.halanchallenge.ui.productslist.adapters.ItemProductClicks
import com.example.halanchallenge.ui.productslist.adapters.ProductsAdapter
import com.example.halanchallenge.ui.productslist.viewmodels.ProductsListViewModel
import com.example.halanchallenge.ui.productslist.viewmodels.ProductsListViewState

class ProductListActivity : AppCompatActivity(), ItemProductClicks {
    lateinit var binding: ActivityProductsListBinding
    private val viewModel: ProductsListViewModel by viewModel()
    lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsListBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
        getExtras()
        prepareProductListRV()
        initiateUI()
        initializeObservers()

    }

    private fun initializeObservers() {
        viewModel.products.observe(this, {
            render(it)
        })
    }

    private fun render(viewState: ProductsListViewState) {
        binding.apply {
            when (viewState) {
                is ProductsListViewState.LOADING -> pbLoading.isVisible = true

                is ProductsListViewState.SUCCESS -> {
                    pbLoading.isVisible = false
                    productsAdapter.submitList(viewState.payload.products)

                }
                is ProductsListViewState.FAILURE -> {
                    pbLoading.isVisible = false
                    Toast.makeText(
                        this@ProductListActivity,
                        viewState.errorMsg,
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

        }
    }

    private fun initiateUI() =
        viewModel.getProducts()


    private fun prepareProductListRV() {
        productsAdapter = ProductsAdapter(this)
        binding.rvProductsList.apply {
            layoutManager =
                LinearLayoutManager(this@ProductListActivity, LinearLayoutManager.VERTICAL, false)
            adapter = productsAdapter
        }
    }

    private fun getExtras() {
        binding.profile = intent.extras?.getParcelable("Profile")
    }


    override fun onProductClicked(product: Product) {
        startActivity(Intent(this, ProductDetailsActivity::class.java).apply {
            putExtra("product", product)
        })
    }
}