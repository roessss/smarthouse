package com.example.myapplication.web

import android.util.Log
import com.example.myapplication.data.LightStatus
import com.example.myapplication.data.OpenDoor
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService{
    @GET("get/home/liigt/light_status")
    suspend fun getLightStatus() {}
    @POST("Set/home/light/lights_status")
    suspend fun setLightState(state: LightStatus)
    @GET("get/light/sleep")
    suspend fun getLightStatusSleep() {}
    @POST("set/home/security/open_door")
    suspend fun setLightState(state: OpenDoor)
    @GET("get/home/security/log")
    suspend fun getLightHistory(): Log
}

