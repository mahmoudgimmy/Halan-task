package com.example.halanchallenge.ui.productslist.repositories

import com.example.halanchallenge.model.ProductsList

interface IProductsListRepo {
    suspend fun getProductList():ProductsList
}