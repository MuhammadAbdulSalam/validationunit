package com.sagoss.validationtesting.api.apiInterface;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/sagoss/validationtesting/api/apiInterface/ApiHelper;", "", "apiService", "Lcom/sagoss/validationtesting/api/ApiOneRetrofitBuilder;", "(Lcom/sagoss/validationtesting/api/ApiOneRetrofitBuilder;)V", "getConfig", "Lcom/sagoss/validationtesting/api/models/config/Config;", "authToken", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRefreshTokenResponse", "Lcom/sagoss/validationtesting/api/models/refreshtoken/RefreshTokenResponse;", "refreshTokenRequest", "Lcom/sagoss/validationtesting/api/models/refreshtoken/RefreshTokenRequest;", "(Ljava/lang/String;Lcom/sagoss/validationtesting/api/models/refreshtoken/RefreshTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRegistrationResponse", "Lcom/sagoss/validationtesting/api/models/registration/RegistrationResponse;", "registrationRequest", "Lcom/sagoss/validationtesting/api/models/registration/RegistrationRequest;", "(Lcom/sagoss/validationtesting/api/models/registration/RegistrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validationtesting_debug"})
@javax.inject.Singleton()
public final class ApiHelper {
    private final com.sagoss.validationtesting.api.ApiOneRetrofitBuilder apiService = null;
    
    @javax.inject.Inject()
    public ApiHelper(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.ApiOneRetrofitBuilder apiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRegistrationResponse(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.models.registration.RegistrationRequest registrationRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.api.models.registration.RegistrationResponse> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRefreshTokenResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String authToken, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenRequest refreshTokenRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenResponse> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getConfig(@org.jetbrains.annotations.NotNull()
    java.lang.String authToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.api.models.config.Config> continuation) {
        return null;
    }
}