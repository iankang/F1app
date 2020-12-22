package com.example.karf1.models

import com.example.cartumia.models.StandingsTable
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MRDataDriverResults (

	@SerializedName("xmlns") val xmlns : String,
	@SerializedName("series") val series : String,
	@SerializedName("url") val url : String,
	@SerializedName("limit") val limit : Int,
	@SerializedName("offset") val offset : Int,
	@SerializedName("total") val total : Int,
	@SerializedName("RaceTable") val raceTable: RaceDriverResults
):Serializable