package com.example.halanchallenge.ui.productslist.repositories

import com.example.halanchallenge.model.ProductsList
import com.example.halanchallenge.data.remote.HalanRemote

class ProductsListRepo(private val halanRemote: HalanRemote):IProductsListRepo {
    override suspend fun getProductList(): ProductsList =halanRemote.getProducts()
}