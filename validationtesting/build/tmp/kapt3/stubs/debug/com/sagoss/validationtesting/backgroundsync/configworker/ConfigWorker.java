package com.sagoss.validationtesting.backgroundsync.configworker;

import java.lang.System;

@androidx.hilt.work.HiltWorker()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/sagoss/validationtesting/backgroundsync/configworker/ConfigWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "apiOneResponseRepository", "Lcom/sagoss/validationtesting/api/repository/ApiResponseRepository;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/sagoss/validationtesting/api/repository/ApiResponseRepository;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfig", "", "validationtesting_debug"})
public final class ConfigWorker extends androidx.work.CoroutineWorker {
    private final com.sagoss.validationtesting.api.repository.ApiResponseRepository apiOneResponseRepository = null;
    
    @dagger.assisted.AssistedInject()
    public ConfigWorker(@org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    androidx.work.WorkerParameters workerParams, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.repository.ApiResponseRepository apiOneResponseRepository) {
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
     * Get config from API ONE
     * Repository stores new vouchers once received
     * We do not need to store these vouchers in worker
     */
    private final java.lang.Object getConfig(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}