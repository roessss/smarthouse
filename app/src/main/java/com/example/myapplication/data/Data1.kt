package com.example.myapplication.data


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
    val Log: Array<Log>
)

class Log(
    val Date: String,
    val open_door: Int
)
