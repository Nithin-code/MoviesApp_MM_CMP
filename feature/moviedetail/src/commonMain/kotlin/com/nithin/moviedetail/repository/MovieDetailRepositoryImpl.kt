package com.nithin.moviedetail.repository

import com.nithin.network.RestEndPoints
import com.nithin.shared.domain.Movie
import com.nithin.shared.utils.RequestState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MovieDetailRepositoryImpl(
    val httpClient: HttpClient
) :MovieDetailRepository {

    override suspend fun getMovieDetailData(id: String): RequestState<Movie> {
        val response = try {
            httpClient
                .get(urlString = RestEndPoints.MOVIES_LIST_END_POINT+"/"+id)
        }catch (t : Exception){
            return RequestState.Error(message = t.message.toString())
        }

        return when(response.status.value){
            in 200..299->{
                RequestState.Success(
                    data = response.body<Movie>()
                )
            }
            else -> {
                RequestState.Error(message = "Something went Wrong!! ${response.status.value}")
            }
        }
    }


}