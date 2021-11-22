package com.example.halanchallenge.ui.productslist.viewmodels

import com.example.halanchallenge.model.ProductsList


sealed class ProductsListViewState {
    object LOADING : ProductsListViewState()
    class SUCCESS(val payload: ProductsList) : ProductsListViewState()
    class FAILURE(val errorMsg: String) : ProductsListViewState()
}