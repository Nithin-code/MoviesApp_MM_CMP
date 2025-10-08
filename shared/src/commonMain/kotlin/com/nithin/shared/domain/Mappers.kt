package com.nithin.shared.domain

fun Movie.toMovieScreenState(
    isBookMarked : Boolean
) : MovieScreenState {
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
        isBookMarked = isBookMarked
    )
}
