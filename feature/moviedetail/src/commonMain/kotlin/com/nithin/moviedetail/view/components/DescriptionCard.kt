package com.nithin.moviedetail.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nithin.shared.FontSize
import com.nithin.shared.Resources

@Composable
fun DescriptionCard(
    modifier: Modifier,
    title : String,
    subTitle : String
){

    Column(
        modifier = modifier
    ) {

        Text(
            text = title,
            fontFamily = Resources.getUbuntuMediumFont(),
            fontSize = FontSize.EXTRA_REGULAR
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = subTitle,
            fontFamily = Resources.getUbuntuRegularFont(),
            fontSize = FontSize.REGULAR
        )

    }

}