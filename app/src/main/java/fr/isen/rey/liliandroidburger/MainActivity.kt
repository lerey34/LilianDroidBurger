package fr.isen.rey.liliandroidburger

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.isen.rey.liliandroidburger.logic.ConfirmerScreen
import fr.isen.rey.liliandroidburger.logic.ViewInfo
import fr.isen.rey.liliandroidburger.screens.CommandeScreen
import fr.isen.rey.liliandroidburger.screens.SplashScreen
import fr.isen.rey.liliandroidburger.ui.theme.LilianDroidBurgerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LilianDroidBurgerTheme {
                //loginScreen()
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen"){
        composable(route = "SplashScreen"){
            SplashScreen(navController)
        }
        composable(route = "CommandeScreen"){
            CommandeScreen(navController)
        }
        composable(route = "confirmScreen"){
            ViewInfo()
        }
    }
}