package com.example.myapplication.web

import com.example.myapplication.data.LightStatus
import com.example.myapplication.data.SecurityLog
import com.example.myapplication.data.TokenRequest
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebClient {
    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()
    var logging: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val okhttp = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    val api = Retrofit.Builder()
        .baseUrl("https://ms.newtonbox.ru/smarthome2/").client(okhttp) // Адрес API, нужно узнать у команды
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiService::class.java)

    suspend fun getLightStatus():LightStatus {
        return withContext(Dispatchers.IO) {
            api.getLightStatus()
        }
    }

    suspend fun setLightState(state: LightStatus) {
        return withContext(Dispatchers.IO) {
            api.setLightState(state)
        }
    }


    suspend fun setOpenDoorState() {
        return withContext(Dispatchers.IO) {
            api.setOpenDoor()
        }
    }
    suspend fun getDoorLog(): SecurityLog{
        return withContext(Dispatchers.IO){
            api.getSecurityLog()
        }
    }
    suspend fun setOpenDoorCall(){
        return withContext(Dispatchers.IO){
            api.setOpenDoorCall()
        }
    }

    suspend fun setToken(token: TokenRequest){
        return withContext(Dispatchers.IO){
            api.setToken(token)
        }
    }


}