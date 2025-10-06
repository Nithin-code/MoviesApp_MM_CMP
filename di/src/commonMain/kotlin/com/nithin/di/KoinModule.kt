package com.nithin.di

import com.nithin.moviedetail.repository.MovieDetailRepository
import com.nithin.moviedetail.repository.MovieDetailRepositoryImpl
import com.nithin.moviedetail.viewmodel.MovieDetailViewModel
import com.nithin.movieslist.repository.MoviesListRepository
import com.nithin.movieslist.repository.MoviesListRepositoryImpl
import com.nithin.movieslist.viewmodel.MoviesListviewModel
import com.nithin.network.createHttpClient
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val movieListModule = module {
    single { createHttpClient() }
    single<MoviesListRepository> { MoviesListRepositoryImpl(get()) }
    viewModelOf(::MoviesListviewModel)
}

val movieDetailModule = module {
    single<MovieDetailRepository> { MovieDetailRepositoryImpl(get()) }
    viewModelOf(::MovieDetailViewModel)
}

//fun initializeKoin(
//    application: ((KoinApplication) -> Unit)? = null
//){
//
//    startKoin {
//        application?.invoke(this)
//        modules(koinModule)
//    }
//
//}