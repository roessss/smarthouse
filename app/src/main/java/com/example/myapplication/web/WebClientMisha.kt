package com.example.myapplication.web

import com.example.myapplication.data.*

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebClientMisha {

    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()


    val api = Retrofit.Builder()
        .baseUrl("https://ms.newtonbox.ru/smarthome2/") // Адрес API, нужно узнать у команды
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(inteface::class.java)


    suspend fun getClimateData(): ClimateData {
        return withContext(Dispatchers.IO) {
            api.getClimateData()
        }
    }

    suspend fun getEnergyHistory(): EnergyHistory {
        return withContext(Dispatchers.IO) {
            api.getEnergyHistory()
        }
    }
}