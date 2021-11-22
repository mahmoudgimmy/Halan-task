package com.example.halanchallenge.ui.productslist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.halanchallenge.ui.productslist.repositories.IProductsListRepo
import kotlinx.coroutines.launch

class ProductsListViewModel(private val repository: IProductsListRepo) : ViewModel() {
    private val _products = MutableLiveData<ProductsListViewState>()
    val products: LiveData<ProductsListViewState> = _products
    fun getProducts() = viewModelScope.launch {
        _products.value = ProductsListViewState.LOADING
        try {
            val result = repository.getProductList()
            _products.value = ProductsListViewState.SUCCESS(result)
        } catch (e: Exception) {
            _products.value = ProductsListViewState.FAILURE(e.message!!)
        }
    }
}