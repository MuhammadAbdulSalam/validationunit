/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.apitwo.repositiory

import com.sagoss.validationhorizon.apitwo.apiinterface.ApiTwoHelper
import com.sagoss.validationhorizon.apitwo.models.validate.ValidateResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiTwoResponseRepository @Inject constructor(private val apiInterface: ApiTwoHelper) {

    suspend fun checkDateIn (plate: String, token: String, check_date_in: String) : ValidateResponse {
        return apiInterface.checkDateIn(plate, token, check_date_in)
    }

    suspend fun checkVoucher(plate: String, token: String, date_from: String, date_to: String?
    ): ValidateResponse {
        val dateTo = if(date_to == "") null else date_to
       return apiInterface.checkVoucher(plate, token, date_from, dateTo)
    }

}