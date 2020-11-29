package com.example.karf1.ui.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cartumia.network.ApiClient
import com.example.karf1.models.BaseResponseCircuitResults
import com.example.karf1.models.CircuitResults
import com.example.karf1.models.Races
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class RaceScheduleDetailViewModel(val races:Races) : ViewModel() {
    val job = Job()
    val coroutineScope = CoroutineScope(job + Dispatchers.IO)

    val apiClient = ApiClient()

    private val _circuitResults = MutableLiveData< List<CircuitResults>>()
    val circuitResults:LiveData< List<CircuitResults>>
        get() = _circuitResults

    private suspend fun gettingCircuitResults(circuitId:String): Response<BaseResponseCircuitResults>{
        return apiClient.getStandingsService().getSpecificCircuitResults(circuitId)
    }

    fun getCircuitResults(races: Races){
        val circuitId = races.circuit.circuitId
        coroutineScope.launch {
            var result = gettingCircuitResults(circuitId)
            if(result?.isSuccessful){
                result?.body()?.mRData?.raceTable?.races?.forEach {
                    _circuitResults.postValue(it?.results)
                }
            }
        }
    }
}