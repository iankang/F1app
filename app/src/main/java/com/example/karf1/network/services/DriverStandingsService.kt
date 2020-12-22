package com.example.cartumia.network.services

import com.example.cartumia.models.RaceScheduleBase
import com.example.cartumia.network.Endpoints
import com.example.karf1.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface DriverStandingsService {

    @GET(Endpoints.CURRENT_DRIVING_STANDINGS)
    suspend fun getCurrentDriverStandings(): Response<BaseResponse>

    @GET(Endpoints.CURRENT_CONSTRUCTORS_STANDINGS)
    suspend fun getCurrentConstructorStandings():Response<BaseResponseConstructor>

    @GET(Endpoints.CURRENT_SCHEDULE)
    suspend fun getCurrentRaceSchedule():Response<RaceScheduleBase>

    @GET(Endpoints.CURRENT_CIRCUIT_RESULTS)
    suspend fun getSpecificCircuitResults(@Path("circuitId") circuitId:String):Response<BaseResponseCircuitResults>

    @GET(Endpoints.CURRENT_DRIVER_RESULTS)
    suspend fun getSpecificDriverResults(@Path("driverId") circuitId:String):Response<BaseResponseDriverResults>
}