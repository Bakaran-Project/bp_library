package com.bp.library.data

import android.content.SharedPreferences

class SharedPref(
    private val sharedPreferences: SharedPreferences
) {
    fun checkIsLoggedIn():Boolean {
        return sharedPreferences.getBoolean("isLoggedIn",false)
    }

     val  getLanguage:String=""
}