package com.example.myapplication.entity

import java.time.LocalDateTime

data class Delivery(
    val id: Long?,
    val srcAddressId: Long?,
    val dstAddressId: Long?,
    val status: String?,
    val type: String?,
    val deliverymanId: Long?,
    val createTime: LocalDateTime?,
    val updateTime: LocalDateTime?
) {}
