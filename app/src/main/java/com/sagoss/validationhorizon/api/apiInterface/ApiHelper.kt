/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.api.apiInterface

import com.sagoss.validationhorizon.api.ApiOneRetrofitBuilder
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenResponse
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHelper @Inject constructor(private val apiService: ApiOneRetrofitBuilder) {

    /**
     * @param registrationRequest registration request body
     *
     * @return get Registration response body
     */
    suspend fun getRegistrationResponse(registrationRequest: RegistrationRequest) =
        apiService.registration(
            registrationRequest.username,
            registrationRequest.password,
            registrationRequest.app_id,
            registrationRequest.mobile_id,
            registrationRequest.version
        )

    /**
     * @param authToken authentication token for api header
     * @param refreshTokenRequest Refresh token request body
     *
     * break down body to fields as this request runs as query
     * @return refresh token response body
     */
    suspend fun getRefreshTokenResponse(authToken: String, refreshTokenRequest: RefreshTokenRequest
    ): RefreshTokenResponse =
        apiService.refreshToken(
            authToken,
            refreshTokenRequest.refresh_token,
            refreshTokenRequest.company_id
        )

    /**
     * @param authToken authentication token for api header
     *
     * @return config response body
     */
    suspend fun getConfig(authToken: String) = apiService.getConfig(authToken)
}