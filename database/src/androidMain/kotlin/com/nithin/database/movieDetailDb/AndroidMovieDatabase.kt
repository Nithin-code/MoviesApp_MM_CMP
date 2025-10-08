package com.nithin.database.movieDetailDb

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getMovieDatabase(
    context: Context
) : RoomDatabase.Builder<MovieDatabase>{

    val applicationContext = context.applicationContext
    val databaseFile = applicationContext.getDatabasePath("movie_detail.db")

    return Room.databaseBuilder<MovieDatabase>(
        context = applicationContext,
        name = databaseFile.absolutePath
    )
}