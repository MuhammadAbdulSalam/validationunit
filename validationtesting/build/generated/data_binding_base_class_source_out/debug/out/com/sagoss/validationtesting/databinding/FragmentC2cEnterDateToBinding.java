// Generated by data binding compiler. Do not edit!
package com.sagoss.validationtesting.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.sagoss.validationtesting.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentC2cEnterDateToBinding extends ViewDataBinding {
  @NonNull
  public final TextView ExitBeforeField;

  @NonNull
  public final ImageView appLogo;

  @NonNull
  public final AppBarLayout appbar;

  @NonNull
  public final MaterialButton btnAdd;

  @NonNull
  public final MaterialButton btnConfirm;

  @NonNull
  public final MaterialButton btnSubtract;

  @NonNull
  public final CardView cardInfo;

  @NonNull
  public final TextView durationField;

  @NonNull
  public final CardView stayTextView;

  @NonNull
  public final MaterialToolbar toolbar;

  protected FragmentC2cEnterDateToBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView ExitBeforeField, ImageView appLogo, AppBarLayout appbar,
      MaterialButton btnAdd, MaterialButton btnConfirm, MaterialButton btnSubtract,
      CardView cardInfo, TextView durationField, CardView stayTextView, MaterialToolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ExitBeforeField = ExitBeforeField;
    this.appLogo = appLogo;
    this.appbar = appbar;
    this.btnAdd = btnAdd;
    this.btnConfirm = btnConfirm;
    this.btnSubtract = btnSubtract;
    this.cardInfo = cardInfo;
    this.durationField = durationField;
    this.stayTextView = stayTextView;
    this.toolbar = toolbar;
  }

  @NonNull
  public static FragmentC2cEnterDateToBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_c2c_enter_date_to, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentC2cEnterDateToBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentC2cEnterDateToBinding>inflateInternal(inflater, R.layout.fragment_c2c_enter_date_to, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentC2cEnterDateToBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_c2c_enter_date_to, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentC2cEnterDateToBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentC2cEnterDateToBinding>inflateInternal(inflater, R.layout.fragment_c2c_enter_date_to, null, false, component);
  }

  public static FragmentC2cEnterDateToBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentC2cEnterDateToBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentC2cEnterDateToBinding)bind(component, view, R.layout.fragment_c2c_enter_date_to);
  }
}