package com.ridenomad.ridenomadz.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ridenomad.ridenomadz.presentation.details.app
import com.ridenomad.ridenomadz.presentation.home.Home
import com.ridenomad.ridenomadz.presentation.home.HomeScreen
import com.ridenomad.ridenomadz.presentation.signup.SignUp
import com.ridenomad.ridenomadz.presentation.theme.ui.RideNomadZTheme
import com.ridenomad.ridenomadz.presentation.vehiclelist.VehicleList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RideNomadZTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    app(this)

                }
            }
        }
    }
}

sealed class DestinationScreen(val route : String){
    object SignUp : DestinationScreen("signup")
    object Details : DestinationScreen("details")
    object VehicleList : DestinationScreen("vehicleList")
    object Home : DestinationScreen("home")
}
@Composable
fun app(context: Context){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = DestinationScreen.SignUp.route){
        composable(DestinationScreen.SignUp.route){
            SignUp(navController)
        }
        composable(DestinationScreen.Home.route){
            HomeScreen(navController)
        }
        composable(DestinationScreen.Details.route){
            app(context = context,navController)
        }
        composable(DestinationScreen.VehicleList.route){
            VehicleList(navController)
        }
    }


}

fun navigateTo(navController: NavController,dest : DestinationScreen){
    navController.navigate(dest.route){
        popUpTo(dest.route)
        launchSingleTop = true;
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RideNomadZTheme {
        Greeting("RideNomadZ")
    }
}



