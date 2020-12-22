package com.example.karf1.ui.driver

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.karf1.models.DriverStandings
import java.lang.IllegalArgumentException

class DriverDetailViewModelFactory(private val driverStandings:DriverStandings):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DriverDetailsViewModel::class.java)){
            return DriverDetailsViewModel(driverStandings) as T
        }
        throw IllegalArgumentException("Is not assignable")
    }
}