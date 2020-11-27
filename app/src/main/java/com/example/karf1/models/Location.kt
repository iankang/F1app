package com.example.karf1.models

import com.google.gson.annotations.SerializedName


data class Location (

	@SerializedName("lat") val lat : Double,
	@SerializedName("long") val long : Double,
	@SerializedName("locality") val locality : String,
	@SerializedName("country") val country : String
)