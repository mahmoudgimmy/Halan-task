package com.example.halanchallenge.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {
    private val sharedPref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    fun saveToken(token: String): SharedPreferences.Editor =
        sharedPref.edit().apply {
            putString(TOKEN, token)
            apply()
        }

    fun getToken(): String = sharedPref.getString(TOKEN, "") ?: ""

    companion object {
        private const val PREFERENCE_NAME = "halan_pref"
        private const val TOKEN = "token"
    }

}