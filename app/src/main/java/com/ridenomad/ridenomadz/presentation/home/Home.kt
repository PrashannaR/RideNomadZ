package com.ridenomad.ridenomadz.presentation.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ridenomad.ridenomadz.R
import com.ridenomad.ridenomadz.presentation.navigation.Screens
import com.ridenomad.ridenomadz.presentation.theme.ui.darkBlue
import com.ridenomad.ridenomadz.presentation.theme.ui.purpleish


@Composable
fun HomeScreen(navController: NavController) {
    Surface(modifier = Modifier, color = Color.White) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),

            ) {
            Profile()
            SearchText()

            RideClass(navController)
            Text(
                text = "We Provide Best Services",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Services()
        }
    }
}


@Composable
private fun Profile() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .fillMaxHeight()
                .clip(CircleShape)
                .padding(0.dp)
                .background(purpleish)
        ) {

        }
        Text(text = "Hi, Aryan", fontSize = 25.sp, modifier = Modifier.padding(15.dp))
    }
}


@Composable
private fun SearchText() {
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


        Text(
            text = "Find best rides for you", fontSize = 20.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 12.dp)
        )
    }
}


@Composable
fun RideClass(navController: NavController) {

    Column() {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(5) {
                CardClass(navController)

                Spacer(modifier = Modifier.fillMaxWidth(0.18f))
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Show All Vehicles",
            fontSize = 15.sp,
            color = purpleish,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable {
                navController.navigate(Screens.VehicleList.route)
            }
        )

    }

}

@Composable
fun CardClass(navController: NavController) {
    Card(shape = RoundedCornerShape(10.dp), elevation = 10.dp, modifier = Modifier
        .width(160.dp)
        .padding(start = 10.dp)
        .height(200.dp)
        .clickable(
            onClick = {

                navController.navigate(Screens.VehicleDesc.route)
            }
        )) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 12.dp),
                painter = painterResource(id = R.drawable.thar_new),
                contentDescription = "Class Image", contentScale = ContentScale.FillHeight
            )
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                Text(
                    text = "Class A Camper ",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Best for 2-3 people",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            }
        }
    }
}


@Composable
private fun Services() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        Row(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            ServicesCard(
                painter = painterResource(id = R.drawable.assistance),
                text = "24X7 assistance"
            )
            Spacer(modifier = Modifier.width(30.dp))
            ServicesCard(
                painter = painterResource(id = R.drawable.rv),
                text = "Live and Travel"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            ServicesCard(
                painter = painterResource(id = R.drawable.phone),
                text = "IOT enabled device"
            )
            Spacer(modifier = Modifier.width(30.dp))
            ServicesCard(
                painter = painterResource(id = R.drawable.compass),
                text = "Tour Guide"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

    }
}


@Composable
fun ServicesCard(painter: Painter, text: String) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 2.dp,
        modifier = Modifier
            .width(150.dp)
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painter, contentDescription = "")

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = text,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )


        }

    }

}






