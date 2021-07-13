package com.sagoss.validationhorizon.apitwo.apiinterface

import com.sagoss.validationhorizon.api.ApiOneRetrofitBuilder
import com.sagoss.validationhorizon.apitwo.ApiTwoRetrofitBuilder
import com.sagoss.validationhorizon.apitwo.models.validate.ValidateResponse
import com.sagoss.validationhorizon.utils.Constants
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiTwoHelper @Inject constructor(private val apiService: ApiTwoRetrofitBuilder) {

    suspend fun checkDateIn (plate: String, token: String, check_date_in: String) =
        apiService.checkDateIn(plate,token, check_date_in)

    suspend fun checkVoucher(plate: String, token: String, date_from: String, date_to: String?) =
        apiService.checkVoucher(plate, token, date_from, date_to)
}