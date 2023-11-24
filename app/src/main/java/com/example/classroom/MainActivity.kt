package com.example.classroom

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.classroom.ui.theme.ClassroomTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
        ExperimentalLayoutApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ClassroomTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val drawerState= rememberDrawerState(initialValue = DrawerValue.Closed)

                    ModalNavigationDrawer(drawerContent = {

                        ModalDrawerSheet() {

                            DrawerHeader()
                            Divider(thickness = .5.dp, color = Color.Gray)
                            Column (
                                modifier = Modifier
                                    .verticalScroll(rememberScrollState())
                                    .height(600.dp)
                            ) {

                                    DrawerBody(

                                        items = listOf(
                                            Menuitems (
                                                id = "classes",
                                                title = "Classes",
                                                contentDescription = "go to class",
                                                icon = Icons.Default.Home
                                            ),
                                            Menuitems(
                                                id = "home",
                                                title = "Calendar",
                                                contentDescription = "",
                                                icon = Icons.Default.DateRange
                                            ),
                                            Menuitems(
                                                id = "notification",
                                                title = "Notifications",
                                                contentDescription = "",
                                                icon = Icons.Default.Notifications
                                            ),
                                        ), onItemClick = {

                                            println("Clicked on ${it.title}")
                                        })

                                    Divider(thickness = .5.dp, color = Color.Gray)
                                    DrawerHeader1()

                                    DrawerBody(items = listOf(
                                        Menuitems(
                                            id ="to do",
                                            title ="To do",
                                            contentDescription = "",
                                            icon = Icons.Default.CheckCircle
                                        ),
                                    ), onItemClick = {
                                        println("Clicked on ${it.title}")
                                    })

                                    Divider(thickness = .5.dp, color = Color.Gray)
                                    DrawerBody(items = listOf(
                                        Menuitems(
                                            id ="offline files",
                                            title ="offline files",
                                            contentDescription = "",
                                            icon = Icons.Default.CheckCircle
                                        ),
                                        Menuitems(
                                            id ="Archived classes",
                                            title ="Archived classes",
                                            contentDescription = "",
                                            icon = Icons.Default.ArrowDropDown
                                        ),

                                        Menuitems(
                                            id ="classroom folders",
                                            title ="Classroom folders",
                                            contentDescription = "",
                                            icon = Icons.Default.AccountBox
                                        ),

                                        Menuitems(
                                            id ="settings",
                                            title ="Settings",
                                            contentDescription = "",
                                            icon = Icons.Default.Settings
                                        ),

                                        Menuitems(
                                            id ="help",
                                            title ="Help",
                                            contentDescription = "",
                                            icon = Icons.Default.Info
                                        ),

                                        ), onItemClick = {
                                        println("Clicked on ${it.title}")
                                    })


                            }



                        }
                    },
                        drawerState = drawerState)
                    {
                        val sheetState = rememberModalBottomSheetState()
                        val scope = rememberCoroutineScope()
                        var showBottomSheet by remember { mutableStateOf(false) }
                        Scaffold (

                            topBar = {
                                val coroutineScope = rememberCoroutineScope()

                                AppBar (
                                    onNavigationIconClick = {
                                        coroutineScope.launch {
                                            drawerState.open()
                                        }
                                    }
                                )
                            },

                            floatingActionButton = {
                                FloatingActionButton(onClick = { showBottomSheet = true }) {
                                    Icon(painter = painterResource(id = R.drawable.add), contentDescription = null )
                                }
                            },
                            

                        ){  innerPadding ->

                            if(showBottomSheet){

                                ModalBottomSheet(onDismissRequest = { showBottomSheet = false}){
                                    Column(
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxWidth(),
                                        verticalArrangement = Arrangement.SpaceBetween


                                    ) {
                                        TextButton(onClick = {

                                            val intent = Intent(this@MainActivity,JoinClass::class.java)
                                            startActivity(intent)

                                        }) {
                                            Text(text = "Join Class", style = MaterialTheme.typography.titleMedium,color=Color.Black
                                            )
                                        }
                                        TextButton(onClick = { /*TODO*/ }) {
                                            Text(text = "Create Class", style = MaterialTheme.typography.titleMedium,color=Color.Black)
                                        }
                                    }
                                }
                                
                            }
                            Column(
                                modifier = Modifier
                                    .padding(innerPadding)
                                    .verticalScroll(
                                        rememberScrollState()
                                    ),
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                            ){
                                for (i in 1..13){
                                    ClassCards(title="HELLO WORLD", description = "hello world"
                                    )
                                }

                            }
                        }
                    }
                }

            }
        }
    }
}



