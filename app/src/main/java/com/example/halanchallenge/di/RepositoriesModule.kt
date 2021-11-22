package com.example.halanchallenge.di

import com.example.halanchallenge.ui.login.repositories.ILoginRepo
import com.example.halanchallenge.ui.login.repositories.LoginRepo
import com.example.halanchallenge.ui.productslist.repositories.IProductsListRepo
import com.example.halanchallenge.ui.productslist.repositories.ProductsListRepo
import org.koin.dsl.module

val repositoriesModule = module {
    single<ILoginRepo> { LoginRepo(get()) }
    single<IProductsListRepo> { ProductsListRepo(get()) }
}
