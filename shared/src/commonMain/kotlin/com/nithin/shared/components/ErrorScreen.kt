package com.nithin.shared.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.nithin.shared.FontSize
import com.nithin.shared.Resources

@Composable
fun ErrorCard(
    modifier: Modifier = Modifier,
    message : String,
    fontSize : TextUnit = FontSize.EXTRA_REGULAR
){

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = message,
            fontSize = fontSize,
            textAlign = TextAlign.Center,
            fontFamily = Resources.getUbuntuMediumFont()
        )
    }

}