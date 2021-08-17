package com.sagoss.validationtesting.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J/\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJC\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u00052\b\b\u0001\u0010\u0010\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/sagoss/validationtesting/api/ApiOneRetrofitBuilder;", "", "getConfig", "Lcom/sagoss/validationtesting/api/models/config/Config;", "authToken", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "Lcom/sagoss/validationtesting/api/models/refreshtoken/RefreshTokenResponse;", "companyId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registration", "Lcom/sagoss/validationtesting/api/models/registration/RegistrationResponse;", "username", "password", "app_id", "mobile_id", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "validationtesting_debug"})
public abstract interface ApiOneRetrofitBuilder {
    @org.jetbrains.annotations.NotNull()
    public static final com.sagoss.validationtesting.api.ApiOneRetrofitBuilder.Companion Companion = null;
    
    /**
     * Registration Request for endpoint mobile/
     *
     * @param username username
     * @param password password
     * @param app_id app ID, will always be validation
     * @param mobile_id unique device ID
     * @param version app version
     *
     * @return Registration response dataclass as response body
     */
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "mobile")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object registration(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "username")
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "password")
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "app_id")
    java.lang.String app_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "mobile_id")
    java.lang.String mobile_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "version")
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.api.models.registration.RegistrationResponse> continuation);
    
    /**
     * Registration Request for endpoint mobile/
     *
     * @param username username
     * @param password password
     * @param app_id app ID, will always be validation
     * @param mobile_id unique device ID
     * @param version app version
     *
     * @return Registration response dataclass as response body
     */
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.PUT(value = "mobile")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object refreshToken(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String authToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "refresh_token")
    java.lang.String refreshToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "company_id")
    java.lang.String companyId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenResponse> continuation);
    
    /**
     * Get config request
     *
     * @param authToken authentication token stored at point
     *
     * @return config json to Object
     */
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "mobile/DataSync?key=config")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract java.lang.Object getConfig(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String authToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.api.models.config.Config> continuation);
    
    /**
     * Retrofit builder component
     */
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/sagoss/validationtesting/api/ApiOneRetrofitBuilder$Companion;", "", "()V", "BASE_URL", "", "client", "Lokhttp3/OkHttpClient;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor;", "create", "Lcom/sagoss/validationtesting/api/ApiOneRetrofitBuilder;", "validationtesting_debug"})
    public static final class Companion {
        private static final java.lang.String BASE_URL = "https://blinkenterprise.co.uk/api/";
        private static final okhttp3.logging.HttpLoggingInterceptor logger = null;
        private static final okhttp3.OkHttpClient client = null;
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.sagoss.validationtesting.api.ApiOneRetrofitBuilder create() {
            return null;
        }
    }
}