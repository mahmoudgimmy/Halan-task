package com.example.halanchallenge.ui.login.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.halanchallenge.model.Credentials
import com.example.halanchallenge.ui.login.repositories.ILoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: ILoginRepository):ViewModel() {
    private val _userData = MutableLiveData<LoginViewState>()
    val userData: LiveData<LoginViewState> = _userData

    fun login(credentials: Credentials) = viewModelScope.launch {
        try {
            _userData.value = LoginViewState.LOADING

            val result = repository.login(credentials)
            _userData.value = LoginViewState.SUCCESS(result)
        }
        catch (e:Exception){
            _userData.value = LoginViewState.FAILURE(e.message!!)
        }

    }
}