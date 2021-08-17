package com.sagoss.validationtesting.ui.fragments.loginviews;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006 "}, d2 = {"Lcom/sagoss/validationtesting/ui/fragments/loginviews/LoginCheckerFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/sagoss/validationtesting/databinding/FragmentLoginCheckerBinding;", "prefs", "Lcom/sagoss/validationtesting/utils/Prefs;", "viewModel", "Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "getViewModel", "()Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkUserRegistration", "", "enterGreetingsFrag", "enterNoConfigFrag", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "refreshToken", "authToken", "", "refreshTokenRequest", "Lcom/sagoss/validationtesting/api/models/refreshtoken/RefreshTokenRequest;", "setupGetConfigObserver", "validationtesting_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class LoginCheckerFragment extends androidx.fragment.app.Fragment {
    private com.sagoss.validationtesting.databinding.FragmentLoginCheckerBinding binding;
    private com.sagoss.validationtesting.utils.Prefs prefs;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public LoginCheckerFragment() {
        super();
    }
    
    private final com.sagoss.validationtesting.viewmodel.MainViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    /**
     * Check user registration
     * Move to fragment according to registration status and network connection
     */
    private final void checkUserRegistration() {
    }
    
    /**
     * @author current auth token
     *
     * perform refresh token
     * If refresh was success get config otherwise show error message
     */
    private final void refreshToken(java.lang.String authToken, com.sagoss.validationtesting.api.models.refreshtoken.RefreshTokenRequest refreshTokenRequest) {
    }
    
    /**
     * @param authToken authorisation Token as Header
     *
     * Retrieve Config data
     * On success start background worker
     */
    private final void setupGetConfigObserver(java.lang.String authToken) {
    }
    
    /**
     * Check initial direction for greetings page
     * Rest direction will be followed accordingly
     */
    private final void enterGreetingsFrag() {
    }
    
    /**
     * Move to no config fragment according to company ID
     * Check initial direction for No config page
     * Rest direction will be followed accordingly
     */
    private final void enterNoConfigFrag() {
    }
}