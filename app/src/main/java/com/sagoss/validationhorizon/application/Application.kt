package com.sagoss.validationhorizon.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlin.system.exitProcess

@HiltAndroidApp
class Application: Application() {
    override fun onCreate() {
        super.onCreate()

    }
}