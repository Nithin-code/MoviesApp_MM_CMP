package com.nithin.shared

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens{
    @Serializable
    data object MovieListScreen : Screens()

    @Serializable
    data class MovieDetailScreen(val id : String) : Screens()

}