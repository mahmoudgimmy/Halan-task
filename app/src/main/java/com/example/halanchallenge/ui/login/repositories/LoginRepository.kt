package com.example.halanchallenge.ui.login.repositories

import com.example.halanchallenge.model.Credentials
import com.example.halanchallenge.model.UserData
import com.example.halanchallenge.remote.HalanRemote

class LoginRepository(private val halanRemote: HalanRemote):ILoginRepository {
    override suspend fun login(credentials: Credentials): UserData = halanRemote.login(credentials)
}