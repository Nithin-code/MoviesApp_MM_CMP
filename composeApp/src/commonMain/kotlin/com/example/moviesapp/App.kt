package com.example.moviesapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nithin.navigation.NavGraph
import com.nithin.shared.Screens

import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(

) {

    MaterialTheme {
        NavGraph(
            startDestination = Screens.MovieListScreen,
        )
    }
}