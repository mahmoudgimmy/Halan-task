package com.example.halanchallenge.ui.login.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.halanchallenge.databinding.ActivityLoginBinding
import com.example.halanchallenge.model.LoginCredentials
import com.example.halanchallenge.ui.login.viewmodels.LoginViewModel
import com.example.halanchallenge.ui.login.viewmodels.LoginViewState
import org.koin.android.viewmodel.ext.android.viewModel


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeClickListeners()
        initializeObservers()

    }

    private fun initializeObservers() {
        viewModel.userData.observe(this, Observer {
            renderUi(it)
        })
    }

    private fun renderUi(viewState: LoginViewState) {
        binding.apply {
            when (viewState) {
                is LoginViewState.LOADING -> pbLoading.isVisible = true
                is LoginViewState.SUCCESS -> {
                    pbLoading.isVisible = false
                    viewState.payload
                }

                is LoginViewState.FAILURE -> {
                    pbLoading.isVisible = false
                    Toast.makeText(
                        this@LoginActivity,
                        viewState.errorMsg,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


    }

    private fun initializeClickListeners() {
        binding.apply {
            btnLogin.setOnClickListener {
                viewModel.login(
                    LoginCredentials(
                        userName = etUsername.text.toString(),
                        password = etPassword.text.toString()
                    )
                )
            }
        }
    }
}