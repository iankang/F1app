package com.example.karf1.models

import com.example.karf1.models.Races
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class RaceDriverResults (

	@SerializedName("season") val season : String,
	@SerializedName("driverId") val driverId : String,
	@SerializedName("Races") val races : List<RacesDriverResults>
):Serializable