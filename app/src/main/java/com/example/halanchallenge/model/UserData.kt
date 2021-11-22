package com.example.halanchallenge.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class UserData(val token: String, val profile: Profile)

@Parcelize
data class Profile(
    @SerializedName("username") val userName: String,
    val image: String,
    val name: String,
    var phone: String,
    var email: String
):Parcelable
