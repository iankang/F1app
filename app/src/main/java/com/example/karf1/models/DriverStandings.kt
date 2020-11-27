package com.example.cartumia.models

import com.example.karf1.models.Constructors
import com.example.karf1.models.Driver
import com.google.gson.annotations.SerializedName


data class DriverStandings (

	@SerializedName("position") val position : Int,
	@SerializedName("positionText") val positionText : Int,
	@SerializedName("points") val points : Int,
	@SerializedName("wins") val wins : Int,
	@SerializedName("Driver") val driver : Driver,
	@SerializedName("Constructors") val constructors : List<Constructors>
)