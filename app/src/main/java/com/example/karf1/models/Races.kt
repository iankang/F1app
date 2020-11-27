package com.example.karf1.models

import com.example.karf1.models.Circuit
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Races (

    @SerializedName("season") val season : Int,
    @SerializedName("round") val round : Int,
    @SerializedName("url") val url : String,
    @SerializedName("raceName") val raceName : String,
    @SerializedName("Circuit") val circuit : Circuit,
    @SerializedName("date") val date : String,
    @SerializedName("time") val time : String
):Serializable