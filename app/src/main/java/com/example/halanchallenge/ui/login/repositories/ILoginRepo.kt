package com.example.halanchallenge.ui.login.repositories

import com.example.halanchallenge.model.LoginCredentials
import com.example.halanchallenge.model.UserData


interface ILoginRepo {
    suspend fun login(loginCredentials: LoginCredentials): UserData
}