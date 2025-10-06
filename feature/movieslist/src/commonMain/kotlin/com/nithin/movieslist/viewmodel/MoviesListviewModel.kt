package com.nithin.movieslist.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nithin.movieslist.model.MoviesListScreen
import com.nithin.movieslist.repository.MoviesListRepository
import com.nithin.shared.utils.RequestState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MoviesListviewModel(
    val moviesListRepository: MoviesListRepository
) : ViewModel() {

    var screenState: RequestState<Unit> by mutableStateOf(RequestState.Loading)

    var uiStateFlow = MutableStateFlow(MoviesListScreen())

    init {
        refresh()
    }


    fun refresh() {
        viewModelScope.launch {

            val requestState = moviesListRepository.getAllMoviesList()


            if (requestState.isSuccess()) {
                screenState = RequestState.Success(data = Unit)
                val data = requestState.getSuccessData()
                uiStateFlow.value = MoviesListScreen(movie = data)

            } else if (requestState.isError()) {
                screenState = RequestState.Error(message = requestState.getErrorMessage())
                uiStateFlow.value = MoviesListScreen(movie = emptyList())
            } else {
                screenState = RequestState.Error(message = "Something is Wrong!!")
                uiStateFlow.value = MoviesListScreen(movie = emptyList())
            }

        }

    }


}