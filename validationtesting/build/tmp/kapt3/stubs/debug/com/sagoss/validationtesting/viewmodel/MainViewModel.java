package com.sagoss.validationtesting.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ*\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eJ2\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000b0\nJ\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000b0\n2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aJ*\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000b0\n2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001aJ\"\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u000b0\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001aJ\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u000b0\n2\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "apiOneRepository", "Lcom/sagoss/validationtesting/api/repository/ApiResponseRepository;", "apiTwoRepository", "Lcom/sagoss/validationtesting/apitwo/repositiory/ApiTwoResponseRepository;", "dbRepository", "Lcom/sagoss/validationtesting/database/repository/DBRepository;", "(Lcom/sagoss/validationtesting/api/repository/ApiResponseRepository;Lcom/sagoss/validationtesting/apitwo/repositiory/ApiTwoResponseRepository;Lcom/sagoss/validationtesting/database/repository/DBRepository;)V", "checkDateIn", "Landroidx/lifecycle/LiveData;", "Lcom/sagoss/validationtesting/utils/Resource;", "Lcom/sagoss/validationtesting/apitwo/models/validate/ValidateResponse;", "plate", "", "token", "checkVoucher", "date_from", "date_to", "getAllVouchers", "", "Lcom/sagoss/validationtesting/database/models/Voucher;", "getConfig", "Lcom/sagoss/validationtesting/api/models/config/Config;", "accessToken", "context", "Landroid/content/Context;", "getRefreshToken", "Lcom/sagoss/validationtesting/api/models/refreshtoken/RefreshTokenResponse;", "refreshTokenRequest", "Lcom/sagoss/validationtesting/api/models/refreshtoken/RefreshTokenRequest;", "getRegistration", "Lcom/sagoss/validationtesting/api/models/registration/RegistrationResponse;", "registrationRequest", "Lcom/sagoss/validationtesting/api/models/registration/RegistrationRequest;", "saveRequest", "", "request", "Lcom/sagoss/validationtesting/database/models/Request;", "validationtesting_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final com.sagoss.validationtesting.api.repository.ApiResponseRepository apiOneRepository = null;
    private final com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository apiTwoRepository = null;
    private final com.sagoss.validationtesting.database.repository.DBRepository dbRepository = null;
    
    @javax.inject.Inject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.repository.ApiResponseRepository apiOneRepository, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository apiTwoRepository, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.repository.DBRepository dbRepository) {
        super();
    }
    
    /**
     * @param registrationRequest Registration Request Param object
     *
     * Gets response from API One registration call
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.sagoss.validationtesting.utils.Resource<com.sagoss.validationtesting.api.models.registration.RegistrationResponse>> getRegistration(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.models.registration.RegistrationRequest registrationRequest, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * @param accessToken Current Access token stored
     * @param refreshTokenRequest RefreshTokenRequest Params to be passed as Object
     *
     * Gets Response from API One for Token Refresh call
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.sagoss.validationtesting.utils.Resource<com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenResponse>> getRefreshToken(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenRequest refreshTokenRequest, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * @param accessToken Current Access token stored
     *
     * Gets Response from API One for Token Refresh call
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.sagoss.validationtesting.utils.Resource<com.sagoss.validationtesting.api.models.config.Config>> getConfig(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * @param plate Query param "plate"
     * @param token Access Token Query param "jtoken"
     * @param checkDateIn date in query param check_date_in
     *
     * Get response from API Two validation request
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.sagoss.validationtesting.utils.Resource<com.sagoss.validationtesting.apitwo.models.validate.ValidateResponse>> checkDateIn(@org.jetbrains.annotations.NotNull()
    java.lang.String plate, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String checkDateIn) {
        return null;
    }
    
    /**
     * @param plate Query param "plate"
     * @param token Access Token Query param "jtoken"
     * @param date_from date from query param date_from
     * @param date_to date to query param date_to
     *
     * Get response from API Two validation request
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.sagoss.validationtesting.utils.Resource<com.sagoss.validationtesting.apitwo.models.validate.ValidateResponse>> checkVoucher(@org.jetbrains.annotations.NotNull()
    java.lang.String plate, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String date_from, @org.jetbrains.annotations.NotNull()
    java.lang.String date_to) {
        return null;
    }
    
    /**
     * Get list of all vouchers
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.sagoss.validationtesting.utils.Resource<java.util.List<com.sagoss.validationtesting.database.models.Voucher>>> getAllVouchers() {
        return null;
    }
    
    /**
     * @param  request offline validation request to be added
     *
     * Store request in db for later validation
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.sagoss.validationtesting.utils.Resource<kotlin.Unit>> saveRequest(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.models.Request request) {
        return null;
    }
}