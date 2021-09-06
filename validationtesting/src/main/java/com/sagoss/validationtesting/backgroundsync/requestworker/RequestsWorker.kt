/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.backgroundsync.requestworker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository
import com.sagoss.validationtesting.database.repository.DBRepository
import com.sagoss.validationtesting.utils.Constants
import com.sagoss.validationtesting.utils.Prefs
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class RequestsWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val dbRepository: DBRepository,
    private val apiTwoResponseRepository: ApiTwoResponseRepository)
    : CoroutineWorker(appContext, workerParams) {

    /**
     * Start worker to validate offline stored requests
     */
    override suspend fun doWork(): Result {
        try {
            Log.d("RequestWorker()", "Running...")
            if(Prefs(applicationContext).config)
            deleteOldTickets()
            validateOfflineRequests()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return Result.success()
    }

    /**
     * Validate all requests that were stored in offline mode
     */
    private suspend fun validateOfflineRequests() {
        if (dbRepository.getRequestCount() != 0)
            dbRepository.getAllRequests().forEach {
                val result = apiTwoResponseRepository.checkVoucher(
                    it.plate,
                    it.token,
                    it.dateFrom,
                    it.dateTo
                )
                when (result.valid) {
                    Constants.MATCH_REDEEMED -> deleteSuccessfulRequest(it.id)
                    Constants.NOT_APPLICABLE,
                    Constants.NO_MATCH -> {
                    }
                }
            }
    }

    /**
     * Delete all records older then 15 days
     */
    private suspend fun deleteOldTickets() = dbRepository.deleteOldRequestRecords()

    /**
     * @param id of Request to be deleted
     * Delete request from database
     */
    private suspend fun deleteSuccessfulRequest(id: Int) = dbRepository.deleteSuccessfulRequest(id)

}

