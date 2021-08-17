package com.sagoss.validationtesting.apitwo.apiinterface;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ3\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/sagoss/validationtesting/apitwo/apiinterface/ApiTwoHelper;", "", "apiService", "Lcom/sagoss/validationtesting/apitwo/ApiTwoRetrofitBuilder;", "(Lcom/sagoss/validationtesting/apitwo/ApiTwoRetrofitBuilder;)V", "checkDateIn", "Lcom/sagoss/validationtesting/apitwo/models/validate/ValidateResponse;", "plate", "", "token", "check_date_in", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkVoucher", "date_from", "date_to", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validationtesting_debug"})
@javax.inject.Singleton()
public final class ApiTwoHelper {
    private final com.sagoss.validationtesting.apitwo.ApiTwoRetrofitBuilder apiService = null;
    
    @javax.inject.Inject()
    public ApiTwoHelper(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.apitwo.ApiTwoRetrofitBuilder apiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object checkDateIn(@org.jetbrains.annotations.NotNull()
    java.lang.String plate, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String check_date_in, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.apitwo.models.validate.ValidateResponse> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object checkVoucher(@org.jetbrains.annotations.NotNull()
    java.lang.String plate, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String date_from, @org.jetbrains.annotations.Nullable()
    java.lang.String date_to, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.apitwo.models.validate.ValidateResponse> continuation) {
        return null;
    }
}