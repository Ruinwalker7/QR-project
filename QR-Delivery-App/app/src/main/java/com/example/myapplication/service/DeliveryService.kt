package com.example.myapplication.service

import com.example.myapplication.config.ResConfig
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import java.io.Serializable

class DeliveryService {
    data class Delivery(val id: String, val status: String, val type: String)

    data class DeliveryDetail(
        val id: String,
        val srcName: String,
        val srcAddress: String,
        val srcPhone: String,
        val dstName: String,
        val dstPhone: String,
        val dstAddress: String,
        val status: String,
        val type: String,
        val name: String,
        val createTime: String
    ) : Serializable

    companion object {
        fun getDelivery(phone: String?, callback: (List<Delivery>?, msg: String?) -> Unit) {
            val urlString = "http://notebook.szkxy.net/app/alldelivery"
            runBlocking {
                Fuel.get(urlString, listOf("phone" to phone))
                    .responseString { _, _, result ->
                        when (result) {
                            is Result.Success -> {
                                val data = result.get() // 获取返回的字符串数据
                                val jsonObject = JSONObject(data)
                                when (jsonObject.getInt("code")) {
                                    ResConfig.Code.OK -> {
                                        try {
                                            println(jsonObject.getString("data"))
                                            val listType =
                                                object : TypeToken<List<Delivery>>() {}.type
                                            val employees: List<Delivery>? = Gson().fromJson(
                                                jsonObject.getString("data"),
                                                listType
                                            )
                                            callback(employees, null)
                                        } catch (e: JsonSyntaxException) {
                                            // JSON 解析异常
                                            println("Error parsing JSON: ${e.message}")
                                        }
                                    }

                                    else -> {
                                        callback(null, "获取快递列表失败")
                                    }
                                }
                            }

                            is Result.Failure -> {
                                val error = result.error
                                println("Request failed. Error: $error")
                                callback(null, "获取快递列表失败")
                            }
                        }
                    }
            }
        }

        fun getSendDelivery(phone: String?, callback: (List<Delivery>?, msg: String?) -> Unit) {
            val urlString = "http://notebook.szkxy.net/app/customer/senddelivery"
            runBlocking {
                Fuel.get(urlString, listOf("phone" to phone))
                    .responseString { _, _, result ->
                        when (result) {
                            is Result.Success -> {
                                val data = result.get() // 获取返回的字符串数据
                                val jsonObject = JSONObject(data)
                                when (jsonObject.getInt("code")) {
                                    ResConfig.Code.OK -> {
                                        try {
                                            println(jsonObject.getString("data"))
                                            val listType =
                                                object : TypeToken<List<Delivery>>() {}.type
                                            val employees: List<Delivery>? = Gson().fromJson(
                                                jsonObject.getString("data"),
                                                listType
                                            )
                                            callback(employees, null)
                                        } catch (e: JsonSyntaxException) {
                                            // JSON 解析异常
                                            println("Error parsing JSON: ${e.message}")
                                        }
                                    }

                                    else -> {
                                        callback(null, "获取快递列表失败")
                                    }
                                }
                            }

                            is Result.Failure -> {
                                val error = result.error
                                println("Request failed. Error: $error")
                                callback(null, "获取快递列表失败")
                            }
                        }
                    }
            }
        }

        fun getReceiverDelivery(phone: String?, callback: (List<Delivery>?, msg: String?) -> Unit) {
            val urlString = "http://notebook.szkxy.net/app/customer/receivedelivery"
            runBlocking {
                Fuel.get(urlString, listOf("phone" to phone))
                    .responseString { _, _, result ->
                        when (result) {
                            is Result.Success -> {
                                val data = result.get() // 获取返回的字符串数据
                                val jsonObject = JSONObject(data)
                                when (jsonObject.getInt("code")) {
                                    ResConfig.Code.OK -> {
                                        try {
                                            println(jsonObject.getString("data"))
                                            val listType =
                                                object : TypeToken<List<Delivery>>() {}.type
                                            val employees: List<Delivery>? = Gson().fromJson(
                                                jsonObject.getString("data"),
                                                listType
                                            )
                                            callback(employees, null)
                                        } catch (e: JsonSyntaxException) {
                                            // JSON 解析异常
                                            println("Error parsing JSON: ${e.message}")
                                        }
                                    }

                                    else -> {
                                        callback(null, "获取快递列表失败")
                                    }
                                }
                            }

                            is Result.Failure -> {
                                val error = result.error
                                println("Request failed. Error: $error")
                                callback(null, "获取快递列表失败")
                            }
                        }
                    }
            }
        }

        //获取某一个快递
        fun getDeliveryDetial(
            phone: String?,
            id: String,
            callback: (DeliveryDetail?, String?) -> Unit
        ) {
            val urlString = "http://notebook.szkxy.net/app/deliverydetail"
            runBlocking {
                Fuel.get(urlString, listOf("phone" to phone, "id" to id))
                    .responseString { _, _, result ->
                        when (result) {
                            is Result.Success -> {
                                val data = result.get() // 获取返回的字符串数据
                                val jsonObject = JSONObject(data)
                                when (jsonObject.getInt("code")) {
                                    ResConfig.Code.OK -> {
                                        try {
                                            println(jsonObject.getString("data"))
                                            val detail: DeliveryDetail? = Gson().fromJson(
                                                jsonObject.getString("data"),
                                                DeliveryDetail::class.java
                                            )
                                            callback(detail, null)
                                        } catch (e: JsonSyntaxException) {
                                            callback(null, "获取快递信息失败")
                                            println("Error parsing JSON: ${e.message}")
                                        }
                                    }

                                    ResConfig.Code.NO_AUTH -> callback(null, "您没有该快递权限")
                                    else -> {
                                        callback(null, "获取快递信息失败")
                                    }
                                }
                            }

                            is Result.Failure -> {
                                val error = result.error
                                println("Request failed. Error: $error")
                                callback(null, "获取快递信息失败")
                            }
                        }
                    }
            }
        }

        //获取某一个快递
        fun getCustomerDeliveryDetial(
            phone: String?,
            id: String,
            callback: (DeliveryDetail?, String?) -> Unit
        ) {
            val urlString = "http://notebook.szkxy.net/app/customer/deliverydetail"
            runBlocking {
                Fuel.get(urlString, listOf("phone" to phone, "id" to id))
                    .responseString { _, _, result ->
                        when (result) {
                            is Result.Success -> {
                                val data = result.get() // 获取返回的字符串数据
                                val jsonObject = JSONObject(data)
                                when (jsonObject.getInt("code")) {
                                    ResConfig.Code.OK -> {
                                        try {
                                            println(jsonObject.getString("data"))
                                            val detail: DeliveryDetail? = Gson().fromJson(
                                                jsonObject.getString("data"),
                                                DeliveryDetail::class.java
                                            )
                                            callback(detail, null)
                                        } catch (e: JsonSyntaxException) {
                                            callback(null, "获取快递信息失败")
                                            println("Error parsing JSON: ${e.message}")
                                        }
                                    }

                                    ResConfig.Code.NO_AUTH -> callback(null, "您没有该快递权限")
                                    else -> {
                                        callback(null, "获取快递信息失败")
                                    }
                                }
                            }

                            is Result.Failure -> {
                                val error = result.error
                                println("Request failed. Error: $error")
                                callback(null, "获取快递信息失败")
                            }
                        }
                    }
            }
        }
    }


}