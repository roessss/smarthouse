package com.example.myapplication.data


class EnergyHistoryItem(
    val date: String,
    val energy: Int
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
    val min: Int,
    val max: Int
)
class ClimateVlaga(
    val vlaga: Boolean,
    val min: Int,
    val max: Int
)
class ClimatePrinudl(
    val window:Boolean,
    val pechka:Boolean,
    val vlaga:Boolean
)
