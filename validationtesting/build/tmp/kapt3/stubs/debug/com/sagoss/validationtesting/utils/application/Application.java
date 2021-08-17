package com.sagoss.validationtesting.utils.application;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/sagoss/validationtesting/utils/application/Application;", "Landroid/app/Application;", "Landroidx/work/Configuration$Provider;", "()V", "apiResponseRepository", "Lcom/sagoss/validationtesting/api/repository/ApiResponseRepository;", "getApiResponseRepository", "()Lcom/sagoss/validationtesting/api/repository/ApiResponseRepository;", "setApiResponseRepository", "(Lcom/sagoss/validationtesting/api/repository/ApiResponseRepository;)V", "apiTwoResponseRepository", "Lcom/sagoss/validationtesting/apitwo/repositiory/ApiTwoResponseRepository;", "getApiTwoResponseRepository", "()Lcom/sagoss/validationtesting/apitwo/repositiory/ApiTwoResponseRepository;", "setApiTwoResponseRepository", "(Lcom/sagoss/validationtesting/apitwo/repositiory/ApiTwoResponseRepository;)V", "dbRepository", "Lcom/sagoss/validationtesting/database/repository/DBRepository;", "getDbRepository", "()Lcom/sagoss/validationtesting/database/repository/DBRepository;", "setDbRepository", "(Lcom/sagoss/validationtesting/database/repository/DBRepository;)V", "getWorkManagerConfiguration", "Landroidx/work/Configuration;", "onCreate", "", "validationtesting_debug"})
@dagger.hilt.android.HiltAndroidApp()
public final class Application extends android.app.Application implements androidx.work.Configuration.Provider {
    @javax.inject.Inject()
    public com.sagoss.validationtesting.database.repository.DBRepository dbRepository;
    @javax.inject.Inject()
    public com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository apiTwoResponseRepository;
    @javax.inject.Inject()
    public com.sagoss.validationtesting.api.repository.ApiResponseRepository apiResponseRepository;
    
    public Application() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sagoss.validationtesting.database.repository.DBRepository getDbRepository() {
        return null;
    }
    
    public final void setDbRepository(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.repository.DBRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository getApiTwoResponseRepository() {
        return null;
    }
    
    public final void setApiTwoResponseRepository(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sagoss.validationtesting.api.repository.ApiResponseRepository getApiResponseRepository() {
        return null;
    }
    
    public final void setApiResponseRepository(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.repository.ApiResponseRepository p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    /**
     * Override Work manager configuration
     * Implement custom work factory to enable
     * custom constructors or our workers
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.work.Configuration getWorkManagerConfiguration() {
        return null;
    }
}