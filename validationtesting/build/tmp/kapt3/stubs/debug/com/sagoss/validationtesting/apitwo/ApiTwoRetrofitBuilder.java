package com.sagoss.validationtesting.apitwo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ;\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u00052\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/sagoss/validationtesting/apitwo/ApiTwoRetrofitBuilder;", "", "checkDateIn", "Lcom/sagoss/validationtesting/apitwo/models/validate/ValidateResponse;", "plate", "", "token", "check_date_in", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkVoucher", "date_from", "date_to", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "validationtesting_debug"})
public abstract interface ApiTwoRetrofitBuilder {
    @org.jetbrains.annotations.NotNull()
    public static final com.sagoss.validationtesting.apitwo.ApiTwoRetrofitBuilder.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "KioskWebValidate")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract java.lang.Object checkDateIn(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "plate")
    java.lang.String plate, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "jtoken")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "check_date_in")
    java.lang.String check_date_in, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.apitwo.models.validate.ValidateResponse> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "KioskWebValidate")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract java.lang.Object checkVoucher(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "plate")
    java.lang.String plate, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "jtoken")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "date_from")
    java.lang.String date_from, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "date_to")
    java.lang.String date_to, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.apitwo.models.validate.ValidateResponse> continuation);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/sagoss/validationtesting/apitwo/ApiTwoRetrofitBuilder$Companion;", "", "()V", "BASE_URL", "", "client", "Lokhttp3/OkHttpClient;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor;", "create", "Lcom/sagoss/validationtesting/apitwo/ApiTwoRetrofitBuilder;", "validationtesting_debug"})
    public static final class Companion {
        private static final java.lang.String BASE_URL = "https://blinkenterprise.co.uk/api2/";
        private static final okhttp3.logging.HttpLoggingInterceptor logger = null;
        private static final okhttp3.OkHttpClient client = null;
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.sagoss.validationtesting.apitwo.ApiTwoRetrofitBuilder create() {
            return null;
        }
    }
}