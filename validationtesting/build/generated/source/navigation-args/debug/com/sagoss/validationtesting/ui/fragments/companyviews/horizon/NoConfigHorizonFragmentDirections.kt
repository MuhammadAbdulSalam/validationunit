package com.sagoss.validationtesting.ui.fragments.companyviews.horizon

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.sagoss.validationtesting.R

public class NoConfigHorizonFragmentDirections private constructor() {
  public companion object {
    public fun actionFragmentNoConfigHorizonToFragmentGreetingsHorizon(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_no_config_horizon_to_fragment_greetings_horizon)
  }
}
