package com.example.myapplication.web

import android.util.Log
import com.example.myapplication.data.LightStatus
import com.example.myapplication.data.OpenDoor
import com.example.myapplication.data.SecurityLog
import com.example.myapplication.data.Sleep
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService{
    @POST("Set/home/light/lights_status")
    suspend fun setLightStatus(state: LightStatus)
    @GET("get/light/sleep")
    suspend fun getLightStatusSleep(): Sleep
    @POST("set/home/security/open_door")
    suspend fun setDoorState(state: OpenDoor)
    @GET("get/home/security/log")
    suspend fun getLightHistory(): SecurityLog
    @POST("set/home/security/open_door_call")
    suspend fun setDoorCallState()
    @POST("set/home/light/lights_state")
    suspend fun setLightState()
    @POST("set/light/sleep")
    suspend fun setLightSleepState(sleepState:Sleep )
    @GET("get/home/light/lights_state")
    suspend fun getLightState(): LightStatus

}

