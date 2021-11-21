package com.example.halanchallenge.remote

import com.example.halanchallenge.model.Credentials
import com.example.halanchallenge.model.ProductsList
import com.example.halanchallenge.model.UserData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HalanRemote {
    @POST("auth")
    suspend fun login(@Body credentials: Credentials ): UserData

    @GET("products")
    suspend fun getProducts(): ProductsList
}