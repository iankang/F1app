package com.example.karf1.ui.driver

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cartumia.network.ApiClient
import com.example.karf1.models.BaseResponseDriverResults
import com.example.karf1.models.DriverResults
import com.example.karf1.models.DriverStandings
import com.example.karf1.models.RacesDriverResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class DriverDetailsViewModel(val driverStandings: DriverStandings) : ViewModel() {
    val job = Job()
    val coroutineScope = CoroutineScope(job + Dispatchers.IO)

    private val _driverDetailResults = MutableLiveData<List<RacesDriverResults>>()
    val driverDetailResults:LiveData<List<RacesDriverResults>>
        get() = _driverDetailResults

    val apiClient = ApiClient()

    private suspend fun gettingDriverResults(driverId:String):Response<BaseResponseDriverResults>{
        return apiClient.getStandingsService().getSpecificDriverResults(driverId)
    }

    fun getDriverDetails(driverStandings: DriverStandings){
        coroutineScope.launch {
            var results = gettingDriverResults(driverStandings.driver.driverId)
            results?.body()?.toString()?.let { Log.e("results", it) }
            if(results.isSuccessful){
//                results.body()?.toString()?.let { Log.e("driverDetails", it) }
                _driverDetailResults.postValue(results?.body()?.mRData?.raceTable?.races)


            }
        }

    }
}