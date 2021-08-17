// Generated by data binding compiler. Do not edit!
package com.sagoss.validationtesting.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.sagoss.validationtesting.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentHorizonHotelBinding extends ViewDataBinding {
  @NonNull
  public final ImageView appLogo;

  @NonNull
  public final AppBarLayout appbar;

  @NonNull
  public final RecyclerView recycler;

  @NonNull
  public final CardView stayTextView;

  @NonNull
  public final MaterialToolbar toolbar;

  protected FragmentHorizonHotelBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView appLogo, AppBarLayout appbar, RecyclerView recycler, CardView stayTextView,
      MaterialToolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appLogo = appLogo;
    this.appbar = appbar;
    this.recycler = recycler;
    this.stayTextView = stayTextView;
    this.toolbar = toolbar;
  }

  @NonNull
  public static FragmentHorizonHotelBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_horizon_hotel, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHorizonHotelBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentHorizonHotelBinding>inflateInternal(inflater, R.layout.fragment_horizon_hotel, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHorizonHotelBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_horizon_hotel, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHorizonHotelBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentHorizonHotelBinding>inflateInternal(inflater, R.layout.fragment_horizon_hotel, null, false, component);
  }

  public static FragmentHorizonHotelBinding bind(@NonNull View view) {
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
  public static FragmentHorizonHotelBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentHorizonHotelBinding)bind(component, view, R.layout.fragment_horizon_hotel);
  }
}