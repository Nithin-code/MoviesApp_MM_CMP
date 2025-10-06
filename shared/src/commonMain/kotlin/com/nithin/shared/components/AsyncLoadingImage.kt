package com.nithin.shared.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun ImageWithLoader(
    modifier: Modifier = Modifier,
    size : Dp? = 56.dp,
    imageUrl: String,
    contentDescription: String,
    shape: Shape
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
        shape = shape
    ) {


        AnimatedContent(
            modifier = if (size!=null) Modifier.size(size) else modifier,
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