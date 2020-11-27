package com.example.karf1.models

import com.google.gson.annotations.SerializedName


data class Constructors (

	@SerializedName("constructorId") val constructorId : String,
	@SerializedName("url") val url : String,
	@SerializedName("name") val name : String,
	@SerializedName("nationality") val nationality : String
)