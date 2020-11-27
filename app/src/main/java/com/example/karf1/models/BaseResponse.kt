package com.example.karf1.models

import com.example.cartumia.models.MRData
import com.google.gson.annotations.SerializedName


data class BaseResponse (

	@SerializedName("MRData") val mRData : MRData
)