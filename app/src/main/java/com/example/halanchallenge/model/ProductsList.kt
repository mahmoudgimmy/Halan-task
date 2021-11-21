package com.example.halanchallenge.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductsList(val status: String, val products: List<Product>) : Parcelable

@Parcelize
data class Product(
    val id: Int,
    @SerializedName("name_ar") val arName: String,
    @SerializedName("deal_description") val dealDescription: String,
    val brand: String,
    val image: String,
    @SerializedName("name_en") val enName: String,
    val price: Int,
    val images: List<String>? = null
) : Parcelable