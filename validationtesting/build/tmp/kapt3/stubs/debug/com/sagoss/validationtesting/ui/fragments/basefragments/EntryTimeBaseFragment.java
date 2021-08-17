package com.sagoss.validationtesting.ui.fragments.basefragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H$J\b\u0010\u0011\u001a\u00020\u0012H$J\b\u0010\u0013\u001a\u00020\u0014H$J\b\u0010\u0015\u001a\u00020\u0016H$J\b\u0010\u0017\u001a\u00020\u0016H$J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH$J\b\u0010\u001c\u001a\u00020\u001dH$J\r\u0010\u001e\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0007J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010\'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0017J\b\u0010)\u001a\u00020\u001aH$J\b\u0010*\u001a\u00020+H$J\b\u0010,\u001a\u00020-H$R\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/sagoss/validationtesting/ui/fragments/basefragments/EntryTimeBaseFragment;", "VBinding", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "prefs", "Lcom/sagoss/validationtesting/utils/Prefs;", "askDateTo", "", "btnValidate", "Lcom/google/android/material/button/MaterialButton;", "currentVoucher", "Lcom/sagoss/validationtesting/database/models/Voucher;", "datePicker", "Landroid/widget/DatePicker;", "enterDateToFrag", "Landroidx/navigation/NavDirections;", "enterHotelFrag", "enterValidationFrag", "dateTo", "", "dateFrom", "getToolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getViewBinding", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "plate", "timePicker", "Landroid/widget/TimePicker;", "tvTitle", "Landroid/widget/TextView;", "validationtesting_debug"})
public abstract class EntryTimeBaseFragment<VBinding extends androidx.viewbinding.ViewBinding> extends androidx.fragment.app.Fragment {
    protected VBinding binding;
    private com.sagoss.validationtesting.utils.Prefs prefs;
    
    public EntryTimeBaseFragment() {
        super();
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
    protected abstract android.widget.DatePicker datePicker();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract android.widget.TimePicker timePicker();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.material.button.MaterialButton btnValidate();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract android.widget.TextView tvTitle();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.sagoss.validationtesting.database.models.Voucher currentVoucher();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract java.lang.String plate();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.material.appbar.MaterialToolbar getToolbar();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.navigation.NavDirections enterDateToFrag();
    
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
    
    @android.annotation.SuppressLint(value = {"SimpleDateFormat", "NewApi", "WeekBasedYear"})
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * If contains dateToList move to Hotel Frag
     * If date to is required move to date to fragment
     * if date to is not required then validate current plate
     */
    private final void askDateTo() {
    }
}