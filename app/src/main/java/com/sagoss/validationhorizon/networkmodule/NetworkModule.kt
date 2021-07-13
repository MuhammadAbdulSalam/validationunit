package com.sagoss.validationhorizon.networkmodule

import com.sagoss.validationhorizon.api.ApiOneRetrofitBuilder
import com.sagoss.validationhorizon.apitwo.ApiTwoRetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitService(): ApiOneRetrofitBuilder {
        return ApiOneRetrofitBuilder.create()
    }

    @Singleton
    @Provides
    fun provideApiTwoRetrofitService(): ApiTwoRetrofitBuilder {
        return ApiTwoRetrofitBuilder.create()
    }
}
