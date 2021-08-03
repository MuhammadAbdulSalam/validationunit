package com.sagoss.validationhorizon.api

import com.sagoss.validationhorizon.api.models.config.Config
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenResponse
import com.sagoss.validationhorizon.api.models.registration.RegistrationResponse
import com.sagoss.validationhorizon.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiOneRetrofitBuilder {

    /**
     * Registration Request for endpoint mobile/
     *
     * @param username username
     * @param password password
     * @param app_id app ID, will always be validation
     * @param mobile_id unique device ID
     * @param version app version
     *
     * @return Registration response dataclass as response body
     */
    @FormUrlEncoded
    @POST(Constants.ENDPOINT_MOBILE)
    suspend fun registration(
        @Field(value = Constants.PARAM_USERNAME)    username: String,
        @Field(value = Constants.PARAM_PASSWORD)    password: String,
        @Field(value = Constants.PARAM_APP_ID)      app_id: String,
        @Field(value = Constants.PARAM_MOBILE_ID)   mobile_id: String,
        @Field(value = Constants.PARAM_VERSION)     version: String,
    ): RegistrationResponse


    /**
     * Registration Request for endpoint mobile/
     *
     * @param username username
     * @param password password
     * @param app_id app ID, will always be validation
     * @param mobile_id unique device ID
     * @param version app version
     *
     * @return Registration response dataclass as response body
     */
    @FormUrlEncoded
    @GET(Constants.ENDPOINT_MOBILE)
    suspend fun refreshToken(
        @Header(Constants.AUTHORISATION) authToken: String,
        @Body refreshTokenRequest: RefreshTokenRequest
    ): RefreshTokenResponse


    /**
     * Get config request
     *
     * @param authToken authentication token stored at point
     *
     * @return config json to Object
     */
    @Headers(Constants.APPLICATION_JSON)
    @GET(Constants.ENDPOINT_CONFIG)
    suspend fun getConfig(
        @Header(Constants.AUTHORISATION) authToken: String,
    ): Config



    /**
     * Retrofit builder component
     */
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