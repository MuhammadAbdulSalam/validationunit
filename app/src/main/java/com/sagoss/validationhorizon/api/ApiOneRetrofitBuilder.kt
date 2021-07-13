package com.sagoss.validationhorizon.api

import android.app.usage.ConfigurationStats
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenResponse
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import com.sagoss.validationhorizon.api.models.registration.RegistrationResponse
import com.sagoss.validationhorizon.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiOneRetrofitBuilder {

    @Headers(Constants.APPLICATION_JSON)
    @POST(Constants.ENDPOINT_MOBILE)
    suspend fun registration(@Body registrationRequest: RegistrationRequest): RegistrationResponse


    @Headers(Constants.APPLICATION_JSON)
    @GET(Constants.ENDPOINT_MOBILE)
    suspend fun refreshToken(@Header(Constants.AUTHORISATION) authToken: String,
                             @Body refreshTokenRequest: RefreshTokenRequest): RefreshTokenResponse

    companion object {
        private const val BASE_URL = Constants.API_URL_ONE
        private val logger =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        private val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        fun create(): ApiOneRetrofitBuilder {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiOneRetrofitBuilder::class.java)
        }
    }
}