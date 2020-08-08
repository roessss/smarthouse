package com.example.myapplication.web

import com.example.myapplication.data.LightStatus
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebClient {
    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()


    val api = Retrofit.Builder()
        .baseUrl("") // Адрес API, нужно узнать у команды
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiService::class.java)

    suspend fun getLightState():LightStatus {
        return withContext(Dispatchers.IO) {
            api.getLightState()
        }
    }

    suspend fun setLightState(state: LightStatus) {
        return withContext(Dispatchers.IO) {
            api.setLightStatus(state)
        }
    }
}

