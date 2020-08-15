package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

class TokenRequest(@SerializedName("deviceToken") val deviceToken: String)
