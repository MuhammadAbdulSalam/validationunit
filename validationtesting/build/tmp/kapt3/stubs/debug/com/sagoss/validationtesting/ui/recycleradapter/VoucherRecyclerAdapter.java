package com.sagoss.validationtesting.ui.recycleradapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/sagoss/validationtesting/ui/recycleradapter/VoucherRecyclerAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/sagoss/validationtesting/database/models/Voucher;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "backgroundColor", "", "fragment", "Landroidx/fragment/app/Fragment;", "(ILandroidx/fragment/app/Fragment;)V", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VoucherViewHolder", "validationtesting_debug"})
public final class VoucherRecyclerAdapter extends androidx.recyclerview.widget.ListAdapter<com.sagoss.validationtesting.database.models.Voucher, androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final int backgroundColor = 0;
    private final androidx.fragment.app.Fragment fragment = null;
    
    public VoucherRecyclerAdapter(int backgroundColor, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/sagoss/validationtesting/ui/recycleradapter/VoucherRecyclerAdapter$VoucherViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/sagoss/validationtesting/databinding/LayoutVouchersItemBinding;", "backgroundColor", "", "fragment", "Landroidx/fragment/app/Fragment;", "(Lcom/sagoss/validationtesting/databinding/LayoutVouchersItemBinding;ILandroidx/fragment/app/Fragment;)V", "bind", "", "item", "Lcom/sagoss/validationtesting/database/models/Voucher;", "validationtesting_debug"})
    public static final class VoucherViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.sagoss.validationtesting.databinding.LayoutVouchersItemBinding binding = null;
        private final androidx.fragment.app.Fragment fragment = null;
        
        public VoucherViewHolder(@org.jetbrains.annotations.NotNull()
        com.sagoss.validationtesting.databinding.LayoutVouchersItemBinding binding, int backgroundColor, @org.jetbrains.annotations.NotNull()
        androidx.fragment.app.Fragment fragment) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.sagoss.validationtesting.database.models.Voucher item) {
        }
    }
}