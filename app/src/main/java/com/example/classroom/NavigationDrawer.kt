package com.example.classroom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerHeader(){
    Box(
        modifier= Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp)

        ,

        contentAlignment = Alignment.TopStart

    ){
        Text(text =
            buildAnnotatedString {
                 withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)){
                     append("G")
                 }
                withStyle(style = SpanStyle(color = Color.Red,fontWeight = FontWeight.Bold)){
                    append("o")
                }
                withStyle(style = SpanStyle(color = Color.Yellow,fontWeight = FontWeight.Bold)){
                    append("o")
                }
                withStyle(style = SpanStyle(color = Color.Blue,fontWeight = FontWeight.Bold)){
                    append("g")
                }
                withStyle(style = SpanStyle(color = Color.Green,fontWeight = FontWeight.Bold)){
                    append("l")
                }
                withStyle(style = SpanStyle(color = Color.Red,fontWeight = FontWeight.Bold)){
                    append("e")
                }

                withStyle(style = SpanStyle(color = Color.Gray)){
                    append(" Classroom")
                }
            }
            , fontSize = 30.sp,

            modifier = Modifier.padding(start = 15.dp))
    }
}

@Composable
fun DrawerHeader1(){
    Box(
        modifier= Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp)

        ,

        contentAlignment = Alignment.TopStart

    ){
        Text(text = "Enrolled", modifier = Modifier.padding(start = 15.dp),color=Color.Gray, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}

@Composable
fun DrawerBody(
    items:List<Menuitems>,
    modifier: Modifier=Modifier,
    itemTextStyle: TextStyle= TextStyle(fontSize = 18.sp),
    onItemClick:(Menuitems) -> Unit

){
    LazyColumn(modifier,){

        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(item) }
                    .padding(16.dp)

            ){
                Icon(imageVector =  item.icon, contentDescription = item.contentDescription)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = item.title,
                    modifier = Modifier.weight(1f),
                    style = itemTextStyle)
            }
        }
    }
}



