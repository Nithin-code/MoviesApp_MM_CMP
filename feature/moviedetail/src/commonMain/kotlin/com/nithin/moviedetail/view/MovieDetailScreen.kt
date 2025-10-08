package com.nithin.moviedetail.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nithin.moviedetail.view.components.DescriptionCard
import com.nithin.moviedetail.viewmodel.MovieDetailViewModel
import com.nithin.shared.FontSize
import com.nithin.shared.Resources
import com.nithin.shared.Screens
import com.nithin.shared.components.ErrorCard
import com.nithin.shared.components.ImageWithLoader
import com.nithin.shared.components.LoadingScreen
import com.nithin.shared.domain.Movie
import com.nithin.shared.domain.MovieScreenState
import com.nithin.shared.utils.DisplayResult
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(
    movieId : String,
    onNavigateBack: () -> Unit
) {

    val movieDetailViewModel = koinViewModel<MovieDetailViewModel>()

    val movie : MovieScreenState = movieDetailViewModel.screenState

    val requestState = movieDetailViewModel.requestState

    LaunchedEffect(Unit){
        movieDetailViewModel.getMovieDetails(movieId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Movie Title",
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onNavigateBack.invoke()
                        },
                    ) {
                        Icon(
                            imageVector = Resources.backIcon,
                            contentDescription = "back icons"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            movieDetailViewModel.bookMarkMovieDetail(movie)
                        },

                    ){
                        Icon(
                            imageVector = Resources.FavoriteIcon,
                            contentDescription = "Fav Icon",
                            tint = if (movie.isBookMarked) Color.Red else Color.DarkGray
                        )
                    }
                }
            )
        },
    ) { paddingValues ->

        requestState
            .DisplayResult(
                onIdle = {

                },
                onLoading = {
                    LoadingScreen(
                        modifier = Modifier
                            .fillMaxSize()
                    )
                },
                onError = { it->
                    ErrorCard(
                        message = it
                    )
                },
                onSuccess = {
                    MovieDetailScreenContent(
                        movie = movie,
                        paddingValues = paddingValues
                    )
                }
            )

    }

}


@Composable
internal fun MovieDetailScreenContent(
    movie : MovieScreenState,
    paddingValues: PaddingValues
){



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp
            )
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding()
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentAlignment = Alignment.Center
            ) {
                ImageWithLoader(
                    modifier = Modifier
                        .fillMaxSize(),
                    size = null,
                    imageUrl = movie.poster_url,
                    contentDescription = "poster url",
                    shape = RoundedCornerShape(12.dp)
                )
            }
        }

        item {
            Text(
                text = movie.title,
                fontSize = FontSize.EXTRA_REGULAR,
                fontWeight = FontWeight.Bold,
                fontFamily = Resources.getUbuntuMediumFont()
            )
        }

        item {
            Text(
                text = movie.release_date.toString(),
                fontSize = FontSize.REGULAR,
                fontFamily = Resources.getUbuntuRegularFont()
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Resources.starIcon,
                    contentDescription = "rating_icon",
                    tint = Color.Yellow.copy(alpha = 0.4f)
                )
                Spacer(modifier = Modifier.width(2.dp))

                Icon(
                    imageVector = Resources.starIcon,
                    contentDescription = "rating_icon",
                    tint = Color.Yellow.copy(alpha = 0.4f)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = movie.rating.imdb.toString(),
                    fontSize = FontSize.REGULAR,
                    fontFamily = Resources.getUbuntuRegularFont()
                )
            }
        }

        item {

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Genre/Category : ",
                    fontFamily = Resources.getUbuntuMediumFont()
                )

                Text(
                    text = movie.genre.toString(),
                    fontFamily = Resources.getUbuntuRegularFont()
                )

            }


        }

        item {
            DescriptionCard(
                modifier = Modifier
                    .fillMaxWidth(),
                title = "Synopsis/Description",
                subTitle = movie.description
            )
        }

        item {
            DescriptionCard(
                modifier = Modifier
                    .fillMaxWidth(),
                title = "Director",
                subTitle = movie.director
            )
        }


        item {
            DescriptionCard(
                modifier = Modifier
                    .fillMaxWidth(),
                title = "Cast",
                subTitle = movie.cast.toString()
            )
        }

    }


}