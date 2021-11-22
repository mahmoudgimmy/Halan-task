package com.example.halanchallenge.data.remote

import com.example.halanchallenge.data.local.SharedPreferencesManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(private val sharedPref:SharedPreferencesManager) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer " + sharedPref.getToken())
            .build()
        return chain.proceed(newRequest)
    }
}