package com.nithin.moviedetail.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nithin.database.movieDetailDb.MovieDao
import com.nithin.moviedetail.model.toMovieEntity

import com.nithin.shared.domain.toMovieScreenState
import com.nithin.moviedetail.repository.MovieDetailRepository
import com.nithin.shared.domain.MovieScreenState
import com.nithin.shared.utils.RequestState
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    val repository: MovieDetailRepository,
    val movieDao : MovieDao
) : ViewModel() {
    var requestState: RequestState<Unit> by mutableStateOf(RequestState.Loading)
    var screenState by mutableStateOf(MovieScreenState())


    fun getMovieDetails(id: String) {
        viewModelScope.launch {

            val isBookmarked = movieDao.isBookMarked(id)

            screenState = screenState.copy(
                isBookMarked = movieDao.isBookMarked(id)
            )

            val response = repository.getMovieDetailData(id)
            if (response.isSuccess()) {
                requestState = RequestState.Success(Unit)
                screenState = response.getSuccessData().toMovieScreenState(isBookmarked)

            } else if (response.isError()) {
                requestState = RequestState.Error(response.getErrorMessage())
            } else {
                requestState = RequestState.Error("Something went wrong!!")
            }
        }
    }

    fun bookMarkMovieDetail(
        movieScreenState: MovieScreenState
    ){
        viewModelScope.launch {
            val isBookmarked = movieDao.isBookMarked(movieScreenState.id)

            val movieEntity = movieScreenState.toMovieEntity()

            if (isBookmarked){
                movieDao.delete(movieEntity)
            }else{
                movieDao.upsert(movieEntity)
            }

            screenState = screenState.copy(
                isBookMarked = !isBookmarked
            )

        }

    }

}