package com.example.halanchallenge.di

import com.example.halanchallenge.ui.login.viewmodels.LoginViewModel
import com.example.halanchallenge.ui.productslist.viewmodels.ProductsListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { ProductsListViewModel(get()) }

}