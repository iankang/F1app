package com.example.karf1.models

import com.example.karf1.models.Location
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Circuit (

	@SerializedName("circuitId") val circuitId : String,
	@SerializedName("url") val url : String,
	@SerializedName("circuitName") val circuitName : String,
	@SerializedName("Location") val location : Location
):Serializable