package com.example.halanchallenge.ui.login.repositories

import com.example.halanchallenge.model.LoginCredentials
import com.example.halanchallenge.model.UserData


interface ILoginRepository {
    suspend fun login(loginCredentials: LoginCredentials): UserData
}