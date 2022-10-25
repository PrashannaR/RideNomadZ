package com.ridenomad.ridenomadz.presentation.vehiclelist

import androidx.compose.foundation.*
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


@Composable
fun VehicleList(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
        )
        //vehicleList(navController)

        Column {
            topBox()
            filterBar()
            vehicleList()

        }

    }
}

@Preview
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
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Noida, Delhi", fontSize = 16.sp)
            Text(text = "Oct 01 22 - Oct 02 22", fontWeight = FontWeight.Normal, fontSize = 14.sp)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun filterBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                border = BorderStroke(width = 0.25.dp, Color.LightGray),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Column() {
                Text(text = "Price", fontSize = 15.sp, color = Color.Gray)
                Text(text = "Any Price", fontWeight = FontWeight.Normal, fontSize = 12.sp)
            }
            Column() {
                Text(text = "Type", fontSize = 15.sp, color = Color.Gray)
                Text(text = "Drivable", fontWeight = FontWeight.Normal, fontSize = 12.sp)
            }
            Column() {
                Text(text = "Sort", fontSize = 15.sp, color = Color.Gray)
                Text(text = "Recommended", fontWeight = FontWeight.Normal, fontSize = 12.sp)
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_filter_list_24),
                contentDescription = "filter icon"
            )

        }


    }
}

@Preview(showSystemUi = true)
@Composable
//private fun vehicleList(navController: NavController) {
private fun vehicleList() {

    LazyColumn(modifier = Modifier.padding(top = 0.dp)) {
//        items(5) {
//            topBox()
//            Spacer(
//                modifier = Modifier
//                    .height(10.dp)
//                    .fillMaxWidth()
//            )
//            filterBar()
//            Spacer(
//                modifier = Modifier
//                    .height(40.dp)
//                    .fillMaxWidth()
//            )
//
//            for (i in 1..5) {
//                //vehicleCard(navController)
//                vehicleCard()
//            }
//        }

        items(5) {
            vehicleCard()
        }
    }
}

@Composable
//fun vehicleCard(navController: NavController) {
fun vehicleCard() {
    Card(elevation = 0.dp, shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(10.dp)
            .wrapContentHeight()
            .clickable(
                onClick = {
                    //navController.navigate(Screens.VehicleDesc.route)
                }
            )

    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Card(
                shape = RoundedCornerShape(20.dp), modifier = Modifier
                    .fillMaxWidth()
                    .padding()
                    .height(200.dp)
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
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp, bottom = 5.dp, top = 5.dp)
            )
            Text(
                text = "Rs 3000/hour",
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 10.dp, bottom = 6.dp),
                fontWeight = FontWeight.Normal
            )
        }
    }


}

