package com.example.halanchallenge.di

import com.example.halanchallenge.ui.login.viewmodels.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    // provide viewModel instance from LoginViewModel class
    viewModel { LoginViewModel(get()) }
}