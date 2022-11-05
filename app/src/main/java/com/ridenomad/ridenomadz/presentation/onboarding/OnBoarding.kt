package com.ridenomad.ridenomadz.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.ridenomad.ridenomadz.presentation.navigation.Screens
import com.ridenomad.ridenomadz.presentation.theme.ui.backgroundColor
import com.ridenomad.ridenomadz.presentation.theme.ui.purpleish


@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnBoarding(
    navController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        HorizontalPager(

            count = 2,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .align(CenterHorizontally)
                .weight(1f),
            pagerState = pagerState
        )
        FinishButton(
            modifier = Modifier.weight(1f),
            pagerState = pagerState
        ) {
            //persists the value of the on boarding process
            onBoardingViewModel.saveOnBoardingState(completed = true)
            navController.popBackStack()
            navController.navigate(Screens.EnterPhone.route)  // changed for testing

        }

    }

}


@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(.8f)
            .fillMaxHeight(.80f)
            .background(backgroundColor),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(
                    CenterHorizontally
                ),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "On boarding image",


            )

        Text(
            text = onBoardingPage.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 40.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp

        )

    }

}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 1
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = purpleish,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Explore")

            }

        }

    }
}

@Composable
@Preview(showSystemUi = true)
fun FirstOnBoarding() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.First)
    }

}

@Composable
@Preview(showSystemUi = true)
fun SecondOnBoarding() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Second)

    }

}