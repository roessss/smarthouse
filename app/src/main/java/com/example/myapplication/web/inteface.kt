package com.example.myapplication.web

import com.example.myapplication.data.EnergyHistory
import com.example.myapplication.data.ClimateData
import com.example.myapplication.data.ClimateTemp
import com.example.myapplication.data.ClimateVlaga
import retrofit2.http.GET
import retrofit2.http.POST

interface inteface {
    @POST("push/home/climate/temp")
    suspend fun pushClimateTemp (state: ClimateTemp)
    @POST("push/home/climate/vlaga")
    suspend fun pushClimateVlaga (state: ClimateVlaga)
    @GET("get/home/climate/data")
    suspend fun getClimateData(): ClimateData
    @GET("get/home/energy/history")
    suspend fun getEnergyHistory():EnergyHistory


}

