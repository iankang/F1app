package com.example.karf1.models

import com.example.karf1.models.Races
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class RaceTableCircuitResults (

	@SerializedName("season") val season : String,
	@SerializedName("circuitId") val circuitId : String,
	@SerializedName("Races") val races : List<RacesCircuitResults>
):Serializable