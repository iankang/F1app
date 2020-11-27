package com.example.karf1.models

import com.example.karf1.models.ConstructorStandings
import com.google.gson.annotations.SerializedName


data class StandingsListsConstructor (

	@SerializedName("season") val season : Int,
	@SerializedName("round") val round : Int,
	@SerializedName("ConstructorStandings") val constructorStandings : List<ConstructorStandings>
)