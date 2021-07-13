package com.sagoss.validationhorizon.api.repository

import com.sagoss.validationhorizon.api.apiInterface.ApiHelper
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenResponse
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import com.sagoss.validationhorizon.api.models.registration.RegistrationResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResponseRepository @Inject constructor(private val apiInterface: ApiHelper) {

    suspend fun getRegistrationResponse(
        registrationRequest: RegistrationRequest
    ): RegistrationResponse {
        return apiInterface.getRegistrationResponse(registrationRequest)
    }

    suspend fun getRefreshTokenResponse(
        authToken: String,
        refreshTokenRequest: RefreshTokenRequest
    ): RefreshTokenResponse {
        return apiInterface.getRefreshTokenResponse(authToken, refreshTokenRequest)
    }


}