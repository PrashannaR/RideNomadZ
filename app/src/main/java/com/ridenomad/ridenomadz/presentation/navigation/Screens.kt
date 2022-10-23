package com.ridenomad.ridenomadz.presentation.navigation

sealed class Screens(val route: String) {
    object OnBoarding : Screens(route = "on_boarding")
    object Home : Screens(route = "home")
    object EnterDetails : Screens(route = "enter_details")
    object EnterOTP : Screens(route = "enter_otp")
    object EnterPhone : Screens(route = "enter_phone")
    object SignUp : Screens(route = "signup")
    object VehicleDesc : Screens(route = "vehicle_desc")
    object VehicleList : Screens(route = "vehicle_list")
    object Temp : Screens(route = "temp")

}
