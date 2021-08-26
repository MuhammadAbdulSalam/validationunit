/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.utils.moduleinjector

import android.content.Context
import androidx.room.Room
import com.sagoss.validationhorizon.api.ApiOneRetrofitBuilder
import com.sagoss.validationhorizon.apitwo.ApiTwoRetrofitBuilder
import com.sagoss.validationhorizon.database.ValidationDatabase
import com.sagoss.validationhorizon.database.dao.RequestDao
import com.sagoss.validationhorizon.database.dao.VoucherDao
import com.sagoss.validationhorizon.database.repository.DBRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ModuleInjector {

    /**
     * Retrofit API One Injection
     */
    @Singleton
    @Provides
    fun provideRetrofitService(): ApiOneRetrofitBuilder {
        return ApiOneRetrofitBuilder.create()
    }

    /**
     * Retrofit API Two Injection
     */
    @Singleton
    @Provides
    fun provideApiTwoRetrofitService(): ApiTwoRetrofitBuilder {
        return ApiTwoRetrofitBuilder.create()
    }

    /**
     * @param validationDatabase validation database instance to get dao
     * Voucher Dao Injection
     */
    @Provides
    fun provideVoucherDao(validationDatabase: ValidationDatabase): VoucherDao {
        return validationDatabase.voucherDao()
    }

    /**
     * @param validationDatabase validation database instance to get dao
     * request Dao Injection
     */
    @Provides
    fun provideRequestDao(validationDatabase: ValidationDatabase): RequestDao {
        return validationDatabase.requestDao()
    }

    /**
     * @param appContext Application context to initialise Database
     * Room Database Injection
     */
    @Provides
    @Singleton
    fun provideValidationDatabase(@ApplicationContext appContext: Context): ValidationDatabase {
        return Room.databaseBuilder(
            appContext,
            ValidationDatabase::class.java,
            "database_test"
        ).build()
    }

    /**
     * @param voucherDao Voucher Dao
     * @param requestDao Request Dao
     * DBRepository injection
     */
    @Provides
    fun provideValidationDBRepository(voucherDao: VoucherDao, requestDao: RequestDao) =
        DBRepository(voucherDao, requestDao)

}
