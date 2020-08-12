package com.example.myapplication.web

import android.util.Log
import com.example.myapplication.data.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService{
    @GET("get/home/light/light_status")
    suspend fun getLightStatus(): LightStatus
    @POST("set/home/light/lights_state")
    suspend fun setLightState(@Body state: LightStatus)
    @GET("get/light/sleep")
    suspend fun getLightStatusSleep(): Sleep
    @POST("set/home/security/open_door")
    suspend fun setOpenDoor()
    @GET("get/home/security/log")
    suspend fun getSecurityLog(): SecurityLog
    @POST("set/home/security/open_door_call")
    suspend fun setDoorCallState()
    @POST("set/home/light/lights_state")
    suspend fun setLightState()
    @POST("set/light/sleep")
    suspend fun setLightSleepState(@Body sleepState:Sleep )

    @POST("set/token")
    suspend fun setToken(@Body token: TokenRequest)

}