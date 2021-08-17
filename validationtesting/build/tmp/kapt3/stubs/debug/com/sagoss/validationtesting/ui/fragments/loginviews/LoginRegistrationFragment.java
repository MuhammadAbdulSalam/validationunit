package com.sagoss.validationtesting.ui.fragments.loginviews;

import java.lang.System;

@android.annotation.SuppressLint(value = {"HardwareIds"})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/sagoss/validationtesting/ui/fragments/loginviews/LoginRegistrationFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/sagoss/validationtesting/utils/InternetConnectionInterface;", "()V", "binding", "Lcom/sagoss/validationtesting/databinding/FragmentLoginRegistrationBinding;", "helperDialog", "Landroid/app/AlertDialog;", "prefs", "Lcom/sagoss/validationtesting/utils/Prefs;", "viewModel", "Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "getViewModel", "()Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onConnected", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDisconnected", "onResume", "onStop", "setupRegistrationObserver", "registrationRequest", "Lcom/sagoss/validationtesting/api/models/registration/RegistrationRequest;", "validationtesting_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class LoginRegistrationFragment extends androidx.fragment.app.Fragment implements com.sagoss.validationtesting.utils.InternetConnectionInterface {
    private com.sagoss.validationtesting.databinding.FragmentLoginRegistrationBinding binding;
    private com.sagoss.validationtesting.utils.Prefs prefs;
    private android.app.AlertDialog helperDialog;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public LoginRegistrationFragment() {
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
    
    /**
     * @param registrationRequest registration request body
     *
     * Retrieve Registration Data
     */
    private final void setupRegistrationObserver(com.sagoss.validationtesting.api.models.registration.RegistrationRequest registrationRequest) {
    }
    
    /**
     * Show no internet dialog on network disconnected
     */
    @java.lang.Override()
    public void onDisconnected() {
    }
    
    /**
     * hide no internet dialog on network disconnected
     */
    @java.lang.Override()
    public void onConnected() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
}