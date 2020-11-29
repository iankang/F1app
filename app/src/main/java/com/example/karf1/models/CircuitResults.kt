package com.example.karf1.models

import com.google.gson.annotations.SerializedName


data class CircuitResults (

		@SerializedName("number") val number : Int,
		@SerializedName("position") val position : Int,
		@SerializedName("positionText") val positionText : String,
		@SerializedName("points") val points : Int,
		@SerializedName("Driver") val driver : Driver,
		@SerializedName("Constructor") val constructor : Constructor,
		@SerializedName("grid") val grid : Int,
		@SerializedName("laps") val laps : Int,
		@SerializedName("status") val status : String,
		@SerializedName("Time") val time : CircuitResultsTime,
		@SerializedName("FastestLap") val fastestLap : CircuitResultsFastestLap
)