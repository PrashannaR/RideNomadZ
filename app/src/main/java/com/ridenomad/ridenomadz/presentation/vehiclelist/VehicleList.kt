package com.ridenomad.ridenomadz.presentation.vehiclelist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ridenomad.ridenomadz.R
//import com.ridenomad.ridenomadz.presentation.DestinationScreen
//import com.ridenomad.ridenomadz.presentation.navigateTo

@Composable
fun VehicleList(navController: NavController) {
    Column(modifier = Modifier.padding(top = 0.dp, start = 25.dp, end = 25.dp)) {
        Spacer(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
        )
        vehicleList(navController)
    }
}

@Preview
@Composable
fun test() {

}

@Composable
fun topBox() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                border = BorderStroke(width = 1.dp, Color.LightGray),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(top = 5.dp, start = 10.dp, end = 10.dp)
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxHeight()
                .fillMaxWidth(), verticalArrangement = Arrangement.Center
        ) {
            Text(text = "NOIDA", fontSize = 20.sp)
            Text(text = "Oct 01 22 - Oct 02 22", fontWeight = FontWeight.Normal, fontSize = 14.sp)
        }

    }
}

@Composable
fun filterBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                border = BorderStroke(width = 1.dp, Color.LightGray),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Column() {
                Text(text = "Price", fontSize = 18.sp, color = Color.Gray)
                Text(text = "Any Price", fontWeight = FontWeight.Normal, fontSize = 18.sp)
            }
            Column() {
                Text(text = "Type", fontSize = 18.sp, color = Color.Gray)
                Text(text = "Drivable", fontWeight = FontWeight.Normal, fontSize = 18.sp)
            }
            Column() {
                Text(text = "Sort", fontSize = 18.sp, color = Color.Gray)
                Text(text = "Recommended", fontWeight = FontWeight.Normal, fontSize = 18.sp)
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_filter_list_24),
                contentDescription = "filter icon"
            )

        }


    }
}

@Composable
private fun vehicleList(navController: NavController) {
    LazyColumn(modifier = Modifier.padding(top = 0.dp)) {
        items(10) {
            topBox()
            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth()
            )
            filterBar()
            Spacer(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            )

            for (i in 1..80) {
                vehicleCard(navController)
            }
        }
    }
}

@Composable
fun vehicleCard(navController: NavController) {
    Card(elevation = 10.dp, shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(10.dp)
            .wrapContentHeight()
            .clickable(
                onClick = {
                   // navigateTo(navController = navController, DestinationScreen.Home)
                }
            )

    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Card(
                shape = RoundedCornerShape(20.dp), modifier = Modifier
                    .fillMaxWidth()
                    .padding()
                    .height(200.dp), border = BorderStroke(2.dp, color = Color.Black)
            ) {

                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(),
                        painter = painterResource(id = R.drawable.thar_new),
                        contentDescription = "Class Image", contentScale = ContentScale.Crop
                    )
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Thar 4x4",
                            fontSize = 25.sp,
                            modifier = Modifier.padding(bottom = 4.dp, start = 5.dp),
                            fontWeight = FontWeight.Bold, color = Color.White
                        )
                    }
                }
            }
            Text(
                text = "CLass A Camper Van   | Seats- 4,Sleeps- 2   ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp, bottom = 5.dp, top = 5.dp)
            )
            Text(
                text = "Rs 100000/hour",
                fontSize = 17.sp,
                modifier = Modifier.padding(start = 10.dp, bottom = 6.dp),
                fontWeight = FontWeight.Normal
            )
        }
    }


}

