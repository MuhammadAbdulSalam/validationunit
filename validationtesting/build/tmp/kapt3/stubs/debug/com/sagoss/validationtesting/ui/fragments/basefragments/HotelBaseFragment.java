package com.sagoss.validationtesting.ui.fragments.basefragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH$J\b\u0010\u000f\u001a\u00020\u0010H$J\r\u0010\u0011\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H$J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u001a\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020#H$J\b\u0010$\u001a\u00020%H$J\u0018\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#H$R\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/sagoss/validationtesting/ui/fragments/basefragments/HotelBaseFragment;", "VBinding", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "prefs", "Lcom/sagoss/validationtesting/utils/Prefs;", "getItemColor", "", "getToolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getViewBinding", "getVoucher", "Lcom/sagoss/validationtesting/database/models/Voucher;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRecyclerItemSelected", "", "dateToFixed", "Lcom/sagoss/validationtesting/api/models/config/DateToFixed;", "onViewCreated", "view", "plateNumber", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "validateFrag", "Landroidx/navigation/NavDirections;", "dateFrom", "dateTo", "validationtesting_debug"})
public abstract class HotelBaseFragment<VBinding extends androidx.viewbinding.ViewBinding> extends androidx.fragment.app.Fragment {
    private com.sagoss.validationtesting.utils.Prefs prefs;
    protected VBinding binding;
    
    public HotelBaseFragment() {
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
    protected abstract androidx.recyclerview.widget.RecyclerView recycler();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.sagoss.validationtesting.database.models.Voucher getVoucher();
    
    protected abstract int getItemColor();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract java.lang.String plateNumber();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.material.appbar.MaterialToolbar getToolbar();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.navigation.NavDirections validateFrag(@org.jetbrains.annotations.NotNull()
    java.lang.String dateFrom, @org.jetbrains.annotations.NotNull()
    java.lang.String dateTo);
    
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
     * @param dateToFixed item selected from recycler
     *
     * Move direction according to item selected
     */
    public final void onRecyclerItemSelected(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.api.models.config.DateToFixed dateToFixed) {
    }
}