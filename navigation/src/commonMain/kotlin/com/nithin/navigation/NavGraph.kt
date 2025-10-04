package com.nithin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nithin.shared.Screens

@Composable
fun NavGraph(
    startDestination: Screens = Screens.MovieListScreen
){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){

        composable<Screens.MovieListScreen> {
            // create movies list composable and add here
        }

    }


}