package com.example.karf1.models

import com.google.gson.annotations.SerializedName


data class CircuitResultsFastestLap (

        @SerializedName("rank") val rank : Int,
        @SerializedName("lap") val lap : Int,
        @SerializedName("Time") val circuitResultsTime : CircuitResultsTime,
        @SerializedName("AverageSpeed") val circuitResultsAverageSpeed : CircuitResultsAverageSpeed
)