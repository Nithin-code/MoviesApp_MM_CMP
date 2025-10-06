package com.nithin.moviedetail.model

import com.nithin.shared.domain.Movie

fun Movie.toMovieScreenState() : MovieScreenState{
    return MovieScreenState(
        id = id,
        createdAt = createdAt,
        title = title,
        rating = rating,
        genre = genre,
        release_date = release_date,
        duration_minutes = duration_minutes,
        poster_url = poster_url,
        director = director,
        cast = cast,
        box_office_usd = box_office_usd,
        description = description,
    )
}