package com.example.moviesapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.nithin.di.movieDetailModule
import com.nithin.di.movieListModule
import com.nithin.navigation.NavGraph
import com.nithin.shared.Screens

import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {

    MaterialTheme {

        KoinApplication(
            application = {
                modules(
                    movieListModule,
                    movieDetailModule
                )
            }
        ){
            NavGraph(
                startDestination = Screens.MovieListScreen,
            )
        }


    }
}