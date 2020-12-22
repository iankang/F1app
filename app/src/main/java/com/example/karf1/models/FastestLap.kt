package com.example.karf1.models

import com.google.gson.annotations.SerializedName


data class FastestLap (

	@SerializedName("rank") val rank : Int,
	@SerializedName("lap") val lap : Int,
	@SerializedName("Time") val time : Time,
	@SerializedName("AverageSpeed") val averageSpeed : AverageSpeed
)