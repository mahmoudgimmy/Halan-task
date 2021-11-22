package com.example.halanchallenge.ui.login.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.halanchallenge.data.local.SharedPreferencesManager
import com.example.halanchallenge.databinding.ActivityLoginBinding
import com.example.halanchallenge.model.LoginCredentials
import com.example.halanchallenge.ui.login.viewmodels.LoginViewModel
import com.example.halanchallenge.ui.login.viewmodels.LoginViewState
import com.example.halanchallenge.ui.productslist.activities.ProductListActivity
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()
    private val sharedPref: SharedPreferencesManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeClickListeners()
        initializeObservers()

    }

    private fun initializeObservers() {
        viewModel.userData.observe(this, {
            renderUi(it)
        })
    }

    private fun renderUi(viewState: LoginViewState) {
        binding.apply {
            when (viewState) {
                is LoginViewState.LOADING -> pbLoading.isVisible = true
                is LoginViewState.SUCCESS -> {
                    pbLoading.isVisible = false
                    sharedPref.saveToken(viewState.payload.token)

                    startActivity(
                        Intent(
                            this@LoginActivity,
                            ProductListActivity::class.java
                        ).apply {
                            putExtra("Profile", viewState.payload.profile)
                        })
                    finish()
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