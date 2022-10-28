package com.ridenomad.ridenomadz.presentation.navigation

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ridenomad.ridenomadz.presentation.details.app
import com.ridenomad.ridenomadz.presentation.home.HomeScreen
import com.ridenomad.ridenomadz.presentation.home.SampleHome
import com.ridenomad.ridenomadz.presentation.onboarding.OnBoarding
import com.ridenomad.ridenomadz.presentation.signup.SignUp
import com.ridenomad.ridenomadz.presentation.vehicledesc.VehicleDesc
import com.ridenomad.ridenomadz.presentation.vehiclelist.VehicleList

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
    context: Context

    ) {
    NavHost(navController = navController, startDestination = startDestination) {

        composable(route = Screens.OnBoarding.route) {
            OnBoarding(navController = navController)
        }

        composable(route = Screens.Home.route) {

            HomeScreen(navController = navController)
        }

        composable(route = Screens.SignUp.route) {
            SignUp(navController = navController)

        }

        composable(route = Screens.VehicleList.route) {
            VehicleList(navController = navController)
        }
        composable(route = Screens.Temp.route) {
            SampleHome()
        }

        composable(route = Screens.VehicleList.route){
            VehicleList(navController = navController)
        }

        composable(route = Screens.VehicleDesc.route){
            VehicleDesc(navController)
        }

        composable(route = Screens.SignUp.route){
            SignUp(navController = navController)

        }

        composable(route = Screens.EnterDetails.route) {
            app(context = context, navController = navController)
        }

    }

}