package com.example.karf1.models

import com.google.gson.annotations.SerializedName


data class BaseResponseCircuitResults (

	@SerializedName("MRData") val mRData : MRDataCircuitResults
)