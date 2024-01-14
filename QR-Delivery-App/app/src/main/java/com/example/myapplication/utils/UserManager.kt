package com.example.myapplication.utils

import android.content.Context
import android.content.SharedPreferences
import java.net.Inet4Address


class UserManager private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    fun saveUserCredentials(id:Long,username: String?, password: String?, phoneNumber: String?, address: String?) {
        val editor = sharedPreferences.edit()
        editor.putLong(KEY_ID,id)
        editor.putString(KEY_USERNAME, username)
        editor.putString(KEY_PASSWORD, password)
        editor.putString(KEY_PHONE_NUMBER, phoneNumber)
        editor.putString(KEY_ADDRESS,address)
        editor.apply()
    }

    fun clearSharedPreferences(context: Context) {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    val username: String?
        get() = sharedPreferences.getString(KEY_USERNAME, "")
    val password: String?
        get() = sharedPreferences.getString(KEY_PASSWORD, "")
    val phoneNumber: String?
        get() = sharedPreferences.getString(KEY_PHONE_NUMBER, "") // 添加其他需要的方法和属性

    val address: String?
        get() = sharedPreferences.getString(KEY_ADDRESS,"")
    val id: Long
        get() = sharedPreferences.getLong(KEY_ID,0)
    companion object {
        private const val PREFERENCES_NAME = "UserPreferences"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"
        private const val KEY_PHONE_NUMBER = "phone_number"
        private const val KEY_ADDRESS = "address"
        private const val KEY_ID = "id"
        private var instance: UserManager? = null

        @Synchronized
        fun getInstance(context: Context): UserManager? {
            if (instance == null) {
                instance = UserManager(context)
            }
            return instance
        }

    }
}