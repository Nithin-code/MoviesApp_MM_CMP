package com.nithin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.nithin.moviedetail.view.MovieDetailScreen
import com.nithin.movieslist.view.HomeScreen
import com.nithin.shared.Screens


@Composable
fun NavGraph(
    startDestination: Screens = Screens.MovieListScreen,
) {


    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable<Screens.MovieListScreen> {
            // create movies list composable and add here
            HomeScreen(
                onMovieItemClick = { movieId->
                    navController.navigate(Screens.MovieDetailScreen(id = movieId))
                }
            )
        }

        composable<Screens.MovieDetailScreen> { backStackEntry->
            MovieDetailScreen(
                movieId = backStackEntry.toRoute<Screens.MovieDetailScreen>().id,
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }

    }


}