package com.example.halanchallenge.di

import com.example.halanchallenge.data.local.SharedPreferencesManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val sharedPrefModule = module {
    single {
        SharedPreferencesManager(androidContext())
    }
}
