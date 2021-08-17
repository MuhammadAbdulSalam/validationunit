package com.sagoss.validationtesting.ui.fragments.basefragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u000eH$J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H$J\b\u0010\u001a\u001a\u00020\u001bH$J\b\u0010\u001c\u001a\u00020\u001dH$J\r\u0010\u001e\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\tJ&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u000e\u0010\'\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010+\u001a\u00020(H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006,"}, d2 = {"Lcom/sagoss/validationtesting/ui/fragments/basefragments/VouchersListBaseFragment;", "VBinding", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/sagoss/validationtesting/ui/recycleradapter/VoucherRecyclerAdapter;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewModel", "Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "getViewModel", "()Lcom/sagoss/validationtesting/viewmodel/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getRecycler", "getRecyclerDirection", "Landroidx/navigation/NavDirections;", "voucher", "Lcom/sagoss/validationtesting/database/models/Voucher;", "getRecyclerItemColor", "", "getToolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getViewBinding", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRecyclerClick", "", "onViewCreated", "view", "setupVouchersObserver", "validationtesting_debug"})
public abstract class VouchersListBaseFragment<VBinding extends androidx.viewbinding.ViewBinding> extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    protected VBinding binding;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.sagoss.validationtesting.ui.recycleradapter.VoucherRecyclerAdapter adapter;
    
    public VouchersListBaseFragment() {
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
    protected abstract androidx.recyclerview.widget.RecyclerView getRecycler();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.navigation.NavDirections getRecyclerDirection(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.models.Voucher voucher);
    
    protected abstract int getRecyclerItemColor();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.material.appbar.MaterialToolbar getToolbar();
    
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
     * Retrieve all vouchers list from DB
     */
    private final void setupVouchersObserver() {
    }
    
    /**
     * Direction from voucher recycler item selected
     *
     * if internet is not available move to next fragment
     * if internet is not available and voucher can work offline, move forward
     */
    public final void onRecyclerClick(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.models.Voucher voucher) {
    }
}