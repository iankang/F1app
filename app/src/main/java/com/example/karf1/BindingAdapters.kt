package com.example.karf1

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

@BindingAdapter("age")
fun bindAge(textView:TextView, dateOfBirth:String){
    var formatter = DateTimeFormatter.ofPattern("yyyy-MM-d")
    var localDate = LocalDate.parse(dateOfBirth,formatter)
    var now = LocalDate.now()
    var diff = Period.between(localDate,now)
    textView.setText(diff.years.toString()+ " Years")
}