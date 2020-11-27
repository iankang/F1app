package com.example.cartumia.models

import com.google.gson.annotations.SerializedName

data class StandingsTable (

	@SerializedName("season") val season : Int,
	@SerializedName("StandingsLists") val standingsLists : List<StandingsLists>
)