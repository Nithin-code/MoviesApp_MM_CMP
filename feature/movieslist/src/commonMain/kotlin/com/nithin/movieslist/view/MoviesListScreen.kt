package com.nithin.movieslist.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nithin.movieslist.repository.MoviesListRepository
import com.nithin.movieslist.repository.MoviesListRepositoryImpl
import com.nithin.movieslist.view.components.MovieItem
import com.nithin.movieslist.viewmodel.MoviesListviewModel
import com.nithin.network.createHttpClient
import com.nithin.network.getHttpClient
import com.nithin.shared.components.ErrorCard
import com.nithin.shared.components.LoadingScreen
import com.nithin.shared.utils.DisplayResult
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    onMovieItemClick : (String) -> Unit
) {

//    val moviesRepo = remember {
//        MoviesListRepositoryImpl(createHttpClient())
//    }

//    val moviesViewModel = remember {
//        MoviesListviewModel(moviesRepo)
//    }

    val moviesViewModel = koinViewModel<MoviesListviewModel>()

    val moviesResponse = moviesViewModel.screenState

    val movieData = moviesViewModel.uiStateFlow.collectAsState()


    moviesResponse.DisplayResult(
        modifier = Modifier
            .fillMaxSize(),

        onLoading = {
            LoadingScreen(
                modifier = Modifier.fillMaxSize()
            )
        },

        onError = { it ->

            ErrorCard(
                modifier = Modifier.fillMaxSize(),
                message = it
            )
        },

        onSuccess = {

            Scaffold { paddingValues ->
                LazyColumn(
                    modifier = Modifier
                        .padding(top = paddingValues.calculateTopPadding(), bottom = paddingValues.calculateBottomPadding())
                        .padding(horizontal = 16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {

                   items(movieData.value.movie){ item->
                       MovieItem(
                           movie = item,
                           onItemClick = { id->
                               onMovieItemClick.invoke(id)
                           }
                       )
                   }

                }
            }

        },
    )

}