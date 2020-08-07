package com.example.myapplication.data


class LightStatus(
    val state: Boolean,
    val levelMin: Int,
    val levelMax: Int
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