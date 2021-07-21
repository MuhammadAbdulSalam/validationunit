package com.sagoss.validationhorizon.api.repository

import android.content.Context
import android.util.Log
import com.sagoss.validationhorizon.MainActivity
import com.sagoss.validationhorizon.api.apiInterface.ApiHelper
import com.sagoss.validationhorizon.api.models.config.Config
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenResponse
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import com.sagoss.validationhorizon.api.models.registration.RegistrationResponse
import com.sagoss.validationhorizon.utils.Prefs
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiResponseRepository @Inject constructor(private val apiInterface: ApiHelper) {

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
        return apiInterface.getConfig(authToken)}


}