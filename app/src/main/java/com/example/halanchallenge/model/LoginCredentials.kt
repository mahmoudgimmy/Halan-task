package com.example.halanchallenge.model

import com.google.gson.annotations.SerializedName

data class LoginCredentials(@SerializedName("username") val userName: String, val password: String)