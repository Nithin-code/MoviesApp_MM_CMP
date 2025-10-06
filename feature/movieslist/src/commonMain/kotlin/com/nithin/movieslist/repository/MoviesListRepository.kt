package com.nithin.movieslist.repository

import com.nithin.shared.domain.Movie
import com.nithin.shared.utils.RequestState

interface MoviesListRepository {

    suspend fun getAllMoviesList() : RequestState<List<Movie>>

}