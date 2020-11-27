package com.example.karf1.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ConstructorStandings (

	@SerializedName("position") val position : Int,
	@SerializedName("positionText") val positionText : Int,
	@SerializedName("points") val points : Int,
	@SerializedName("wins") val wins : Int,
	@SerializedName("Constructor") val constructor : Constructor
):Serializable