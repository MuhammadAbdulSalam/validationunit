package com.sagoss.validationtesting.ui.fragments.basefragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H$J\b\u0010\u0015\u001a\u00020\u0016H$J\b\u0010\u0017\u001a\u00020\u0018H$J\b\u0010\u0019\u001a\u00020\u0018H$J\b\u0010\u001a\u001a\u00020\u001bH$J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH$J\r\u0010 \u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0007J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010-\u001a\u00020\u0018H$J\b\u0010.\u001a\u00020/H$J\b\u00100\u001a\u000201H$J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002J\b\u00104\u001a\u00020\u001fH$J\b\u00105\u001a\u00020\u001dH\u0002R\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u00066"}, d2 = {"Lcom/sagoss/validationtesting/ui/fragments/basefragments/ValidationResultsBaseFragment;", "VBinding", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "timer", "Ljava/util/Timer;", "viewModel", "Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "getViewModel", "()Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "btnDone", "Lcom/google/android/material/button/MaterialButton;", "currentVoucher", "Lcom/sagoss/validationtesting/database/models/Voucher;", "dateFrom", "", "dateTo", "enterHomeFrag", "Landroidx/navigation/NavDirections;", "errorView", "", "failureCard", "Landroidx/cardview/widget/CardView;", "getViewBinding", "goToGreetings", "loadingView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "plateNumber", "plateTextBox", "Landroid/widget/TextView;", "progressbar", "Landroid/widget/LinearLayout;", "setupVouchersObserver", "storeOffline", "successCard", "successView", "validationtesting_debug"})
public abstract class ValidationResultsBaseFragment<VBinding extends androidx.viewbinding.ViewBinding> extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    protected VBinding binding;
    private java.util.Timer timer;
    
    public ValidationResultsBaseFragment() {
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
    protected abstract VBinding getViewBinding();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.sagoss.validationtesting.database.models.Voucher currentVoucher();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract java.lang.String dateTo();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract java.lang.String dateFrom();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract java.lang.String plateNumber();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.cardview.widget.CardView successCard();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.cardview.widget.CardView failureCard();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract android.widget.LinearLayout progressbar();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.material.button.MaterialButton btnDone();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract android.widget.TextView plateTextBox();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.navigation.NavDirections enterHomeFrag();
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Validate Number Plate
     * If date_to is "" set it to null, Retrofit will ignore this param if null
     *
     * Setup Results view according to results
     */
    private final void setupVouchersObserver() {
    }
    
    /**
     * If request is done offline, Store date into DB
     *
     * Date base insert dao results are taken as validation results
     * If added show success message else error
     */
    private final void storeOffline() {
    }
    
    /**
     * Make success view visible
     * Set plate text to TextBox
     */
    private final void successView() {
    }
    
    /**
     * Show Error Card and error message
     */
    private final void errorView() {
    }
    
    /**
     * Hide results view and show progressbar
     */
    private final void loadingView() {
    }
    
    /**
     * If no activity by user, wait 30 seconds and go to Greetings Screen
     */
    private final void goToGreetings() {
    }
}