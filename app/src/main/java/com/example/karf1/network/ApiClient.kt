package com.example.cartumia.network

import com.example.cartumia.network.services.DriverStandingsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    private lateinit var driverStandingsService: DriverStandingsService

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    fun getStandingsService():DriverStandingsService{

        if(!::driverStandingsService.isInitialized){
            val retrofit = Retrofit.Builder()
                .baseUrl(Endpoints.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient())
                .build()

            driverStandingsService = retrofit.create(DriverStandingsService::class.java)
        }
        return driverStandingsService
    }

    private fun okHttpClient():OkHttpClient{
        return OkHttpClient().newBuilder()
            .connectTimeout(2,TimeUnit.MINUTES)
            .readTimeout(2,TimeUnit.MINUTES)
            .writeTimeout(2,TimeUnit.MINUTES)
            .retryOnConnectionFailure(true)
            .addInterceptor(loggingInterceptor)
            .build()
    }
}