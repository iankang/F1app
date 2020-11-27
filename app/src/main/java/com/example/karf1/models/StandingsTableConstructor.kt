package com.example.cartumia.models

import com.example.karf1.models.StandingsListsConstructor
import com.google.gson.annotations.SerializedName

data class StandingsTableConstructor (

	@SerializedName("season") val season : Int,
	@SerializedName("StandingsLists") val standingsLists : List<StandingsListsConstructor>
)