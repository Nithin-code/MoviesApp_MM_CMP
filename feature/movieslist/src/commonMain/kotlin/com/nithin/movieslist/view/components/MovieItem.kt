package com.nithin.movieslist.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nithin.shared.FontSize
import com.nithin.shared.Resources
import com.nithin.shared.components.ImageWithLoader
import com.nithin.shared.domain.Movie

@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    onItemClick : (String) -> Unit
){

    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color.LightGray.copy(alpha = 0.2f),
        onClick = {
            onItemClick.invoke(movie.id)
        }
    ) {

        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            ImageWithLoader(
                imageUrl = movie.poster_url,
                contentDescription = movie.id,
                shape = CircleShape
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
                    fontSize = FontSize.EXTRA_REGULAR,
                    fontFamily = Resources.getUbuntuMediumFont()
                )


                Text(
                    text = "05-oct-2025",
                    fontSize = FontSize.REGULAR,
                    fontFamily = Resources.getUbuntuRegularFont()
                )

                Text(
                    text = "Rating: ${movie.rating.imdb}",
                    fontSize = FontSize.REGULAR,
                    fontFamily = Resources.getUbuntuMediumFont()
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

