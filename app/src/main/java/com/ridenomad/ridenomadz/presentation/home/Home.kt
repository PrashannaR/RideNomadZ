package com.ridenomad.ridenomadz.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.ridenomad.ridenomadz.R

@Composable
fun HomeScreen(){
    Surface(modifier = Modifier, color = Color.White) {
        Column(modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            , verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            profile()
            searchText()

            rideClass()
            services()
        }
    }
}

@Preview
@Composable
fun Home() {
HomeScreen()
}

@Composable
private fun profile(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(1.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier
            .size(40.dp)
            .fillMaxHeight()
            .clip(CircleShape)
            .padding(0.dp)
            .background(color = Color.Cyan)){

        }
        Text(text = "Hi, Aryan", fontSize = 25.sp, modifier = Modifier.padding(15.dp))
        }
    }

@Composable
private fun searchText(){
    Column() {
        var selectedText by remember { mutableStateOf("") }
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp, top = 1.dp),
            label = { Text("Search cities") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Search, "contentDescription",
                )
            }
        )

        
        Text(text = "Find best rides for you", fontSize = 28.sp, fontWeight = FontWeight.Thin)
    }
}

@Composable
fun rideClass(){
    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()){
        items(40){
            cardClass()
            Spacer(modifier = Modifier.fillMaxWidth(0.18f))
        }
    }
}

@Composable
fun cardClass(){
    Card(shape = RoundedCornerShape(10.dp), elevation = 10.dp, modifier = Modifier
        .width(160.dp)
        .padding(start = 10.dp)
        .height(200.dp)) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 12.dp), painter = painterResource(id = R.drawable.ic_baseline_cruelty_free_24), contentDescription ="Class Image" )
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                Text(text ="CLass A Camper ", fontSize = 12.sp, fontWeight = FontWeight.Bold )
                Text(text = "Best for 2-3 people", fontSize = 7.sp, fontWeight = FontWeight.Normal)
            }
        }
    }
}

@Composable
private fun services(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(bottom = 1.dp)) {
        Text(text = "We Provide Best Services", fontSize = 22.sp, textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 10.dp,top=25.dp, bottom = 35.dp))

        cardServices("24 Assistance","Live and Travel")
        Spacer(modifier = Modifier.fillMaxHeight(0.08f))
        cardServices("IOT enabled device","Tour Guide")
    }
}

@Composable
fun cardServices(text1:String,text2:String){
    Row(modifier = Modifier.fillMaxWidth()) {
        Card(shape = RoundedCornerShape(10.dp), elevation = 10.dp, modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(start = 10.dp)
            .height(100.dp)) {
            Column(
                verticalArrangement = Arrangement.Bottom,horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                Image(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .padding(bottom = 1.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_cruelty_free_24),
                    contentDescription ="Class Image" )

                Text(text =text1, color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Thin, textAlign = TextAlign.Center )

            }
        }

        Spacer(modifier = Modifier.fillMaxWidth(0.0f))

        Card(shape = RoundedCornerShape(10.dp), elevation = 10.dp, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
            .height(100.dp)) {
            Column(
                verticalArrangement = Arrangement.Bottom,horizontalAlignment = Alignment.CenterHorizontally
                ,modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                Image(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .padding(bottom = 1.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_cruelty_free_24),
                    contentDescription ="Class Image" )

                Text(text =text2, fontSize = 12.sp, fontWeight = FontWeight.Thin, textAlign = TextAlign.Center )

            }
        }
    }
}




