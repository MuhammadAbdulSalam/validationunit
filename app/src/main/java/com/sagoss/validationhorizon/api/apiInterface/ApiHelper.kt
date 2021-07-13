package com.sagoss.validationhorizon.api.apiInterface

import com.sagoss.validationhorizon.api.RetrofitBuilder
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHelper @Inject constructor(private val apiService: RetrofitBuilder) {

    suspend fun getRegistrationResponse(registrationRequest: RegistrationRequest) =
        apiService.registration(registrationRequest)

    suspend fun getRefreshTokenResponse(authToken: String, refreshTokenRequest: RefreshTokenRequest) =
        apiService.refreshToken(authToken, refreshTokenRequest)
}