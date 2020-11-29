package com.example.karf1.ui.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.karf1.models.Races
import java.lang.IllegalArgumentException

class RaceScheduleDetailViewModelFactory(private val races:Races):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RaceScheduleDetailViewModel::class.java)){
            return RaceScheduleDetailViewModel(races) as T
        }
        throw IllegalArgumentException("model not assignable")
    }
}