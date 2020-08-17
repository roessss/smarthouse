package com.example.myapplication.web

import com.example.myapplication.data.*
import retrofit2.http.GET
import retrofit2.http.POST

interface inteface {
    @POST("set/home/climate/temp")
    suspend fun setClimateTemp (state: ClimateTemp)
    @POST("set/home/climate/vlaga")
    suspend fun setClimateVlaga (state: ClimateVlaga)
    @GET("get/home/climate/data")
    suspend fun getClimateData(): ClimateData
    @GET("get/home/energy/history")
    suspend fun getEnergyHistory():EnergyHistory
    @POST("set/home/climate/prinudl")
    suspend fun pushClimatePrinudl (state: ClimatePrinudl)

}


