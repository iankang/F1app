package com.example.karf1.models

import com.example.cartumia.models.MRDataConstructor
import com.google.gson.annotations.SerializedName


data class BaseResponseConstructor (

	@SerializedName("MRData") val mRData : MRDataConstructor
)