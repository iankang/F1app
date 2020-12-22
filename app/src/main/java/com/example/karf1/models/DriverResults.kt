package com.example.karf1.models

import com.google.gson.annotations.SerializedName


data class DriverResults (

	@SerializedName("number") val number : String,
	@SerializedName("position") val position : String,
	@SerializedName("positionText") val positionText : String,
	@SerializedName("points") val points : String,
	@SerializedName("Driver") val driver : Driver,
	@SerializedName("Constructor") val constructor : Constructor,
	@SerializedName("grid") val grid : String,
	@SerializedName("laps") val laps : String,
	@SerializedName("status") val status : String,
	@SerializedName("FastestLap") val fastestLap : FastestLap
)