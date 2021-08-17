/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.api.repository

import android.content.Context
import com.google.gson.Gson
import com.sagoss.validationtesting.api.apiInterface.ApiHelper
import com.sagoss.validationtesting.api.models.config.Config
import com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenResponse
import com.sagoss.validationtesting.api.models.registration.RegistrationRequest
import com.sagoss.validationtesting.api.models.registration.RegistrationResponse
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.database.repository.DBRepository
import com.sagoss.validationtesting.utils.Prefs
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiResponseRepository @Inject constructor(private val apiInterface: ApiHelper, private val dbRepository: DBRepository) {

    suspend fun getRegistrationResponse(
        registrationRequest: RegistrationRequest,
        context: Context
    ): RegistrationResponse {

        val registrationResponse = apiInterface.getRegistrationResponse(registrationRequest)
        val prefs = Prefs(context)

        prefs.accessToken = registrationResponse.access_token
        prefs.refreshToken = registrationResponse.refresh_token
        prefs.expiryDate = registrationResponse.expiry_date
        prefs.companyId = registrationResponse.company_id
        return registrationResponse
    }

    suspend fun getRefreshTokenResponse(
        authToken: String,
        refreshTokenRequest: RefreshTokenRequest,
        context: Context
    ): RefreshTokenResponse {
        val prefs = Prefs(context)
        val config = apiInterface.getRefreshTokenResponse(authToken, refreshTokenRequest)
        prefs.accessToken = config.access_token
        prefs.refreshToken = config.refresh_token
        prefs.expiryDate = config.expiry_date

        return config
    }

    suspend fun getConfig(authToken: String, context: Context): Config {
        val prefs = Prefs(context)
        val config = apiInterface.getConfig(authToken)
        prefs.siteId =config.site_id
        prefs.status =config.status
        prefs.locationName = config.location_name

        val vouchers = Gson().fromJson(config.vouchers?.toString(), Array<Voucher>::class.java).toList()
        dbRepository.insertAllVouchers(vouchers)

        return config
    }


}