package com.example.karf1.models

import com.example.karf1.models.Races
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class RaceTable (

	@SerializedName("season") val season : Int,
	@SerializedName("Races") val races : List<Races>
):Serializable