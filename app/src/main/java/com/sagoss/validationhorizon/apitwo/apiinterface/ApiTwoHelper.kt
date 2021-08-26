/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.apitwo.apiinterface

import com.sagoss.validationhorizon.apitwo.ApiTwoRetrofitBuilder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiTwoHelper @Inject constructor(private val apiService: ApiTwoRetrofitBuilder) {

    /**
     * @param plate plate number to be validated
     * @param token auth token/key of voucher
     * @param check_date_in check date in time
     *
     * @return check Date in response body
     */
    suspend fun checkDateIn (plate: String, token: String, check_date_in: String) =
        apiService.checkDateIn(plate,token, check_date_in)

    /**
     * @param plate plate number to be validated
     * @param token auth token/key of voucher
     * @param date_from date validation start time
     * @param date_to optional date till expiry time
     *
     * @return validation response
     */
    suspend fun checkVoucher(plate: String, token: String, date_from: String, date_to: String?) =
        apiService.checkVoucher(plate, token, date_from, date_to)

}