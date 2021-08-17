package com.sagoss.validationtesting.backgroundsync.workerfactory;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/sagoss/validationtesting/backgroundsync/workerfactory/CustomWorkFactory;", "Landroidx/work/WorkerFactory;", "dbRepo", "Lcom/sagoss/validationtesting/database/repository/DBRepository;", "apiTwoResponseRepository", "Lcom/sagoss/validationtesting/apitwo/repositiory/ApiTwoResponseRepository;", "apiResponseRepository", "Lcom/sagoss/validationtesting/api/repository/ApiResponseRepository;", "(Lcom/sagoss/validationtesting/database/repository/DBRepository;Lcom/sagoss/validationtesting/apitwo/repositiory/ApiTwoResponseRepository;Lcom/sagoss/validationtesting/api/repository/ApiResponseRepository;)V", "getApiResponseRepository", "()Lcom/sagoss/validationtesting/api/repository/ApiResponseRepository;", "getApiTwoResponseRepository", "()Lcom/sagoss/validationtesting/apitwo/repositiory/ApiTwoResponseRepository;", "getDbRepo", "()Lcom/sagoss/validationtesting/database/repository/DBRepository;", "createWorker", "Landroidx/work/ListenableWorker;", "appContext", "Landroid/content/Context;", "workerClassName", "", "workerParameters", "Landroidx/work/WorkerParameters;", "validationtesting_debug"})
public final class CustomWorkFactory extends androidx.work.WorkerFactory {
    @org.jetbrains.annotations.NotNull()
    private final com.sagoss.validationtesting.database.repository.DBRepository dbRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository apiTwoResponseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.sagoss.validationtesting.api.repository.ApiResponseRepository apiResponseRepository = null;
    
    @javax.inject.Inject()
    public CustomWorkFactory(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.repository.DBRepository dbRepo, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository apiTwoResponseRepository, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.repository.ApiResponseRepository apiResponseRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sagoss.validationtesting.database.repository.DBRepository getDbRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository getApiTwoResponseRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sagoss.validationtesting.api.repository.ApiResponseRepository getApiResponseRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public androidx.work.ListenableWorker createWorker(@org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    java.lang.String workerClassName, @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters workerParameters) {
        return null;
    }
}