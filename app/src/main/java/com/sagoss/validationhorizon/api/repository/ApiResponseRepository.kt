package com.sagoss.validationhorizon.api.repository

import android.util.Log
import com.sagoss.validationhorizon.api.apiInterface.ApiHelper
import com.sagoss.validationhorizon.api.models.config.Config
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenResponse
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import com.sagoss.validationhorizon.api.models.registration.RegistrationResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiResponseRepository @Inject constructor(private val apiInterface: ApiHelper) {

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

    suspend fun getConfig(authToken: String): Config {
        Log.d("-----", "------------------------REPO----------------")

        return apiInterface.getConfig(authToken)}


}