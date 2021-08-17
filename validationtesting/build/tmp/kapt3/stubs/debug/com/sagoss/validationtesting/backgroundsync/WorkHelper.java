package com.sagoss.validationtesting.backgroundsync;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"Lcom/sagoss/validationtesting/backgroundsync/WorkHelper;", "", "()V", "initConfigWorker", "", "context", "Landroid/content/Context;", "initRequestWorker", "initWorkers", "validationtesting_debug"})
public final class WorkHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.sagoss.validationtesting.backgroundsync.WorkHelper INSTANCE = null;
    
    private WorkHelper() {
        super();
    }
    
    /**
     * initialise both workers
     */
    public final void initWorkers(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * @param context Non null context
     *
     * Run Request worker to validate offline validations
     * preferred application context to make sure its never null
     * Request worker will be executed every 15 minutes
     * Unique worker, to make sure its not duplicated
     */
    private final void initRequestWorker(android.content.Context context) {
    }
    
    /**
     * @param context Non null context
     *
     * Run Config worker to get config from api
     * preferred application context to make sure its never null
     * Request worker will be executed every 1 day
     * Unique worker, to make sure its not duplicated
     */
    private final void initConfigWorker(android.content.Context context) {
    }
}