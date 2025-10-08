package com.example.moviesapp

import android.app.Application
import com.nithin.di.initKoin
import org.koin.android.ext.koin.androidContext


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MyApplication)
        }
    }

}