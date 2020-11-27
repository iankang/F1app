package com.example.karf1.models

import com.google.gson.annotations.SerializedName


data class Driver (

	@SerializedName("driverId") val driverId : String,
	@SerializedName("permanentNumber") val permanentNumber : Int,
	@SerializedName("code") val code : String,
	@SerializedName("url") val url : String,
	@SerializedName("givenName") val givenName : String,
	@SerializedName("familyName") val familyName : String,
	@SerializedName("dateOfBirth") val dateOfBirth : String,
	@SerializedName("nationality") val nationality : String
)