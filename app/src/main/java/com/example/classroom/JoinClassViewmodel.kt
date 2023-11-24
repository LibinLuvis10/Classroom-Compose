package com.example.classroom

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

class JoinClassViewmodel : ViewModel(){


    val classcode = mutableStateOf("")
    fun updateclasscode(input:String){
        this.classcode.value=input
    }


}

