/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.utils.application

import android.app.Application
import android.util.Log
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.sagoss.validationhorizon.backgroundsync.RequestsWorker
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class Application: Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        if(::workerFactory.isInitialized)
        {
            Log.d("---------", "--------------------WORKER------------------")
        }
        super.onCreate()

    }


    private fun initWorker() {
        val request = OneTimeWorkRequestBuilder<RequestsWorker>().build()
        WorkManager.getInstance(applicationContext).enqueue(request)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return  Configuration.Builder()
            .setMinimumLoggingLevel(Log.DEBUG)
            .setWorkerFactory(workerFactory)
            .build()
    }
}