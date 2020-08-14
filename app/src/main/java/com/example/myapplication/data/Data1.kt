package com.example.myapplication.data

import com.google.gson.annotations.SerializedName


class LightStatus(
    val state: Boolean,
    val level_min: Int,
    val level_max: Int
)

class Sleep(
    val sleepMode: Boolean,
    val hour: Int,
    val minute: Int
)

class OpenDoor(
    val date: Int,
    val openDoor: Boolean
)

class SecurityLog(
   @SerializedName("Log") val Log: List<Log>
)

class Log(
    @SerializedName("Date") val Date: String,
    @SerializedName("open_door") val open_door: List<Float>
){
    override fun toString(): String {
        return "Log(Date='$Date', open_door=$open_door)"
    }
}



