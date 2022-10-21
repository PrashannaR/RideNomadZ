package com.ridenomad.ridenomadz.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ridenomad.ridenomadz.R
import com.ridenomad.ridenomadz.presentation.theme.ui.backgroundColor

@Preview(showSystemUi = true)
@Composable
fun OnBoarding() {

    Column(
        modifier = Modifier.background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Image(
            painter = painterResource(id = R.drawable.samplerv),
            contentDescription = "Sample image one",
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(start = 20.dp, end = 20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Find best house on wheels for\n your family",
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )


    }

}