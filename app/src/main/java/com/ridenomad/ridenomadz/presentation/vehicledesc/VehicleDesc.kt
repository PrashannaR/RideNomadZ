package com.ridenomad.ridenomadz.presentation.vehicledesc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ridenomad.ridenomadz.R
import com.ridenomad.ridenomadz.presentation.navigation.Screens
import com.ridenomad.ridenomadz.presentation.theme.ui.backgroundColor
import com.ridenomad.ridenomadz.presentation.theme.ui.fontColor
import com.ridenomad.ridenomadz.presentation.theme.ui.purpleish


@Composable
fun VehicleDesc(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(rememberScrollState()),

        ) {

        Box(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.samplerv),
                contentDescription = "RV image"
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = purpleish
                )
            ) {
                Text(text = "Explore Vehicle", fontWeight = FontWeight.SemiBold)

            }
        }


        Row(modifier = Modifier.padding(start = 20.dp, top = 16.dp)) {
            //vehicle name
            Column(
                modifier = Modifier,

                ) {
                Text(
                    text = "Bolero Camper 360",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = fontColor,
                    modifier = Modifier.align(Alignment.Start)
                )

                Text(
                    text = "Class A camper, Indore",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = fontColor,
                    modifier = Modifier.align(Alignment.Start)
                )

            }

            //reviews
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(top = 5.dp, start = 65.dp, end = 16.dp)
            ) {
                Row(
                    modifier = Modifier.align(Alignment.End),
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_star_24),
                        contentDescription = "Star",
                    )
                    Text(
                        text = "5.0",
                        fontSize = 18.sp,
                        color = purpleish,
                        fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(start = 5.dp),

                        )

                }

                Text(
                    text = "20 reviews",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = purpleish
                )

            }

        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Mahindra Bolero Camper is a 5 seater pickup-truck available in a price range of Rs. 9.27 - 9.76 Lakh*. It is available in 3 variants, a 2523 cc, BS6.",
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify,
            color = fontColor
        )

        Spacer(modifier = Modifier.height(20.dp))

        //features
        Text(
            text = "Features",
            modifier = Modifier.padding(start = 20.dp, bottom = 12.dp),
            color = fontColor, fontWeight = FontWeight.Bold, fontSize = 25.sp
        )

        FeatureWithImage(
            painter = painterResource(id = R.drawable.ic_baseline_airline_seat_recline_extra_24),
            contentDescription = "",
            title = "4 seatbelts"
        )

        FeatureWithImage(
            painter = painterResource(id = R.drawable.bed),
            contentDescription = "",
            title = "1 bed (2 people can sleep)"
        )

        FeatureWithImage(
            painter = painterResource(id = R.drawable.bidirectional_arrow),
            contentDescription = "",
            title = "18.0 ft long"
        )

        FeatureWithImage(
            painter = painterResource(id = R.drawable.bidirectional_arrow),
            contentDescription = "",
            title = "Fuel type: diesel"
        )

        Text(
            text = "Show all 7 features",
            modifier = Modifier.padding(start = 20.dp, bottom = 12.dp),
            color = purpleish, fontWeight = FontWeight.SemiBold, fontSize = 18.sp
        )

        //amenities

        Row() {
            Text(
                text = "Amenities",
                modifier = Modifier.padding(start = 20.dp, bottom = 12.dp),
                color = fontColor, fontWeight = FontWeight.Bold, fontSize = 25.sp
            )

            Spacer(modifier = Modifier.width(160.dp))

            Row(modifier = Modifier.padding(end = 16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_add_circle_24),
                    contentDescription = "",
                    modifier = Modifier.padding(top = 5.dp)
                )

                Text(
                    text = "Add on",
                    color = purpleish,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 5.dp)
                )

            }


        }

        FeatureWithImage(
            painter = painterResource(id = R.drawable.ic_baseline_airline_seat_recline_extra_24),
            contentDescription = "",
            title = "4 seatbelts"
        )

        FeatureWithImage(
            painter = painterResource(id = R.drawable.bed),
            contentDescription = "",
            title = "1 bed (2 people can sleep)"
        )

        FeatureWithImage(
            painter = painterResource(id = R.drawable.bidirectional_arrow),
            contentDescription = "",
            title = "18.0 ft long"
        )

        FeatureWithImage(
            painter = painterResource(id = R.drawable.bidirectional_arrow),
            contentDescription = "",
            title = "Fuel type: diesel"
        )

        Text(
            text = "Show all 18 amenities",
            modifier = Modifier.padding(start = 20.dp, bottom = 12.dp),
            color = purpleish, fontWeight = FontWeight.SemiBold, fontSize = 18.sp
        )

        Button(
            onClick = {
                navController.navigate(Screens.SignUp.route)
            },
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp))
                .fillMaxWidth(.80f)
                .height(70.dp)
                .align(CenterHorizontally)
                .padding(bottom = 12.dp),

            colors = ButtonDefaults.buttonColors(
                backgroundColor = purpleish,
                contentColor = Color.White
            )
        ) {
            Text(text = "Book This Vehicle", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)

        }


    }

}

@Composable
fun FeatureWithImage(painter: Painter, contentDescription: String, title: String) {

    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.padding(start = 20.dp, top = 2.5.dp)
        )

        Text(
            text = title,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            color = fontColor,
            modifier = Modifier.padding(start = 8.dp)
        )

    }

}


