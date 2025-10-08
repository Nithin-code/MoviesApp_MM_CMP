package com.nithin.movieslist.model

import com.nithin.shared.domain.Movie
import com.nithin.shared.domain.MovieScreenState
import com.nithin.shared.domain.Rating

data class MoviesListScreen(
    val query : String = "",
    val movie: List<MovieScreenState> = emptyList()
)

//Movie(
//id = "",
//createdAt = 0L,
//title = "",
//genre = emptyList(),
//rating = Rating(imdb = 0f),
//release_date = 0L,
//poster_url = "",
//duration_minutes = 0,
//director = "",
//cast = emptyList(),
//box_office_usd = 0L,
//description = "",
//)
