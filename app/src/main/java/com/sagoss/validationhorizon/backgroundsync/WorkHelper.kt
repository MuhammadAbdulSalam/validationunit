/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.backgroundsync

import android.content.Context
import androidx.work.*
import com.sagoss.validationhorizon.backgroundsync.configworker.ConfigWorker
import com.sagoss.validationhorizon.backgroundsync.requestworker.RequestsWorker
import com.sagoss.validationhorizon.utils.Constants
import java.util.concurrent.TimeUnit

object WorkHelper {


    /**
     * initialise both workers
     */
    fun initWorkers(context: Context){
        initRequestWorker(context)
        initConfigWorker(context)
    }

    /**
     * @param context Non null context
     *
     * Run Request worker to validate offline validations
     * preferred application context to make sure its never null
     * Request worker will be executed every 15 minutes
     * Unique worker, to make sure its not duplicated
     */
    private fun initRequestWorker(context: Context) {
        val constraints: Constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val periodicSyncDataWork =
            PeriodicWorkRequest.Builder(RequestsWorker::class.java, 15, TimeUnit.MINUTES)
                .addTag(Constants.REQUEST_WORKER_TAG)
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    PeriodicWorkRequest.MIN_BACKOFF_MILLIS,
                    TimeUnit.MILLISECONDS
                )
                .build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            Constants.REQUEST_WORKER_TAG,
            ExistingPeriodicWorkPolicy.KEEP,
            periodicSyncDataWork
        )
    }

    /**
     * @param context Non null context
     *
     * Run Config worker to get config from api
     * preferred application context to make sure its never null
     * Request worker will be executed every 1 day
     * Unique worker, to make sure its not duplicated
     */
    private fun initConfigWorker(context: Context) {
        val constraints: Constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val periodicSyncDataWork =
            PeriodicWorkRequest.Builder(ConfigWorker::class.java, 1, TimeUnit.DAYS)
                .addTag(Constants.CONFIG_WORKER_TAG)
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    PeriodicWorkRequest.MIN_BACKOFF_MILLIS,
                    TimeUnit.MILLISECONDS
                )
                .build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            Constants.CONFIG_WORKER_TAG,
            ExistingPeriodicWorkPolicy.KEEP,
            periodicSyncDataWork
        )
    }
}