package com.example.halanchallenge.ui.login.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.halanchallenge.model.LoginCredentials
import com.example.halanchallenge.ui.login.repositories.ILoginRepo
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: ILoginRepo):ViewModel() {
    private val _userData = MutableLiveData<LoginViewState>()
    val userData: LiveData<LoginViewState> = _userData

    fun login(loginCredentials: LoginCredentials) = viewModelScope.launch {
        try {
            _userData.value = LoginViewState.LOADING

            val result = repo.login(loginCredentials)
            _userData.value = LoginViewState.SUCCESS(result)
        }
        catch (e:Exception){
            _userData.value = LoginViewState.FAILURE(e.message!!)
        }

    }
}