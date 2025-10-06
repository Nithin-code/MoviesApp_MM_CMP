package com.nithin.movieslist.repository

import com.nithin.network.RestEndPoints
import com.nithin.network.getResponse
import com.nithin.shared.domain.Movie
import com.nithin.shared.utils.RequestState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MoviesListRepositoryImpl(
    val httpClient: HttpClient
) : MoviesListRepository {


    override suspend fun getAllMoviesList(): RequestState<List<Movie>> {

        val response = try {
            httpClient.get(
                urlString = RestEndPoints.MOVIES_LIST_END_POINT
            )
        } catch (t: Exception) {
            return RequestState.Error(message = t.message.toString())
        }
        return when (response.status.value) {
            in 200..299 -> {
                val response = response.body<List<Movie>>()
                RequestState.Success(
                    data = response
                )
            }

            else -> {
                RequestState.Error(
                    message = "Something went Wrong!!"
                )
            }
        }


    }

}