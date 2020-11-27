package com.example.karf1.ui.constructors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.karf1.models.BaseResponseConstructor
import com.example.karf1.models.ConstructorStandings
import com.example.cartumia.network.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class ConstructorsStandingViewModel : ViewModel() {


    val job = Job()
    val coroutineScope = CoroutineScope(job + Dispatchers.IO)

    val apiClient = ApiClient()

    private val _constructors = MutableLiveData<List<ConstructorStandings>>()
    val constructor:LiveData<List<ConstructorStandings>>
        get() = _constructors

    private val _navigateToSelectedConstructor = MutableLiveData<ConstructorStandings>()
    val navigateToSelectedConstructor:LiveData<ConstructorStandings>
        get() = _navigateToSelectedConstructor

    private suspend fun gettingConstructors(): Response<BaseResponseConstructor> {
        return apiClient.getStandingsService().getCurrentConstructorStandings()
    }

    fun getConstructors(){
        coroutineScope.launch {
            var constructors = gettingConstructors()
            if(constructors.isSuccessful){
                constructors?.body()?.mRData?.standingsTable?.standingsLists?.forEach {
                    _constructors.postValue(it.constructorStandings)
                }
            }
        }
    }

    fun displayConstructorDetails(constructorStandings: ConstructorStandings){
        _navigateToSelectedConstructor.value = constructorStandings
    }

    fun displayConstructorDetailsComplete(){
        _navigateToSelectedConstructor.value = null
    }
}