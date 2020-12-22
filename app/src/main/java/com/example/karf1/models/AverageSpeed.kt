package com.example.karf1.models

import com.google.gson.annotations.SerializedName

data class AverageSpeed (

	@SerializedName("units") val units : String,
	@SerializedName("speed") val speed : Double
)