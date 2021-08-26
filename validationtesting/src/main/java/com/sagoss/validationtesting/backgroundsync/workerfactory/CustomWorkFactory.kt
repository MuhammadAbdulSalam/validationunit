/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.backgroundsync.workerfactory

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.sagoss.validationtesting.api.repository.ApiResponseRepository
import com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository
import com.sagoss.validationtesting.backgroundsync.configworker.ConfigWorker
import com.sagoss.validationtesting.backgroundsync.requestworker.RequestsWorker
import com.sagoss.validationtesting.database.repository.DBRepository
import javax.inject.Inject

class CustomWorkFactory @Inject constructor(
    val dbRepo: DBRepository,
    val apiTwoResponseRepository: ApiTwoResponseRepository,
    val apiResponseRepository: ApiResponseRepository
) : WorkerFactory() {

    /**
     * @return Request or Config workers as asked
     */
    override fun createWorker(appContext: Context, workerClassName: String,
                              workerParameters: WorkerParameters): ListenableWorker? {
        return when (workerClassName) {
            RequestsWorker::class.java.name ->
                RequestsWorker(appContext, workerParameters, dbRepo, apiTwoResponseRepository)
            ConfigWorker::class.java.name ->
                ConfigWorker(appContext, workerParameters, apiResponseRepository)
            else -> { null } // returns default factory
        }
    }
}