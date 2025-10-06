package com.nithin.di

import com.nithin.movieslist.repository.MoviesListRepository
import com.nithin.movieslist.repository.MoviesListRepositoryImpl
import com.nithin.movieslist.viewmodel.MoviesListviewModel
import com.nithin.network.createHttpClient
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val koinModule = module {
    single { createHttpClient() }
    single<MoviesListRepository> { MoviesListRepositoryImpl(get()) }
    viewModelOf(::MoviesListviewModel)
}

fun initializeKoin(
    application: ((KoinApplication) -> Unit)? = null
){

    startKoin {
        application?.invoke(this)
        modules(koinModule)
    }

}