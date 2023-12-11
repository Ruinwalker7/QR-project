package com.example.myapplication.entity

import java.time.LocalDateTime


data class Deliveryman(val id: Long, val username: String, val password: String, val phone: String, val workAddress: String
                       , val idCard: String, val visitSrc: Boolean, val visitDst: Boolean, val visitDelivery: Boolean, val updateTime: LocalDateTime, val createTime: LocalDateTime) {

}