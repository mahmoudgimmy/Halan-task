package com.example.halanchallenge

import android.app.Application
import com.example.halanchallenge.di.networkModule
import com.example.halanchallenge.di.repositoriesModule
import com.example.halanchallenge.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(networkModule, viewModelsModule, repositoriesModule)

            )
        }
    }
}