package com.example.karf1.ui.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cartumia.models.RaceScheduleBase
import com.example.cartumia.network.ApiClient
import com.example.karf1.models.Races
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class RaceScheduleViewModel : ViewModel() {

    val job = Job()
    val coroutineScope = CoroutineScope(job + Dispatchers.IO)

    val apiClient = ApiClient()

    private val _races = MutableLiveData<List<Races>>()
    val races:LiveData<List<Races>>
        get() = _races

    private val _navigateToRaceScheduleDetail = MutableLiveData<Races>()
    val navigateToRaceScheduleDetail :LiveData<Races>
        get() = _navigateToRaceScheduleDetail

    private suspend fun gettingSchedule(): Response<RaceScheduleBase> {
        return apiClient.getStandingsService().getCurrentRaceSchedule()
    }

    fun getSchedule(){
        coroutineScope.launch {
            var schedule = gettingSchedule()
            if(schedule.isSuccessful){
                _races.postValue(schedule?.body()?.mRData?.raceTable?.races)
            }
        }
    }

    fun displayRaceScheduleDetail(races: Races){
        _navigateToRaceScheduleDetail.value = races
    }

    fun displayRaceScheduleDetailCompleted(){
        _navigateToRaceScheduleDetail.value = null
    }
}