package com.ridenomad.ridenomadz.presentation.navigation

sealed class Screens(val route: String){
    object OnBoarding : Screens(route = "on_boarding")
    object Home : Screens(route = "home")
}
