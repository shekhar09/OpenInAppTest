package com.shekhar.kotlin.data.local

import android.content.Context
import android.content.SharedPreferences
import com.shekhar.kotlin.utils.common.SHARED_PREFERENCES_IS_LOGIN
import com.shekhar.kotlin.utils.common.SHARED_PREFERENCES_SESSION
import com.shekhar.kotlin.utils.common.SHARED_PREFERENCES_USER_TOKEN
import com.shekhar.kotlin.utils.common.token
import javax.inject.Inject



class LocalData @Inject constructor(val context: Context) {

    private val sharedSessionPref: SharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES_SESSION, Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = sharedSessionPref.edit()

    fun getCachedLogin(): Boolean {
        return sharedSessionPref.getBoolean(SHARED_PREFERENCES_IS_LOGIN, false)
    }

    fun setCachedLogin(isLoggedIn: Boolean) {
        editor.putBoolean(SHARED_PREFERENCES_IS_LOGIN, isLoggedIn)
        editor.apply()
    }

    fun getUserToken(): String {
        val cache = sharedSessionPref.getString(SHARED_PREFERENCES_USER_TOKEN, token)
        return "Bearer $cache"
    }
    fun setUserToken(token: String) {
        editor.putString(SHARED_PREFERENCES_USER_TOKEN, token)
        editor.apply()
    }

}

