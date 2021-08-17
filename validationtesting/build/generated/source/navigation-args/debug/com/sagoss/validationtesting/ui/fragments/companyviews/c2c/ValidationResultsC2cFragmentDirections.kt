package com.sagoss.validationtesting.ui.fragments.companyviews.c2c

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.sagoss.validationtesting.R

public class ValidationResultsC2cFragmentDirections private constructor() {
  public companion object {
    public fun actionFragmentValidationCompleteToFragmentNoConfigC2c(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_validation_complete_to_fragment_no_config_c2c)
  }
}
