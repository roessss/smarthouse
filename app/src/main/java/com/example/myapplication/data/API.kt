package com.example.myapplication.data


class EnergyHistoryItem(
    val date: String,
    val light: Int
)




class EnergyHistory(
    val history: Array<EnergyHistoryItem>
)



class ClimateDataItem(
    val date: String,
    val light: Int
)




class ClimateData(
    val history: Array<ClimateDataItem>
)
class ClimateTemp(
    val tempcomnata: Boolean,
    val minLight: Int,
    val maxLight: Int
)
class ClimateVlaga(
    val vlaga: Boolean,
    val minLight: Int,
    val maxLight: Int
)
class ClimatePrinudl(
    val window:Boolean,
    val pechka:Boolean,
    val vlaga:Boolean
)
