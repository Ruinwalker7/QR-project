package com.example.myapplication.utils

import android.os.Parcel
import android.os.Parcelable
import com.example.myapplication.config.ResConfig
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import java.io.Serializable

class GetDeliverys {
    data class Delivery(val id: String, val status:String)

    data class DeliveryDetail(val id: String, val src_name:String,val src_address:String, val src_phone:String, val dst_name:String, val dst_phone:String, val dst_address:String,
        val status: String, val type: String, val name: String): Serializable
    fun getDelivery(phone: String?,  callback: (List<Delivery>?, msg:String?) -> Unit){
        val urlString = "http://192.168.3.26:8080/app/alldelivery"

        runBlocking {
            Fuel.get(urlString, listOf( "phone" to phone))
                .responseString { _, _, result ->
                    when(result){
                        is Result.Success -> {
                            val data = result.get() // 获取返回的字符串数据
                            val jsonObject = JSONObject(data)
                            when(jsonObject.getInt("code")){
                                ResConfig.Code.OK ->{
                                    try {
                                        println(jsonObject.getString("data"))
                                        val listType = object : TypeToken<List<Delivery>>() {}.type
                                        val employees: List<Delivery>? = Gson().fromJson(jsonObject.getString("data"), listType)
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


    fun getDeliveryDetial(phone: String?,id: String,  callback: (DeliveryDetail?, msg:String?) -> Unit){
        val urlString = "http://192.168.3.26:8080/app/deliverydetail"

        runBlocking {
            Fuel.get(urlString, listOf( "phone" to phone,"id" to id))
                .responseString { _, _, result ->
                    when(result){
                        is Result.Success -> {
                            val data = result.get() // 获取返回的字符串数据
                            val jsonObject = JSONObject(data)
                            when(jsonObject.getInt("code")){
                                ResConfig.Code.OK ->{
                                    try {
                                        println(jsonObject.getString("data"))
                                        val detail: DeliveryDetail? = Gson().fromJson(jsonObject.getString("data"), DeliveryDetail::class.java)
                                        callback(detail,null)
                                    } catch (e: JsonSyntaxException) {
                                        callback(null,"获取快递信息失败")
                                        println("Error parsing JSON: ${e.message}")
                                    }
                                }
                                else ->{
                                    callback(null,"获取快递信息失败")
                                }
                            }
                        }
                        is Result.Failure -> {
                            val error = result.error
                            println("Request failed. Error: $error")
                            callback(null,"获取快递信息失败")
                        }
                    }
                }
        }
    }
}