package com.example.halanchallenge.ui.login.repositories

import com.example.halanchallenge.model.LoginCredentials
import com.example.halanchallenge.model.UserData
import com.example.halanchallenge.remote.HalanRemote

class LoginRepository(private val halanRemote: HalanRemote):ILoginRepository {
    override suspend fun login(loginCredentials: LoginCredentials): UserData = halanRemote.login(loginCredentials)
}