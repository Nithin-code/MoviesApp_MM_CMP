package com.nithin.di

import com.nithin.database.movieDetailDb.MovieDao
import com.nithin.database.movieDetailDb.getRoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule : Module

val dataModule = module {
    single<MovieDao> { getRoomDatabase(get()).movieDao() }
}