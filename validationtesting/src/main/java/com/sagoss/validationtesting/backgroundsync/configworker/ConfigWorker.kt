/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.backgroundsync.configworker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.sagoss.validationtesting.api.repository.ApiResponseRepository
import com.sagoss.validationtesting.utils.HelperUtil
import com.sagoss.validationtesting.utils.Prefs
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class ConfigWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val apiOneResponseRepository: ApiResponseRepository)
    : CoroutineWorker(appContext, workerParams) {

    /**
     * Start worker to validate offline stored requests
     */
    override suspend fun doWork(): Result {
        try {
            Log.d("ConfigWorker()", "Running...")
            getConfig()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return Result.success()
    }

    /**
     * Get config from API ONE
     * Repository stores new vouchers once received
     * We do not need to store these vouchers in worker
     */
    private suspend fun getConfig() {
        val prefs = Prefs(applicationContext)
        if(Prefs(applicationContext).config)
        apiOneResponseRepository.getConfig(HelperUtil.getTokenFormat(prefs.accessToken), applicationContext)
    }
}

