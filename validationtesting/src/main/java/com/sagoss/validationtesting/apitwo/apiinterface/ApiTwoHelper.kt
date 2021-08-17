/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.apitwo.apiinterface

import com.sagoss.validationtesting.apitwo.ApiTwoRetrofitBuilder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiTwoHelper @Inject constructor(private val apiService: ApiTwoRetrofitBuilder) {

    suspend fun checkDateIn (plate: String, token: String, check_date_in: String) =
        apiService.checkDateIn(plate,token, check_date_in)

    suspend fun checkVoucher(plate: String, token: String, date_from: String, date_to: String?) =
        apiService.checkVoucher(plate, token, date_from, date_to)
}