package com.example.cartumia.models

import com.example.karf1.models.RaceTable
import com.google.gson.annotations.SerializedName


data class MRDataRace (

	@SerializedName("xmlns") val xmlns : String,
	@SerializedName("series") val series : String,
	@SerializedName("url") val url : String,
	@SerializedName("limit") val limit : Int,
	@SerializedName("offset") val offset : Int,
	@SerializedName("total") val total : Int,
	@SerializedName("RaceTable") val raceTable: RaceTable
)