// Generated by data binding compiler. Do not edit!
package com.sagoss.validationtesting.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.sagoss.validationtesting.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentC2cGreetingsBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appbar;

  @NonNull
  public final CardView cvMsg;

  @NonNull
  public final MaterialToolbar toolbar;

  @NonNull
  public final TextView tvAppVersion;

  @NonNull
  public final TextView tvWelcomeMsg;

  protected FragmentC2cGreetingsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppBarLayout appbar, CardView cvMsg, MaterialToolbar toolbar, TextView tvAppVersion,
      TextView tvWelcomeMsg) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbar = appbar;
    this.cvMsg = cvMsg;
    this.toolbar = toolbar;
    this.tvAppVersion = tvAppVersion;
    this.tvWelcomeMsg = tvWelcomeMsg;
  }

  @NonNull
  public static FragmentC2cGreetingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_c2c_greetings, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentC2cGreetingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentC2cGreetingsBinding>inflateInternal(inflater, R.layout.fragment_c2c_greetings, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentC2cGreetingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_c2c_greetings, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentC2cGreetingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentC2cGreetingsBinding>inflateInternal(inflater, R.layout.fragment_c2c_greetings, null, false, component);
  }

  public static FragmentC2cGreetingsBinding bind(@NonNull View view) {
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
  public static FragmentC2cGreetingsBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentC2cGreetingsBinding)bind(component, view, R.layout.fragment_c2c_greetings);
  }
}
