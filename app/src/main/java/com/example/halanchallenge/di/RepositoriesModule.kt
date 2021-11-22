package com.example.halanchallenge.di

import com.example.halanchallenge.ui.login.repositories.ILoginRepository
import com.example.halanchallenge.ui.login.repositories.LoginRepository
import com.example.halanchallenge.ui.productslist.repositories.IProductsList
import com.example.halanchallenge.ui.productslist.repositories.ProductsListRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single<ILoginRepository> { LoginRepository(get()) }
    single<IProductsList> { ProductsListRepository(get()) }
}
