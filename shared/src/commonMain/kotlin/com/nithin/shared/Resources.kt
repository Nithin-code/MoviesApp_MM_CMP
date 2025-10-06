package com.nithin.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.runtime.Composable

object Resources {


    val SearchIcon = Icons.Default.Search
    val MenuIcon = Icons.Default.Menu
    val FavoriteIcon = Icons.Default.Favorite
    val FavoriteIconBorder = Icons.Default.FavoriteBorder
    val backIcon = Icons.Default.ArrowBackIosNew

    val starIcon = Icons.Default.StarRate

    //fonts
    @Composable
    fun getUbuntuRegularFont() = ubuntuRegularFont()
    @Composable
    fun getUbuntuMediumFont() = ubuntuMediumFont()




}