package com.nithin.moviedetail.repository

import com.nithin.shared.domain.Movie
import com.nithin.shared.utils.RequestState

interface MovieDetailRepository {

    suspend fun getMovieDetailData(id : String) : RequestState<Movie>

}
