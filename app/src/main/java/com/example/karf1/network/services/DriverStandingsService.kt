package com.example.cartumia.network.services

import com.example.karf1.models.BaseResponse
import com.example.karf1.models.BaseResponseConstructor
import com.example.cartumia.models.RaceScheduleBase
import com.example.cartumia.network.Endpoints
import retrofit2.Response
import retrofit2.http.GET


interface DriverStandingsService {

    @GET(Endpoints.CURRENT_DRIVING_STANDINGS)
    suspend fun getCurrentDriverStandings(): Response<BaseResponse>

    @GET(Endpoints.CURRENT_CONSTRUCTORS_STANDINGS)
    suspend fun getCurrentConstructorStandings():Response<BaseResponseConstructor>

    @GET(Endpoints.CURRENT_SCHEDULE)
    suspend fun getCurrentRaceSchedule():Response<RaceScheduleBase>
}