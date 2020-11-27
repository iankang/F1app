package com.example.cartumia.models

import com.google.gson.annotations.SerializedName


data class MRData (

	@SerializedName("xmlns") val xmlns : String,
	@SerializedName("series") val series : String,
	@SerializedName("url") val url : String,
	@SerializedName("limit") val limit : Int,
	@SerializedName("offset") val offset : Int,
	@SerializedName("total") val total : Int,
	@SerializedName("StandingsTable") val standingsTable : StandingsTable
)