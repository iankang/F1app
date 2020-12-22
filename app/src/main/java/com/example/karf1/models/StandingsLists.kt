package com.example.cartumia.models

import com.example.karf1.models.DriverStandings
import com.google.gson.annotations.SerializedName


data class StandingsLists (

	@SerializedName("season") val season : Int,
	@SerializedName("round") val round : Int,
	@SerializedName("DriverStandings") val driverStandings : List<DriverStandings>
)