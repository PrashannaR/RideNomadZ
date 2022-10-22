package com.ridenomad.ridenomadz.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ridenomad.ridenomadz.presentation.navigation.SetupNavGraph
import com.ridenomad.ridenomadz.presentation.theme.ui.RideNomadZTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RideNomadZTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)

            }
        }
    }
}

//sealed class DestinationScreen(val route : String){
//    object SignUp : DestinationScreen("signup")
//    object Details : DestinationScreen("details")
//    object VehicleList : DestinationScreen("vehicleList")
//    object Home : DestinationScreen("home")
//}
//@Composable
//fun app(context: Context){
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = DestinationScreen.SignUp.route){
//        composable(DestinationScreen.SignUp.route){
//            SignUp(navController)
//        }
//        composable(DestinationScreen.Home.route){
//            HomeScreen(navController)
//        }
//        composable(DestinationScreen.Details.route){
//            app(context = context,navController)
//        }
//        composable(DestinationScreen.VehicleList.route){
//            VehicleList(navController)
//        }
//    }
//
//
//}

//fun navigateTo(navController: NavController,dest : DestinationScreen){
//    navController.navigate(dest.route){
//        popUpTo(dest.route)
//        launchSingleTop = true;
//    }
//}





