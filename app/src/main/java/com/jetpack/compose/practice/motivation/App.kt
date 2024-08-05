package com.jetpack.compose.practice.motivation

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.jetpack.compose.practice.motivation.domain.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(appModules)
        }
    }
}