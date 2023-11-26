package com.example.classroom

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.classroom.ui.theme.ClassroomTheme
import kotlinx.coroutines.launch

class CreateClass : ComponentActivity() {

    private val viewModel:CreateClassViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            ClassroomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Scaffold(
                            topBar = {
                                val coroutineScope = rememberCoroutineScope()

                                CreateClassAppBar(onNavigationClick = {
                                    coroutineScope.launch {
                                        val intent = Intent(this@CreateClass,MainActivity::class.java)

                                        startActivity(intent)
                                    }
                                })
                            }

                        ){
                            innerPadding ->

                            Column(
                                modifier = Modifier
                                    .padding(innerPadding).fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally

                            ) {
                                val classname = viewModel.classname.value
                                Spacer(modifier = Modifier.height(50.dp))
                                TextField(value = classname, onValueChange = {newValue->viewModel.updateclassname(newValue)}, label = { Text("Class name")})
                            }
                        }
                    }
                }
            }
        }
    }
}

