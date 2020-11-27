package com.example.karf1.ui.driver

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.karf1.models.BaseResponse
import com.example.cartumia.models.DriverStandings
import com.example.cartumia.network.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class DriverStandingsViewModel : ViewModel() {

    val apiClient = ApiClient()

    val job = Job()
    val coroutineScope = CoroutineScope(job + Dispatchers.IO)

    private val _drivers =  MutableLiveData<List<DriverStandings>>()
    val drivers:LiveData<List<DriverStandings>>
        get() = _drivers

    private suspend fun gettingDrivers(): Response<BaseResponse> {
        return apiClient.getStandingsService().getCurrentDriverStandings()
    }

    fun getDrivers(){
        coroutineScope.launch {
            var drivers = gettingDrivers()
            if(drivers?.isSuccessful){
                drivers?.body()?.mRData?.standingsTable?.standingsLists
                    ?.forEach {
                        _drivers.postValue(it.driverStandings)
                    }
            }

        }
    }
}