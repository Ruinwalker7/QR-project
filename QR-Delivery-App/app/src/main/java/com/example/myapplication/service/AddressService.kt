package com.example.myapplication.service

import com.example.myapplication.config.ResConfig
import com.example.myapplication.entity.Address
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import java.net.HttpURLConnection

class AddressService {

    companion object{
        /**
         * 获得用户所有地址
         */
        fun getAddress(id: Long?,  callback: (List<Address>?, msg:String?) -> Unit){
            val urlString = "http://notebook.szkxy.net/app/customer/address"
            runBlocking {
                Fuel.get(urlString, listOf( "id" to id))
                    .responseString { _, _, result ->
                        when(result){
                            is Result.Success -> {
                                val data = result.get() // 获取返回的字符串数据
                                val jsonObject = JSONObject(data)
                                when(jsonObject.getInt("code")){
                                    ResConfig.Code.OK ->{
                                        try {
                                            println(jsonObject.getString("data"))
                                            val listType = object : TypeToken<List<Address>>() {}.type
                                            val address: List<Address>? = Gson().fromJson(jsonObject.getString("data"), listType)
                                            callback(address,null)
                                        } catch (e: JsonSyntaxException) {
                                            println("Error parsing JSON: ${e.message}")
                                        }
                                    }
                                    else ->{
                                        callback(null,"获取地址列表失败")
                                    }
                                }
                            }
                            is Result.Failure -> {
                                val error = result.error
                                println("Request failed. Error: $error")
                                callback(null,"获取地址列表失败")
                            }
                        }
                    }
            }
        }

        /**
         * 保存地址
         */
        fun saveAddress(
            address: Address,
            callback: (msg: String?) -> Unit
        ) {
            val urlString = "http://notebook.szkxy.net/app/customer/saveaddress"
            runBlocking {
                Fuel.post(urlString).jsonBody(Gson().toJson(address))
                    .responseString { _, response, result ->
                        when (result) {
                            is Result.Success -> {
                                val data = result.get() // 获取返回的字符串数据
                                // Code 为 200 表示成功
                                println("Request successful. Response data: $data")
                                val jsonObject = JSONObject(data)
                                when (jsonObject.getInt("code")) {
                                    ResConfig.Code.OK -> {
                                        try {
                                            callback(null)
                                        } catch (e: JsonSyntaxException) {
                                            println("Error parsing JSON: ${e.message}")
                                        }
                                    }
                                    else -> {
                                        callback("当前手机号已被注册")
                                    }
                                }
                            }
                            is Result.Failure -> {
                                val error = result.error
                                println("Request failed. Error: $error")
                                when (response.statusCode) {
                                    HttpURLConnection.HTTP_INTERNAL_ERROR -> callback("服务器错误")
                                    else -> callback("无法连接到服务器")
                                }
                            }
                        }
                    }
            }
        }
    }
}