// Generated by data binding compiler. Do not edit!
package com.sagoss.validationtesting.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
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

public abstract class FragmentHorizonEntryTimeBinding extends ViewDataBinding {
  @NonNull
  public final ImageView appLogo;

  @NonNull
  public final AppBarLayout appbar;

  @NonNull
  public final MaterialButton btnValidate;

  @NonNull
  public final CardView cardTimeDate;

  @NonNull
  public final DatePicker datePicker;

  @NonNull
  public final TimePicker timePicker;

  @NonNull
  public final MaterialToolbar toolbar;

  @NonNull
  public final TextView tvTitle;

  protected FragmentHorizonEntryTimeBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView appLogo, AppBarLayout appbar, MaterialButton btnValidate,
      CardView cardTimeDate, DatePicker datePicker, TimePicker timePicker, MaterialToolbar toolbar,
      TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appLogo = appLogo;
    this.appbar = appbar;
    this.btnValidate = btnValidate;
    this.cardTimeDate = cardTimeDate;
    this.datePicker = datePicker;
    this.timePicker = timePicker;
    this.toolbar = toolbar;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static FragmentHorizonEntryTimeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_horizon_entry_time, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHorizonEntryTimeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentHorizonEntryTimeBinding>inflateInternal(inflater, R.layout.fragment_horizon_entry_time, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHorizonEntryTimeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_horizon_entry_time, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHorizonEntryTimeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentHorizonEntryTimeBinding>inflateInternal(inflater, R.layout.fragment_horizon_entry_time, null, false, component);
  }

  public static FragmentHorizonEntryTimeBinding bind(@NonNull View view) {
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
  public static FragmentHorizonEntryTimeBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentHorizonEntryTimeBinding)bind(component, view, R.layout.fragment_horizon_entry_time);
  }
}
