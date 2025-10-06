package com.nithin.moviedetail.model

import com.nithin.shared.domain.Rating

data class MovieScreenState(
    val id: String = "",
    val createdAt: Long = 0L,
    val title: String = "",
    val genre: List<String> = emptyList(),
    val rating: Rating = Rating(0f),
    val release_date: Long = 0L,
    val poster_url: String = "",
    val duration_minutes: Int = 0,
    val director: String = "",
    val cast: List<String> = emptyList(),
    val box_office_usd: Long = 0L,
    val description: String = "",
    val isBookMarked : Boolean = false
)
