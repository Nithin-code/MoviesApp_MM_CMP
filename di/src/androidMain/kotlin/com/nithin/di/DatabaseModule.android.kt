package com.nithin.di

import androidx.room.RoomDatabase
import com.nithin.database.movieDetailDb.MovieDatabase
import com.nithin.database.movieDetailDb.getMovieDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<RoomDatabase.Builder<MovieDatabase>> {
        getMovieDatabase(get())
    }

}