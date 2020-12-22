package com.example.karf1.models

import com.google.gson.annotations.SerializedName

data class BaseResponseDriverResults (

	@SerializedName("MRData") val mRData : MRDataDriverResults
)