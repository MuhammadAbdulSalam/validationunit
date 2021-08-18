/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.api.apiInterface

import com.sagoss.validationtesting.api.ApiOneRetrofitBuilder
import com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenResponse
import com.sagoss.validationtesting.api.models.registration.RegistrationRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHelper @Inject constructor(private val apiService: ApiOneRetrofitBuilder) {

    suspend fun getRegistrationResponse(registrationRequest: RegistrationRequest) =
        apiService.registration(
            registrationRequest.username,
            registrationRequest.password,
            registrationRequest.app_id,
            registrationRequest.mobile_id,
            registrationRequest.version
        )

    suspend fun getRefreshTokenResponse(
        authToken: String,
        refreshTokenRequest: RefreshTokenRequest
    ): RefreshTokenResponse
    = apiService.refreshToken(
        authToken,
        refreshTokenRequest.refresh_token,
        refreshTokenRequest.company_id
    )

    suspend fun getConfig(authToken: String) = apiService.getConfig(authToken)
}