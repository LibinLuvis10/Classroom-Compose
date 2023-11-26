package com.example.classroom

import android.content.Intent
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.Placeholder
import com.example.classroom.ui.theme.ClassroomTheme
import kotlinx.coroutines.launch

class JoinClass : ComponentActivity() {

    private val viewModel:JoinClassViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClassroomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold (
                        topBar = {
                            val coroutineScope = rememberCoroutineScope()

                            JoinclassAppBar(onNavigationClick = {
                                coroutineScope.launch {
                                   val intent = Intent(this@JoinClass,MainActivity::class.java)
                                    startActivity(intent)
                                }
                            })

                        }
                    ){ innerPadding ->
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(20.dp)
                                .verticalScroll(rememberScrollState())
                        ) {

                            Spacer(modifier = Modifier.height(20.dp))
                            Text(text = "You're currently signed in as", style = MaterialTheme.typography.titleLarge, color = Color.Black)
                            Spacer(modifier = Modifier.height(20.dp))
                            Row {
                                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                                Spacer(modifier = Modifier.width(15.dp))
                                Column {
                                    Text(text = "Account Name", style = MaterialTheme.typography.titleMedium, color = Color.Black)
                                    Text(text = "email", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                                }
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Divider(thickness = 0.5.dp)
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(text = "Ask your teacher for the class code, then enter it here.")
                            Spacer(modifier = Modifier.height(25.dp))
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                val code = viewModel.classcode.value
                                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                                    value = code, label = {Text(text = "Class code")},
                                    onValueChange = {newValue->viewModel.updateclasscode(newValue)})
                            }
                            Spacer(modifier = Modifier.height(30.dp))
                            Text(text = "To sign in with a class code", style = MaterialTheme.typography.titleLarge, color = Color.Black)
                            Spacer(modifier = Modifier.height(25.dp))
                            Row(horizontalArrangement = Arrangement.Center) {
                                Text(text = ".", style = MaterialTheme.typography.titleLarge)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(text = "Use an authorised account", style = MaterialTheme.typography.titleMedium)
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Row(horizontalArrangement = Arrangement.Center) {
                                Text(text = ".", style = MaterialTheme.typography.titleLarge)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(text = "Use an class code, with 6-7 letters and numbers, and no spaces or symbols",style = MaterialTheme.typography.titleMedium)
                                Spacer(modifier = Modifier.height(25.dp))
                            }
                        }
                    }

                }
            }
        }
    }
}

