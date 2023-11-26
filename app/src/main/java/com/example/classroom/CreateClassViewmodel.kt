package com.example.classroom

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CreateClassViewmodel: ViewModel() {
    var classname = mutableStateOf("")

    fun updateclassname(input:String){
        this.classname.value = input
    }
}