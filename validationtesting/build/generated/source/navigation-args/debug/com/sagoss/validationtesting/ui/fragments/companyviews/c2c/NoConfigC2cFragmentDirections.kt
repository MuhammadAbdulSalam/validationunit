package com.sagoss.validationtesting.ui.fragments.companyviews.c2c

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.sagoss.validationtesting.R

public class NoConfigC2cFragmentDirections private constructor() {
  public companion object {
    public fun actionFragmentNoConfigC2cToFragmentGreetingsC2c(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_no_config_c2c_to_fragment_greetings_c2c)
  }
}
