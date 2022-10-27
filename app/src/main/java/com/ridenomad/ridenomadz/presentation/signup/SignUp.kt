package com.ridenomad.ridenomadz.presentation.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ridenomad.ridenomadz.R
import com.ridenomad.ridenomadz.presentation.navigation.Screens


@Composable
fun SignUp(navController: NavController) {
    Surface(modifier = Modifier, color = Color.White) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.monuments),
                    contentDescription = "Sign Up image",
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp)
                        .width(330.dp)
                        .height(240.dp)
                )
            }
            Surface(modifier = Modifier.fillMaxSize()) {
                content(navController)
            }


        }
    }
}

@Composable
fun content(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .fillMaxHeight()
    ) {
        Column(modifier = Modifier.padding(top = 1.dp, bottom = 30.dp)) {
            Text(text = "Please", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Text(text = "Sign up to book your ride", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        }
        Button(
            onClick = {
                
                navController.navigate(Screens.Home.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.primary),
                contentColor = MaterialTheme.colors.primary
            ),
            shape = RoundedCornerShape(6.dp), modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                "Sign up with Phone Number",
                fontSize = 17.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = "Or",
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 15.dp, bottom = 15.dp),
            color = Color.LightGray,
            textAlign = TextAlign.Center
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
                .wrapContentHeight()
        ) {
            Card(
                elevation = 10.dp, modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            ) {
                Icon(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google icon"
                )
            }
            Spacer(modifier = Modifier.fillMaxWidth(0.12f))
            Card(
                elevation = 10.dp, modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            ) {
                Icon(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google icon"
                )
            }

        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Already a member ? ", fontWeight = FontWeight.Thin)
            Text(
                text = "Sign In",
                fontWeight = FontWeight.Thin,
                textDecoration = TextDecoration.Underline,
                color = Color.Blue
            )
        }

    }
}