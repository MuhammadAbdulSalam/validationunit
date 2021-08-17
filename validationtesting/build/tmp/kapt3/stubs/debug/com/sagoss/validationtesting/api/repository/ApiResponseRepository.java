package com.sagoss.validationtesting.api.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/sagoss/validationtesting/api/repository/ApiResponseRepository;", "", "apiInterface", "Lcom/sagoss/validationtesting/api/apiInterface/ApiHelper;", "dbRepository", "Lcom/sagoss/validationtesting/database/repository/DBRepository;", "(Lcom/sagoss/validationtesting/api/apiInterface/ApiHelper;Lcom/sagoss/validationtesting/database/repository/DBRepository;)V", "getConfig", "Lcom/sagoss/validationtesting/api/models/config/Config;", "authToken", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRefreshTokenResponse", "Lcom/sagoss/validationtesting/api/models/refreshtoken/RefreshTokenResponse;", "refreshTokenRequest", "Lcom/sagoss/validationtesting/api/models/refreshtoken/RefreshTokenRequest;", "(Ljava/lang/String;Lcom/sagoss/validationtesting/api/models/refreshtoken/RefreshTokenRequest;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRegistrationResponse", "Lcom/sagoss/validationtesting/api/models/registration/RegistrationResponse;", "registrationRequest", "Lcom/sagoss/validationtesting/api/models/registration/RegistrationRequest;", "(Lcom/sagoss/validationtesting/api/models/registration/RegistrationRequest;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validationtesting_debug"})
@javax.inject.Singleton()
public final class ApiResponseRepository {
    private final com.sagoss.validationtesting.api.apiInterface.ApiHelper apiInterface = null;
    private final com.sagoss.validationtesting.database.repository.DBRepository dbRepository = null;
    
    @javax.inject.Inject()
    public ApiResponseRepository(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.apiInterface.ApiHelper apiInterface, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.repository.DBRepository dbRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRegistrationResponse(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.models.registration.RegistrationRequest registrationRequest, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.api.models.registration.RegistrationResponse> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRefreshTokenResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String authToken, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenRequest refreshTokenRequest, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenResponse> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getConfig(@org.jetbrains.annotations.NotNull()
    java.lang.String authToken, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.api.models.config.Config> continuation) {
        return null;
    }
}