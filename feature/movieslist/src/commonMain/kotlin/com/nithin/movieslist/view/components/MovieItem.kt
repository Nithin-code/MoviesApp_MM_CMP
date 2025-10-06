package com.nithin.movieslist.view.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.nithin.movieslist.model.MoviesListScreen
import com.nithin.shared.domain.Movie

@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier
){

    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color.LightGray.copy(alpha = 0.2f)
    ) {

        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            ImageWithLoader(
                imageUrl = movie.poster_url,
                contentDescription = movie.id
            )

            Spacer(
                modifier = Modifier.width(16.dp)
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = movie.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )


                Text(
                    text = "05-oct-2025",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp
                )

                Text(
                    text = "Rating: ${movie.rating.imdb}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

            }

            IconButton(
                onClick = {

                }
            ){
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "favorite_icon"
                )
            }

        }
    }

}

@Composable
fun ImageWithLoader(
    imageUrl: String,
    contentDescription: String
) {


    var isLoading by remember {
        mutableStateOf(true)
    }

    val painter = rememberAsyncImagePainter(
        model = imageUrl,
        onSuccess = {
            isLoading = false
        }
    )


    Surface(
        shape = CircleShape
    ) {


        AnimatedContent(
            modifier = Modifier.size(56.dp),
            targetState = isLoading,
            transitionSpec = {
                scaleIn(tween(durationMillis = 400)) togetherWith scaleOut(tween(durationMillis = 400))
            }
        ) { state ->

            when (state) {
                true -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier,
                            color = Color.Red.copy(alpha = 0.2f)
                        )
                    }
                }

                false -> {
                    Image(
                        painter = painter,
                        modifier = Modifier
                            .fillMaxSize(),
                        contentDescription = contentDescription,
                        contentScale = ContentScale.FillBounds
                    )
                }

            }


        }


    }

}