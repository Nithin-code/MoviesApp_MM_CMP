package com.nithin.moviedetail.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nithin.moviedetail.model.MovieScreenState
import com.nithin.moviedetail.model.toMovieScreenState
import com.nithin.moviedetail.repository.MovieDetailRepository
import com.nithin.shared.utils.RequestState
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    val repository: MovieDetailRepository
) : ViewModel() {
    var requestState: RequestState<Unit> by mutableStateOf(RequestState.Loading)
    var screenState by mutableStateOf(MovieScreenState())
    fun getMovieDetails(id: String) {
        viewModelScope.launch {
            val response = repository.getMovieDetailData(id)
            if (response.isSuccess()) {
                requestState = RequestState.Success(Unit)
                screenState = response.getSuccessData().toMovieScreenState()

            } else if (response.isError()) {
                requestState = RequestState.Error(response.getErrorMessage())
            } else {
                requestState = RequestState.Error("Something went wrong!!")
            }
        }
    }
}