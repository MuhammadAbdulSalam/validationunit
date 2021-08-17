package com.sagoss.validationtesting.ui.fragments.basefragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001c\u001a\u00020\u001dH$J\r\u0010\u001e\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0017J\b\u0010*\u001a\u00020 H\u0016J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020 H\u0016J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u000201H$R\u001c\u0010\u0006\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00062"}, d2 = {"Lcom/sagoss/validationtesting/ui/fragments/basefragments/NoConfigBaseFragment;", "VBinding", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "Lcom/sagoss/validationtesting/utils/InternetConnectionInterface;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "handler", "Landroid/os/Handler;", "helperDialog", "Landroid/app/AlertDialog;", "isRunning", "", "prefs", "Lcom/sagoss/validationtesting/utils/Prefs;", "runnable", "Ljava/lang/Runnable;", "viewModel", "Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "getViewModel", "()Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getDirection", "Landroidx/navigation/NavDirections;", "getViewBinding", "onConnected", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDisconnected", "onResume", "onStop", "setupGetConfigObserver", "authToken", "", "tvDeviceID", "Landroid/widget/TextView;", "validationtesting_debug"})
public abstract class NoConfigBaseFragment<VBinding extends androidx.viewbinding.ViewBinding> extends androidx.fragment.app.Fragment implements com.sagoss.validationtesting.utils.InternetConnectionInterface {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    protected VBinding binding;
    private java.lang.Runnable runnable;
    private com.sagoss.validationtesting.utils.Prefs prefs;
    private android.app.AlertDialog helperDialog;
    private android.os.Handler handler;
    private boolean isRunning = false;
    
    public NoConfigBaseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.sagoss.validationtesting.viewmodel.MainViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final VBinding getBinding() {
        return null;
    }
    
    protected final void setBinding(@org.jetbrains.annotations.NotNull()
    VBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract android.widget.TextView tvDeviceID();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract VBinding getViewBinding();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.navigation.NavDirections getDirection();
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    /**
     * @param authToken authorisation Token as Header
     *
     * Retrieve Config data
     */
    private final void setupGetConfigObserver(java.lang.String authToken) {
    }
    
    /**
     * Start get config runnable to check for config settings
     */
    @java.lang.Override()
    public void onConnected() {
    }
    
    /**
     * Disable config check and show disconnected error message
     */
    @java.lang.Override()
    public void onDisconnected() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
}