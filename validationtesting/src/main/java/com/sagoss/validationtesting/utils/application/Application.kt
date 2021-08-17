/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.utils.application

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import com.sagoss.validationtesting.api.repository.ApiResponseRepository
import com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository
import com.sagoss.validationtesting.backgroundsync.WorkHelper
import com.sagoss.validationtesting.backgroundsync.workerfactory.CustomWorkFactory
import com.sagoss.validationtesting.database.repository.DBRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class Application : Application(), Configuration.Provider {

    @Inject
    lateinit var dbRepository: DBRepository
    @Inject
    lateinit var apiTwoResponseRepository: ApiTwoResponseRepository
    @Inject
    lateinit var apiResponseRepository: ApiResponseRepository

    override fun onCreate() {
        super.onCreate()
        WorkHelper.initWorkers(this)
    }

    /**
     * Override Work manager configuration
     * Implement custom work factory to enable
     * custom constructors or our workers
     */
    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setMinimumLoggingLevel(Log.DEBUG)
            .setWorkerFactory(
                CustomWorkFactory(
                    dbRepo                       = dbRepository,
                    apiTwoResponseRepository     = apiTwoResponseRepository,
                    apiResponseRepository        = apiResponseRepository
                )
            )
            .build()
    }
}