package com.sagoss.validationtesting.backgroundsync.requestworker;

import java.lang.System;

@androidx.hilt.work.HiltWorker()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0011\u0010\u0014\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/sagoss/validationtesting/backgroundsync/requestworker/RequestsWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "dbRepository", "Lcom/sagoss/validationtesting/database/repository/DBRepository;", "apiTwoResponseRepository", "Lcom/sagoss/validationtesting/apitwo/repositiory/ApiTwoResponseRepository;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/sagoss/validationtesting/database/repository/DBRepository;Lcom/sagoss/validationtesting/apitwo/repositiory/ApiTwoResponseRepository;)V", "deleteOldTickets", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSuccessfulRequest", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWork", "Landroidx/work/ListenableWorker$Result;", "validateOfflineRequests", "validationtesting_debug"})
public final class RequestsWorker extends androidx.work.CoroutineWorker {
    private final com.sagoss.validationtesting.database.repository.DBRepository dbRepository = null;
    private final com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository apiTwoResponseRepository = null;
    
    @dagger.assisted.AssistedInject()
    public RequestsWorker(@org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    androidx.work.WorkerParameters workerParams, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.repository.DBRepository dbRepository, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository apiTwoResponseRepository) {
        super(null, null);
    }
    
    /**
     * Start worker to validate offline stored requests
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> continuation) {
        return null;
    }
    
    /**
     * Validate all requests that were stored in offline mode
     */
    private final java.lang.Object validateOfflineRequests(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * Delete all records older then 15 days
     */
    private final java.lang.Object deleteOldTickets(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * @param id of Request to be deleted
     * Delete request from database
     */
    private final java.lang.Object deleteSuccessfulRequest(int id, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}