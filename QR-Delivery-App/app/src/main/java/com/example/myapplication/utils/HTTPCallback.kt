package com.example.myapplication.utils

import com.example.myapplication.entity.Deliveryman

interface HTTPCallback {
    fun onSuccess(deliveryman: Deliveryman?)
    fun onFailure(errorMessage: String?)
}