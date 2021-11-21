package com.example.halanchallenge.ui.login.repositories

import com.example.halanchallenge.model.Credentials
import com.example.halanchallenge.model.UserData


interface ILoginRepository {
    suspend fun login(credentials: Credentials): UserData
}