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
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.sagoss.validationhorizon.database.repository.DBRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class RequestsWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    var dbRepository: DBRepository
) : Worker(appContext, workerParams) {

    /**
     * Start worker to validate offline stored requests
     */
    override fun doWork(): Result {
            deleteOldRequests()
            processRequests()

        return Result.success()
    }

    /**
     * Process offline requests
     *
     * If request was success delete from db
     * else carry on and complete the rest validations
     */
    private fun processRequests(){

        Log.d("------------", "------------------------------------")

//
//        if(!::dbRepository.isInitialized)
//        {
//            Log.d("------------", "-------------------NULLLLLL--------------")
//
//        }

        //  if(!requestList.isNullOrEmpty())
    //    {
//            requestList.forEach{
//               val validate =  apiTwoResponseRepository.checkVoucher(
//                    it.plate,
//                    it.token,
//                    it.dateFrom,
//                    it.dateTo
//                )
//                when(validate.valid){
//                    Constants.MATCH_REDEEMED-> deleteRequest(it.id)
//                    Constants.NOT_APPLICABLE,
//                    Constants.NO_MATCH->{}
//                }
//            }
//        }
    }


    /**
     * Delete any entryies older then 15 days
     */
    private fun deleteOldRequests() {
      //  dbRepository.deleteOldRequestRecords()
    }

    /**
     * @param id id of request to be deleted
     *
     * Delete Entry From database
     */
    private fun deleteRequest(id: Int){
      //  dbRepository.deleteSuccessfulRequest(id)
    }

}

