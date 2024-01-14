package com.example.myapplication.entity

data class Address(
    val id: Long? = null,
    val name: String? = null,
    val phone: String? = null,
    val province: String? = null,
    val city: String? = null,
    val county: String? = null,
    val addressDetail: String? = null,
    val customerId: Long? = 0,
    val createTime: String? = null,
    val updateTime: String? = null
) {
    val address: String
        get() = "$province $city $county $addressDetail"
}
