package com.example.halanchallenge.di

import com.example.halanchallenge.ui.login.repositories.ILoginRepository
import com.example.halanchallenge.ui.login.repositories.LoginRepository
import org.koin.dsl.module

val repositoriesModule = module {
    // provide singleton instance from WeatherRepository class
    single<ILoginRepository> { LoginRepository(get()) }
}
