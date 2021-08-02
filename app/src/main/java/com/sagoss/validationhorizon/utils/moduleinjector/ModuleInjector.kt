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
            "database_name"
        ).build()
    }

    @Provides
    fun provideStudentDBRepository(voucherDao: VoucherDao, requestDao: RequestDao) =
        DBRepository(voucherDao, requestDao)
}
