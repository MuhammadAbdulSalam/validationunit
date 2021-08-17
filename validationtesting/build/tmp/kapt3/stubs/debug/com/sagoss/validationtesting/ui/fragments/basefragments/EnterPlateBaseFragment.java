package com.sagoss.validationtesting.ui.fragments.basefragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H$J\b\u0010\u0017\u001a\u00020\u0018H$J\b\u0010\u0019\u001a\u00020\u001aH$J\b\u0010\u001b\u001a\u00020\u001aH$J\b\u0010\u001c\u001a\u00020\u001aH$J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH$J\b\u0010!\u001a\u00020\"H$J\r\u0010#\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0007J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010.\u001a\u00020/H$J\b\u00100\u001a\u000201H$J\b\u00102\u001a\u000203H$J\b\u00104\u001a\u00020\u0014H\u0002R\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u00065"}, d2 = {"Lcom/sagoss/validationtesting/ui/fragments/basefragments/EnterPlateBaseFragment;", "VBinding", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "prefs", "Lcom/sagoss/validationtesting/utils/Prefs;", "viewModel", "Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "getViewModel", "()Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "askForDateTo", "", "currentVoucher", "Lcom/sagoss/validationtesting/database/models/Voucher;", "defaultColor", "", "enterDateToFrag", "Landroidx/navigation/NavDirections;", "enterEntryDateFrag", "enterHotelFrag", "enterValidationFrag", "dateTo", "", "dateFrom", "getToolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getViewBinding", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "progressbar", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "tvPlateTextView", "Landroid/widget/TextView;", "validateButton", "Lcom/google/android/material/button/MaterialButton;", "validateNumberPlate", "validationtesting_debug"})
public abstract class EnterPlateBaseFragment<VBinding extends androidx.viewbinding.ViewBinding> extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.sagoss.validationtesting.utils.Prefs prefs;
    protected VBinding binding;
    
    public EnterPlateBaseFragment() {
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
    protected abstract android.widget.TextView tvPlateTextView();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.material.appbar.MaterialToolbar getToolbar();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.material.button.MaterialButton validateButton();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.sagoss.validationtesting.database.models.Voucher currentVoucher();
    
    protected abstract int defaultColor();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.material.progressindicator.CircularProgressIndicator progressbar();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.navigation.NavDirections enterDateToFrag();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.navigation.NavDirections enterEntryDateFrag();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.navigation.NavDirections enterHotelFrag();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.navigation.NavDirections enterValidationFrag(@org.jetbrains.annotations.NotNull()
    java.lang.String dateTo, @org.jetbrains.annotations.NotNull()
    java.lang.String dateFrom);
    
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
     * Check with API if number plate is valid or not Using Api Two
     */
    private final void validateNumberPlate() {
    }
    
    /**
     * Check if dates needs to be entered manually
     * Navigate according to date_to and date_from requirements
     */
    private final void askForDateTo() {
    }
}