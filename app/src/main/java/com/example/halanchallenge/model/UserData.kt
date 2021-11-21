package com.example.halanchallenge.model

import com.google.gson.annotations.SerializedName

data class UserData(val token: String, val profile: Profile)

data class Profile(
    @SerializedName("username") val userName: String,
    val image: String,
    val name: String,
    var phone: String,
    var email: String
)
