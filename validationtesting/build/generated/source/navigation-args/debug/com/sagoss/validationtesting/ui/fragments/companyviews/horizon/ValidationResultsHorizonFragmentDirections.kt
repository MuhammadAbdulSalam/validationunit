package com.sagoss.validationtesting.ui.fragments.companyviews.horizon

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.sagoss.validationtesting.R

public class ValidationResultsHorizonFragmentDirections private constructor() {
  public companion object {
    public fun actionFragmentHorizonValidationToFragmentGreetingsHorizon(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_horizon_validation_to_fragment_greetings_horizon)
  }
}
