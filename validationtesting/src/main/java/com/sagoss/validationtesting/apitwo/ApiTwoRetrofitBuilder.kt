/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.apitwo

import com.sagoss.validationtesting.apitwo.models.validate.ValidateResponse
import com.sagoss.validationtesting.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiTwoRetrofitBuilder {

    @Headers(Constants.APPLICATION_JSON)
    @GET(Constants.END_POINT_KIOSK_WEB_VALIDATE)
    suspend fun checkDateIn(
        @Query(Constants.PLATE) plate: String,
        @Query(Constants.TOKEN) token: String,
        @Query(Constants.CHECK_DATE_IN) check_date_in: String
    ): ValidateResponse


    @Headers(Constants.APPLICATION_JSON)
    @GET(Constants.END_POINT_KIOSK_WEB_VALIDATE)
    suspend fun checkVoucher(
        @Query(Constants.PLATE) plate: String,
        @Query(Constants.TOKEN) token: String,
        @Query(Constants.DATE_FROM) date_from: String,
        @Query(Constants.DATE_TO) date_to: String?
    ): ValidateResponse

    companion object {
        private const val BASE_URL = Constants.API_URL_TWO
        private val logger =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        private val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        fun create(): ApiTwoRetrofitBuilder {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiTwoRetrofitBuilder::class.java)
        }
    }
}