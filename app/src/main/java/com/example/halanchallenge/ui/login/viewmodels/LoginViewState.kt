package com.example.halanchallenge.ui.login.viewmodels

import com.example.halanchallenge.model.UserData

sealed class LoginViewState {
    object LOADING : LoginViewState()
    class SUCCESS(val payload: UserData) : LoginViewState()
    class FAILURE(val errorMsg: String) : LoginViewState()
}