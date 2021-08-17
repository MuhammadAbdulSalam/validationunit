package com.sagoss.validationtesting.utils.moduleinjector;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0012\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/sagoss/validationtesting/utils/moduleinjector/ModuleInjector;", "", "()V", "provideApiTwoRetrofitService", "Lcom/sagoss/validationtesting/apitwo/ApiTwoRetrofitBuilder;", "provideRequestDao", "Lcom/sagoss/validationtesting/database/dao/RequestDao;", "validationDatabase", "Lcom/sagoss/validationtesting/database/ValidationDatabase;", "provideRetrofitService", "Lcom/sagoss/validationtesting/api/ApiOneRetrofitBuilder;", "provideValidationDBRepository", "Lcom/sagoss/validationtesting/database/repository/DBRepository;", "voucherDao", "Lcom/sagoss/validationtesting/database/dao/VoucherDao;", "requestDao", "provideValidationDatabase", "appContext", "Landroid/content/Context;", "provideVoucherDao", "validationtesting_debug"})
@dagger.Module()
public final class ModuleInjector {
    
    public ModuleInjector() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.sagoss.validationtesting.api.ApiOneRetrofitBuilder provideRetrofitService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.sagoss.validationtesting.apitwo.ApiTwoRetrofitBuilder provideApiTwoRetrofitService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.sagoss.validationtesting.database.dao.VoucherDao provideVoucherDao(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.ValidationDatabase validationDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.sagoss.validationtesting.database.dao.RequestDao provideRequestDao(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.ValidationDatabase validationDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.sagoss.validationtesting.database.ValidationDatabase provideValidationDatabase(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context appContext) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.sagoss.validationtesting.database.repository.DBRepository provideValidationDBRepository(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.dao.VoucherDao voucherDao, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.dao.RequestDao requestDao) {
        return null;
    }
}