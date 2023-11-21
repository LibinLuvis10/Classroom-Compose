package com.example.classroom

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ContactViewmodel(
    val name:String

):ViewModel() {

    var backgroundcolor by mutableStateOf(Color.White)
        private set


    fun changebackgroundcolor(){
        backgroundcolor=Color.Red
    }


}