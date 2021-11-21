package com.example.halanchallenge.remote

import com.example.halanchallenge.model.LoginCredentials
import com.example.halanchallenge.model.ProductsList
import com.example.halanchallenge.model.UserData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HalanRemote {
    @POST("auth")
    suspend fun login(@Body loginCredentials: LoginCredentials ): UserData

    @GET("products")
    suspend fun getProducts(): ProductsList
}