/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.api.repository

import android.content.Context
import android.util.Log
import androidx.annotation.UiThread
import com.google.gson.Gson
import com.sagoss.validationhorizon.MainActivity
import com.sagoss.validationhorizon.api.apiInterface.ApiHelper
import com.sagoss.validationhorizon.api.models.config.Config
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenResponse
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import com.sagoss.validationhorizon.api.models.registration.RegistrationResponse
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.database.repository.DBRepository
import com.sagoss.validationhorizon.utils.Prefs
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiResponseRepository @Inject constructor(private val apiInterface: ApiHelper, private val dbRepository: DBRepository) {

    suspend fun getRegistrationResponse(registrationRequest: RegistrationRequest):
            RegistrationResponse {

        val registrationResponse = apiInterface.getRegistrationResponse(registrationRequest)
        val prefs = Prefs(MainActivity.activityContext)

        prefs.accessToken = registrationResponse.access_token
        prefs.refreshToken = registrationResponse.refresh_token
        prefs.expiryDate = registrationResponse.expiry_date
        prefs.companyId = registrationResponse.access_token
        return registrationResponse
    }

    suspend fun getRefreshTokenResponse(
        authToken: String,
        refreshTokenRequest: RefreshTokenRequest
    ): RefreshTokenResponse {
        return apiInterface.getRefreshTokenResponse(authToken, refreshTokenRequest)
    }

    suspend fun getConfig(authToken: String): Config {
        val prefs = Prefs(MainActivity.activityContext)
        val config = apiInterface.getConfig(authToken)
        prefs.siteId =config.site_id
        prefs.status =config.status
        prefs.locationName = config.location_name

        val vouchers = Gson().fromJson(config.vouchers?.toString(), Array<Voucher>::class.java).toList()
        dbRepository.insertAllVouchers(vouchers)

        return config
    }


}