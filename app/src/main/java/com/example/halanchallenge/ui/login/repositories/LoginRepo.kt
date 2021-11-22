package com.example.halanchallenge.ui.login.repositories

import com.example.halanchallenge.model.LoginCredentials
import com.example.halanchallenge.model.UserData
import com.example.halanchallenge.data.remote.HalanRemote

class LoginRepo(private val halanRemote: HalanRemote):ILoginRepo {
    override suspend fun login(loginCredentials: LoginCredentials): UserData = halanRemote.login(loginCredentials)
}