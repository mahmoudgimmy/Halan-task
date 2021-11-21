package com.example.halanchallenge.model

import com.google.gson.annotations.SerializedName

data class Credentials(@SerializedName("username") val userName: String, val password: String)