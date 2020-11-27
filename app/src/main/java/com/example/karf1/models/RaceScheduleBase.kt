package com.example.cartumia.models

import com.google.gson.annotations.SerializedName


data class RaceScheduleBase (

	@SerializedName("MRData") val mRData : MRDataRace
)