package com.nithin.shared.utils

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun <T> RequestState<T>.DisplayResult(

    modifier: Modifier = Modifier,

    onIdle: (@Composable () -> Unit)? = null,

    onLoading: (@Composable () -> Unit)? = null,

    onSuccess: (@Composable (T) -> Unit)? = null,

    onError: (@Composable (String) -> Unit)? = null,

    animeSpec: ContentTransform? = scaleIn(animationSpec = tween(durationMillis = 400)) + fadeIn(
        animationSpec = tween(durationMillis = 400)
    )
            togetherWith scaleOut(animationSpec = tween(durationMillis = 400)) + fadeOut(
        animationSpec = tween(durationMillis = 400)
    ),

    backgroundColor: Color? = Color.Unspecified

) {

    AnimatedContent(
        modifier = modifier.background(color = backgroundColor ?: Color.Unspecified),
        targetState = this,
        transitionSpec = {
            animeSpec
                ?: (scaleIn(animationSpec = tween(durationMillis = 400)) togetherWith scaleOut(
                    animationSpec = tween(durationMillis = 400)
                ))
        },
    ) { state ->

        when (state) {
            is RequestState.Error -> {
                onError?.invoke(state.message)
            }

            RequestState.Idle -> {
                onIdle?.invoke()
            }

            RequestState.Loading -> {
                onLoading?.invoke()
            }

            is RequestState.Success -> {
                onSuccess?.invoke(state.data)
            }
        }

    }


}