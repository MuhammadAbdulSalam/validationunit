package com.sagoss.validationtesting.ui.fragments.basefragments;

import java.lang.System;

@android.annotation.SuppressLint(value = {"SetTextI18n"})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0003J\b\u0010\u001f\u001a\u00020 H$J\b\u0010!\u001a\u00020 H$J\b\u0010\"\u001a\u00020 H$J\b\u0010#\u001a\u00020$H$J\b\u0010%\u001a\u00020&H$J\u0018\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000fH$J\b\u0010+\u001a\u00020&H$J\b\u0010,\u001a\u00020-H$J\r\u0010.\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0007J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u00107\u001a\u0002082\u0006\u00109\u001a\u0002002\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010\u0018\u001a\u00020\u000fH$J\b\u0010:\u001a\u000208H\u0002J7\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u0012H\u0002\u00a2\u0006\u0002\u0010AR\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/sagoss/validationtesting/ui/fragments/basefragments/EnterDateToBaseFragment;", "VBinding", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "chosenDateAndTime", "", "dateToUnit", "incrementAmount", "", "incrementUnit", "incrementUnitName", "initialAmount", "limit", "minutesPerIncrement", "plate", "prefs", "Lcom/sagoss/validationtesting/utils/Prefs;", "adjustDateAndTime", "Ljava/util/Date;", "field", "amount", "btnAdd", "Lcom/google/android/material/button/MaterialButton;", "btnConfirm", "btnSubtract", "currentVoucher", "Lcom/sagoss/validationtesting/database/models/Voucher;", "durationTextView", "Landroid/widget/TextView;", "enterValidationFrag", "Landroidx/navigation/NavDirections;", "dateTo", "dateFrom", "expiryTextView", "getToolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getViewBinding", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setIncrementUnitAndValue", "updateCalendar", "unit", "increment", "initial", "unitName", "perIncremental", "(IIILjava/lang/String;Ljava/lang/Integer;)V", "validationtesting_debug"})
public abstract class EnterDateToBaseFragment<VBinding extends androidx.viewbinding.ViewBinding> extends androidx.fragment.app.Fragment {
    protected VBinding binding;
    private com.sagoss.validationtesting.utils.Prefs prefs;
    private java.lang.String dateToUnit = "";
    private java.lang.String chosenDateAndTime = "";
    private final java.util.Calendar calendar = null;
    private int incrementUnit = java.util.Calendar.DATE;
    private java.lang.String incrementUnitName = "DAY";
    private int incrementAmount = 1;
    private int initialAmount = 1;
    private int minutesPerIncrement = 1;
    private int limit = 0;
    private java.lang.String plate = "";
    
    public EnterDateToBaseFragment() {
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
    protected abstract com.google.android.material.appbar.MaterialToolbar getToolbar();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.material.button.MaterialButton btnAdd();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.material.button.MaterialButton btnSubtract();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.material.button.MaterialButton btnConfirm();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract android.widget.TextView durationTextView();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract android.widget.TextView expiryTextView();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.sagoss.validationtesting.database.models.Voucher currentVoucher();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract java.lang.String plate();
    
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
     * @param unit units to use for increment
     * @param increment amount of increment
     * @param initial initial value to be shown
     * @param unitName name of unit eg minutes, hours etc
     * @param perIncremental if in minutes
     *
     * Adjust incremental counter for add and subtract buttons
     */
    private final void updateCalendar(int unit, int increment, int initial, java.lang.String unitName, java.lang.Integer perIncremental) {
    }
    
    /**
     * Set incremental value based on voucher unit
     */
    private final void setIncrementUnitAndValue() {
    }
    
    /**
     * @param field field of date to be formatted eg day, month
     * @param amount incremental amount
     *
     * @return formatted date
     */
    @android.annotation.SuppressLint(value = {"NewApi", "WeekBasedYear"})
    private final java.util.Date adjustDateAndTime(int field, int amount) {
        return null;
    }
}