package com.example.classroom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateClassAppBar(
    onNavigationClick:()->Unit
){
    var showMenu by remember {
        mutableStateOf(false)
    }
    val btncolor = Color(0xFF4cd6f1)
    var createbtnstate by remember {
        mutableStateOf(false)
    }
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        TopAppBar(
            title = {
                Text(text = "Create Class", style = MaterialTheme.typography.titleLarge)
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White,
                titleContentColor = Color.Black
            ),
            navigationIcon = {
                IconButton(onClick = onNavigationClick) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                }
            },
            actions = {
                Button(
                    onClick = { /*TODO*/ }, shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = btncolor
                    ),
                    enabled = createbtnstate
                ) {
                    Text(text = "Create", style = MaterialTheme.typography.titleMedium)
                }
                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null)
                }
                DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Send Google feedback") },
                        onClick = { /*TODO*/ })
                }
            }

        )
    }
}