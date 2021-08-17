package com.sagoss.validationtesting.ui.fragments.basefragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u000b\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017J\b\u0010\u0017\u001a\u00020\u0018H$J\b\u0010\u0019\u001a\u00020\u001aH$J\b\u0010\u001b\u001a\u00020\u0018H$R\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u001c"}, d2 = {"Lcom/sagoss/validationtesting/ui/fragments/basefragments/GreetingsBaseFragment;", "VBinding", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "getViewBinding", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "tvGreetingsMsg", "Landroid/widget/TextView;", "tvGreetingsMsgClickListener", "Landroid/view/View$OnClickListener;", "tvVersionInfo", "validationtesting_debug"})
public abstract class GreetingsBaseFragment<VBinding extends androidx.viewbinding.ViewBinding> extends androidx.fragment.app.Fragment {
    protected VBinding binding;
    
    public GreetingsBaseFragment() {
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
    protected abstract android.widget.TextView tvGreetingsMsg();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract android.widget.TextView tvVersionInfo();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract android.view.View.OnClickListener tvGreetingsMsgClickListener();
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}