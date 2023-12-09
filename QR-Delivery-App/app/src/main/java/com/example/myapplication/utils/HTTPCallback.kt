package com.example.myapplication.utils
interface HTTPCallback {
    fun onSuccess()
    fun onFailure(errorMessage: String?)
}