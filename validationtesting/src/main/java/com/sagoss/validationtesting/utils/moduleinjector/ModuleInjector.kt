/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.utils.moduleinjector

import android.content.Context
import androidx.room.Room
import com.sagoss.validationtesting.api.ApiOneRetrofitBuilder
import com.sagoss.validationtesting.apitwo.ApiTwoRetrofitBuilder
import com.sagoss.validationtesting.database.ValidationDatabase
import com.sagoss.validationtesting.database.dao.RequestDao
import com.sagoss.validationtesting.database.dao.VoucherDao
import com.sagoss.validationtesting.database.repository.DBRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ModuleInjector {

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

    @Provides
    fun provideVoucherDao(validationDatabase: ValidationDatabase): VoucherDao {
        return validationDatabase.voucherDao()
    }

    @Provides
    fun provideRequestDao(validationDatabase: ValidationDatabase): RequestDao {
        return validationDatabase.requestDao()
    }

    @Provides
    @Singleton
    fun provideValidationDatabase(@ApplicationContext appContext: Context): ValidationDatabase {
        return Room.databaseBuilder(
            appContext,
            ValidationDatabase::class.java,
            "database_test"
        ).build()
    }

    @Provides
    fun provideValidationDBRepository(voucherDao: VoucherDao, requestDao: RequestDao) =
        DBRepository(voucherDao, requestDao)
}
