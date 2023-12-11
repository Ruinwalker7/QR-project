package com.example.myapplication.utils

import com.example.myapplication.config.ResConfig
import com.example.myapplication.entity.Deliveryman
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import java.net.HttpURLConnection
import java.time.LocalDateTime

class getDelivery {
    data class delivery(val id: String, val status:String)

    fun getDelivery(phone: String?,  callback: (List<delivery>?, msg:String?) -> Unit){
        val urlString = "http://192.168.3.26:8080/app/alldelivery"

        runBlocking {
            Fuel.get(urlString, listOf( "phone" to phone))
                .responseString { _, response, result ->
                    when(result){
                        is Result.Success -> {
                            val data = result.get() // 获取返回的字符串数据
                            println("Request successful. Response data: $data")
                            val jsonObject = JSONObject(data)
                            when(jsonObject.getInt("code")){
                                ResConfig.Code.OK ->{
                                    try {
                                        println(jsonObject.getString("data"))
                                        val listType = object : TypeToken<List<delivery>>() {}.type
                                        val employees: List<delivery>? = Gson().fromJson(jsonObject.getString("data"), listType)
                                        callback(employees,null)
                                    } catch (e: JsonSyntaxException) {
                                        // JSON 解析异常
                                        println("Error parsing JSON: ${e.message}")
                                    }
                                }
                                else ->{
                                    callback(null,"获取快递列表失败")
                                }
                            }
                        }
                        is Result.Failure -> {
                            val error = result.error
                            println("Request failed. Error: $error")
                            callback(null,"获取快递列表失败")
                        }
                    }
                }
        }
    }
}