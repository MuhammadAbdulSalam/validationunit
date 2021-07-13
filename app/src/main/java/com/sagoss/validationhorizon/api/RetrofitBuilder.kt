package com.sagoss.validationhorizon.api

import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenResponse
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import com.sagoss.validationhorizon.api.models.registration.RegistrationResponse
import com.sagoss.validationhorizon.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitBuilder {

    @Headers("Content-Type: application/json")
    @POST("/mobile")
    suspend fun registration(@Body registrationRequest: RegistrationRequest): RegistrationResponse

    @Headers("Content-Type: application/json")
    @POST("/mobile")
    suspend fun refreshToken(@Header("Authorization") authToken: String, @Body refreshTokenRequest: RefreshTokenRequest): RefreshTokenResponse

    companion object {
        private const val BASE_URL = Constants.API_URL_1
        private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        private val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        fun create(): RetrofitBuilder {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitBuilder::class.java)
        }
    }
}