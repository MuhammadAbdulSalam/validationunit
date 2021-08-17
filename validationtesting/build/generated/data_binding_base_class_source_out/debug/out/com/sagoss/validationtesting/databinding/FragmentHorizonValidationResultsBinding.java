// Generated by data binding compiler. Do not edit!
package com.sagoss.validationtesting.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

public abstract class FragmentHorizonValidationResultsBinding extends ViewDataBinding {
  @NonNull
  public final ImageView appLogo;

  @NonNull
  public final AppBarLayout appbar;

  @NonNull
  public final MaterialButton btnDone;

  @NonNull
  public final CardView failureCard;

  @NonNull
  public final TextView failureMessage;

  @NonNull
  public final LinearLayout layoutProgressbar;

  @NonNull
  public final RelativeLayout resultsView;

  @NonNull
  public final CardView successCard;

  @NonNull
  public final TextView thanksMessageTextView;

  @NonNull
  public final MaterialToolbar toolbar;

  @NonNull
  public final TextView tvPlateNo;

  protected FragmentHorizonValidationResultsBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView appLogo, AppBarLayout appbar, MaterialButton btnDone,
      CardView failureCard, TextView failureMessage, LinearLayout layoutProgressbar,
      RelativeLayout resultsView, CardView successCard, TextView thanksMessageTextView,
      MaterialToolbar toolbar, TextView tvPlateNo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appLogo = appLogo;
    this.appbar = appbar;
    this.btnDone = btnDone;
    this.failureCard = failureCard;
    this.failureMessage = failureMessage;
    this.layoutProgressbar = layoutProgressbar;
    this.resultsView = resultsView;
    this.successCard = successCard;
    this.thanksMessageTextView = thanksMessageTextView;
    this.toolbar = toolbar;
    this.tvPlateNo = tvPlateNo;
  }

  @NonNull
  public static FragmentHorizonValidationResultsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_horizon_validation_results, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHorizonValidationResultsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentHorizonValidationResultsBinding>inflateInternal(inflater, R.layout.fragment_horizon_validation_results, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHorizonValidationResultsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_horizon_validation_results, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHorizonValidationResultsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentHorizonValidationResultsBinding>inflateInternal(inflater, R.layout.fragment_horizon_validation_results, null, false, component);
  }

  public static FragmentHorizonValidationResultsBinding bind(@NonNull View view) {
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
  public static FragmentHorizonValidationResultsBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentHorizonValidationResultsBinding)bind(component, view, R.layout.fragment_horizon_validation_results);
  }
}
