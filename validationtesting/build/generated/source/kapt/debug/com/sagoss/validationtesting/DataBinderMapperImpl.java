package com.sagoss.validationtesting;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.sagoss.validationtesting.databinding.ActivityMainBindingImpl;
import com.sagoss.validationtesting.databinding.DialogWarningBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentC2cEnterDateToBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentC2cEntryTimeBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentC2cGreetingsBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentC2cHotelBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentC2cNoConfigBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentC2cPlateRegistrationBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentC2cValidationCompleteBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentC2cVoucherBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentGaEnterDateToBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentGaEnterTimeBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentGaGreetingsBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentGaHotelBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentGaNoConfigBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentGaPlateRegistrationBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentGaValidationResultsBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentGaVoucherBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentHorizonEnterDateToBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentHorizonEntryTimeBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentHorizonGreetingsBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentHorizonHotelBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentHorizonNoConfigBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentHorizonPlateRegistrationBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentHorizonValidationResultsBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentHorizonVoucherBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentLoginCheckerBindingImpl;
import com.sagoss.validationtesting.databinding.FragmentLoginRegistrationBindingImpl;
import com.sagoss.validationtesting.databinding.LayoutDateToFixedHotelItemBindingImpl;
import com.sagoss.validationtesting.databinding.LayoutVouchersItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_DIALOGWARNING = 2;

  private static final int LAYOUT_FRAGMENTC2CENTERDATETO = 3;

  private static final int LAYOUT_FRAGMENTC2CENTRYTIME = 4;

  private static final int LAYOUT_FRAGMENTC2CGREETINGS = 5;

  private static final int LAYOUT_FRAGMENTC2CHOTEL = 6;

  private static final int LAYOUT_FRAGMENTC2CNOCONFIG = 7;

  private static final int LAYOUT_FRAGMENTC2CPLATEREGISTRATION = 8;

  private static final int LAYOUT_FRAGMENTC2CVALIDATIONCOMPLETE = 9;

  private static final int LAYOUT_FRAGMENTC2CVOUCHER = 10;

  private static final int LAYOUT_FRAGMENTGAENTERDATETO = 11;

  private static final int LAYOUT_FRAGMENTGAENTERTIME = 12;

  private static final int LAYOUT_FRAGMENTGAGREETINGS = 13;

  private static final int LAYOUT_FRAGMENTGAHOTEL = 14;

  private static final int LAYOUT_FRAGMENTGANOCONFIG = 15;

  private static final int LAYOUT_FRAGMENTGAPLATEREGISTRATION = 16;

  private static final int LAYOUT_FRAGMENTGAVALIDATIONRESULTS = 17;

  private static final int LAYOUT_FRAGMENTGAVOUCHER = 18;

  private static final int LAYOUT_FRAGMENTHORIZONENTERDATETO = 19;

  private static final int LAYOUT_FRAGMENTHORIZONENTRYTIME = 20;

  private static final int LAYOUT_FRAGMENTHORIZONGREETINGS = 21;

  private static final int LAYOUT_FRAGMENTHORIZONHOTEL = 22;

  private static final int LAYOUT_FRAGMENTHORIZONNOCONFIG = 23;

  private static final int LAYOUT_FRAGMENTHORIZONPLATEREGISTRATION = 24;

  private static final int LAYOUT_FRAGMENTHORIZONVALIDATIONRESULTS = 25;

  private static final int LAYOUT_FRAGMENTHORIZONVOUCHER = 26;

  private static final int LAYOUT_FRAGMENTLOGINCHECKER = 27;

  private static final int LAYOUT_FRAGMENTLOGINREGISTRATION = 28;

  private static final int LAYOUT_LAYOUTDATETOFIXEDHOTELITEM = 29;

  private static final int LAYOUT_LAYOUTVOUCHERSITEM = 30;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(30);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.dialog_warning, LAYOUT_DIALOGWARNING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_c2c_enter_date_to, LAYOUT_FRAGMENTC2CENTERDATETO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_c2c_entry_time, LAYOUT_FRAGMENTC2CENTRYTIME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_c2c_greetings, LAYOUT_FRAGMENTC2CGREETINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_c2c_hotel, LAYOUT_FRAGMENTC2CHOTEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_c2c_no_config, LAYOUT_FRAGMENTC2CNOCONFIG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_c2c_plate_registration, LAYOUT_FRAGMENTC2CPLATEREGISTRATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_c2c_validation_complete, LAYOUT_FRAGMENTC2CVALIDATIONCOMPLETE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_c2c_voucher, LAYOUT_FRAGMENTC2CVOUCHER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_ga_enter_date_to, LAYOUT_FRAGMENTGAENTERDATETO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_ga_enter_time, LAYOUT_FRAGMENTGAENTERTIME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_ga_greetings, LAYOUT_FRAGMENTGAGREETINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_ga_hotel, LAYOUT_FRAGMENTGAHOTEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_ga_no_config, LAYOUT_FRAGMENTGANOCONFIG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_ga_plate_registration, LAYOUT_FRAGMENTGAPLATEREGISTRATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_ga_validation_results, LAYOUT_FRAGMENTGAVALIDATIONRESULTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_ga_voucher, LAYOUT_FRAGMENTGAVOUCHER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_horizon_enter_date_to, LAYOUT_FRAGMENTHORIZONENTERDATETO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_horizon_entry_time, LAYOUT_FRAGMENTHORIZONENTRYTIME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_horizon_greetings, LAYOUT_FRAGMENTHORIZONGREETINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_horizon_hotel, LAYOUT_FRAGMENTHORIZONHOTEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_horizon_no_config, LAYOUT_FRAGMENTHORIZONNOCONFIG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_horizon_plate_registration, LAYOUT_FRAGMENTHORIZONPLATEREGISTRATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_horizon_validation_results, LAYOUT_FRAGMENTHORIZONVALIDATIONRESULTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_horizon_voucher, LAYOUT_FRAGMENTHORIZONVOUCHER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_login_checker, LAYOUT_FRAGMENTLOGINCHECKER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.fragment_login_registration, LAYOUT_FRAGMENTLOGINREGISTRATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.layout_date_to_fixed_hotel_item, LAYOUT_LAYOUTDATETOFIXEDHOTELITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sagoss.validationtesting.R.layout.layout_vouchers_item, LAYOUT_LAYOUTVOUCHERSITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGWARNING: {
          if ("layout/dialog_warning_0".equals(tag)) {
            return new DialogWarningBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_warning is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTC2CENTERDATETO: {
          if ("layout/fragment_c2c_enter_date_to_0".equals(tag)) {
            return new FragmentC2cEnterDateToBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_c2c_enter_date_to is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTC2CENTRYTIME: {
          if ("layout/fragment_c2c_entry_time_0".equals(tag)) {
            return new FragmentC2cEntryTimeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_c2c_entry_time is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTC2CGREETINGS: {
          if ("layout/fragment_c2c_greetings_0".equals(tag)) {
            return new FragmentC2cGreetingsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_c2c_greetings is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTC2CHOTEL: {
          if ("layout/fragment_c2c_hotel_0".equals(tag)) {
            return new FragmentC2cHotelBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_c2c_hotel is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTC2CNOCONFIG: {
          if ("layout/fragment_c2c_no_config_0".equals(tag)) {
            return new FragmentC2cNoConfigBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_c2c_no_config is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTC2CPLATEREGISTRATION: {
          if ("layout/fragment_c2c_plate_registration_0".equals(tag)) {
            return new FragmentC2cPlateRegistrationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_c2c_plate_registration is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTC2CVALIDATIONCOMPLETE: {
          if ("layout/fragment_c2c_validation_complete_0".equals(tag)) {
            return new FragmentC2cValidationCompleteBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_c2c_validation_complete is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTC2CVOUCHER: {
          if ("layout/fragment_c2c_voucher_0".equals(tag)) {
            return new FragmentC2cVoucherBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_c2c_voucher is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGAENTERDATETO: {
          if ("layout/fragment_ga_enter_date_to_0".equals(tag)) {
            return new FragmentGaEnterDateToBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ga_enter_date_to is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGAENTERTIME: {
          if ("layout/fragment_ga_enter_time_0".equals(tag)) {
            return new FragmentGaEnterTimeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ga_enter_time is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGAGREETINGS: {
          if ("layout/fragment_ga_greetings_0".equals(tag)) {
            return new FragmentGaGreetingsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ga_greetings is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGAHOTEL: {
          if ("layout/fragment_ga_hotel_0".equals(tag)) {
            return new FragmentGaHotelBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ga_hotel is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGANOCONFIG: {
          if ("layout/fragment_ga_no_config_0".equals(tag)) {
            return new FragmentGaNoConfigBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ga_no_config is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGAPLATEREGISTRATION: {
          if ("layout/fragment_ga_plate_registration_0".equals(tag)) {
            return new FragmentGaPlateRegistrationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ga_plate_registration is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGAVALIDATIONRESULTS: {
          if ("layout/fragment_ga_validation_results_0".equals(tag)) {
            return new FragmentGaValidationResultsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ga_validation_results is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGAVOUCHER: {
          if ("layout/fragment_ga_voucher_0".equals(tag)) {
            return new FragmentGaVoucherBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ga_voucher is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHORIZONENTERDATETO: {
          if ("layout/fragment_horizon_enter_date_to_0".equals(tag)) {
            return new FragmentHorizonEnterDateToBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_horizon_enter_date_to is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHORIZONENTRYTIME: {
          if ("layout/fragment_horizon_entry_time_0".equals(tag)) {
            return new FragmentHorizonEntryTimeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_horizon_entry_time is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHORIZONGREETINGS: {
          if ("layout/fragment_horizon_greetings_0".equals(tag)) {
            return new FragmentHorizonGreetingsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_horizon_greetings is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHORIZONHOTEL: {
          if ("layout/fragment_horizon_hotel_0".equals(tag)) {
            return new FragmentHorizonHotelBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_horizon_hotel is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHORIZONNOCONFIG: {
          if ("layout/fragment_horizon_no_config_0".equals(tag)) {
            return new FragmentHorizonNoConfigBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_horizon_no_config is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHORIZONPLATEREGISTRATION: {
          if ("layout/fragment_horizon_plate_registration_0".equals(tag)) {
            return new FragmentHorizonPlateRegistrationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_horizon_plate_registration is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHORIZONVALIDATIONRESULTS: {
          if ("layout/fragment_horizon_validation_results_0".equals(tag)) {
            return new FragmentHorizonValidationResultsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_horizon_validation_results is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHORIZONVOUCHER: {
          if ("layout/fragment_horizon_voucher_0".equals(tag)) {
            return new FragmentHorizonVoucherBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_horizon_voucher is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGINCHECKER: {
          if ("layout/fragment_login_checker_0".equals(tag)) {
            return new FragmentLoginCheckerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login_checker is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGINREGISTRATION: {
          if ("layout/fragment_login_registration_0".equals(tag)) {
            return new FragmentLoginRegistrationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login_registration is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTDATETOFIXEDHOTELITEM: {
          if ("layout/layout_date_to_fixed_hotel_item_0".equals(tag)) {
            return new LayoutDateToFixedHotelItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_date_to_fixed_hotel_item is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTVOUCHERSITEM: {
          if ("layout/layout_vouchers_item_0".equals(tag)) {
            return new LayoutVouchersItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_vouchers_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "clickListener");
      sKeys.put(2, "model");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(30);

    static {
      sKeys.put("layout/activity_main_0", com.sagoss.validationtesting.R.layout.activity_main);
      sKeys.put("layout/dialog_warning_0", com.sagoss.validationtesting.R.layout.dialog_warning);
      sKeys.put("layout/fragment_c2c_enter_date_to_0", com.sagoss.validationtesting.R.layout.fragment_c2c_enter_date_to);
      sKeys.put("layout/fragment_c2c_entry_time_0", com.sagoss.validationtesting.R.layout.fragment_c2c_entry_time);
      sKeys.put("layout/fragment_c2c_greetings_0", com.sagoss.validationtesting.R.layout.fragment_c2c_greetings);
      sKeys.put("layout/fragment_c2c_hotel_0", com.sagoss.validationtesting.R.layout.fragment_c2c_hotel);
      sKeys.put("layout/fragment_c2c_no_config_0", com.sagoss.validationtesting.R.layout.fragment_c2c_no_config);
      sKeys.put("layout/fragment_c2c_plate_registration_0", com.sagoss.validationtesting.R.layout.fragment_c2c_plate_registration);
      sKeys.put("layout/fragment_c2c_validation_complete_0", com.sagoss.validationtesting.R.layout.fragment_c2c_validation_complete);
      sKeys.put("layout/fragment_c2c_voucher_0", com.sagoss.validationtesting.R.layout.fragment_c2c_voucher);
      sKeys.put("layout/fragment_ga_enter_date_to_0", com.sagoss.validationtesting.R.layout.fragment_ga_enter_date_to);
      sKeys.put("layout/fragment_ga_enter_time_0", com.sagoss.validationtesting.R.layout.fragment_ga_enter_time);
      sKeys.put("layout/fragment_ga_greetings_0", com.sagoss.validationtesting.R.layout.fragment_ga_greetings);
      sKeys.put("layout/fragment_ga_hotel_0", com.sagoss.validationtesting.R.layout.fragment_ga_hotel);
      sKeys.put("layout/fragment_ga_no_config_0", com.sagoss.validationtesting.R.layout.fragment_ga_no_config);
      sKeys.put("layout/fragment_ga_plate_registration_0", com.sagoss.validationtesting.R.layout.fragment_ga_plate_registration);
      sKeys.put("layout/fragment_ga_validation_results_0", com.sagoss.validationtesting.R.layout.fragment_ga_validation_results);
      sKeys.put("layout/fragment_ga_voucher_0", com.sagoss.validationtesting.R.layout.fragment_ga_voucher);
      sKeys.put("layout/fragment_horizon_enter_date_to_0", com.sagoss.validationtesting.R.layout.fragment_horizon_enter_date_to);
      sKeys.put("layout/fragment_horizon_entry_time_0", com.sagoss.validationtesting.R.layout.fragment_horizon_entry_time);
      sKeys.put("layout/fragment_horizon_greetings_0", com.sagoss.validationtesting.R.layout.fragment_horizon_greetings);
      sKeys.put("layout/fragment_horizon_hotel_0", com.sagoss.validationtesting.R.layout.fragment_horizon_hotel);
      sKeys.put("layout/fragment_horizon_no_config_0", com.sagoss.validationtesting.R.layout.fragment_horizon_no_config);
      sKeys.put("layout/fragment_horizon_plate_registration_0", com.sagoss.validationtesting.R.layout.fragment_horizon_plate_registration);
      sKeys.put("layout/fragment_horizon_validation_results_0", com.sagoss.validationtesting.R.layout.fragment_horizon_validation_results);
      sKeys.put("layout/fragment_horizon_voucher_0", com.sagoss.validationtesting.R.layout.fragment_horizon_voucher);
      sKeys.put("layout/fragment_login_checker_0", com.sagoss.validationtesting.R.layout.fragment_login_checker);
      sKeys.put("layout/fragment_login_registration_0", com.sagoss.validationtesting.R.layout.fragment_login_registration);
      sKeys.put("layout/layout_date_to_fixed_hotel_item_0", com.sagoss.validationtesting.R.layout.layout_date_to_fixed_hotel_item);
      sKeys.put("layout/layout_vouchers_item_0", com.sagoss.validationtesting.R.layout.layout_vouchers_item);
    }
  }
}
