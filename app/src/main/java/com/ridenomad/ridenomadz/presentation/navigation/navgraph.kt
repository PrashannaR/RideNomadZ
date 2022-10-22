package com.ridenomad.ridenomadz.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ridenomad.ridenomadz.presentation.home.SampleHome
import com.ridenomad.ridenomadz.presentation.onboarding.OnBoarding

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,


    ) {
    NavHost(navController = navController, startDestination = Screens.OnBoarding.route) {
        composable(route = Screens.OnBoarding.route) {
            OnBoarding(navController = navController)
        }

        composable(route = Screens.Home.route) {
            SampleHome()
        }

    }

}