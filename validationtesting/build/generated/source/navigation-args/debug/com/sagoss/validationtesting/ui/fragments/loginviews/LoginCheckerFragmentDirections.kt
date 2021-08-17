package com.sagoss.validationtesting.ui.fragments.loginviews

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.sagoss.validationtesting.R

public class LoginCheckerFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginCheckerToFragmentRegistration(): NavDirections =
        ActionOnlyNavDirections(R.id.action_login_checker_to_fragment_registration)

    public fun actionFragmentLoginCheckerToFragmentGreetingsC2c(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_login_checker_to_fragment_greetings_c2c)

    public fun actionFragmentLoginCheckerToFragmentGreetingsGa(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_login_checker_to_fragment_greetings_ga)

    public fun actionFragmentLoginCheckerToFragmentNoConfigHorizon(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_login_checker_to_fragment_no_config_horizon)

    public fun actionFragmentLoginCheckerToFragmentGreetingsHorizon(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_login_checker_to_fragment_greetings_horizon)

    public fun actionFragmentLoginCheckerToFragmentNoConfigGa(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_login_checker_to_fragment_no_config_ga)

    public fun actionFragmentLoginCheckerToFragmentNoConfigC2c(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_login_checker_to_fragment_no_config_c2c)
  }
}
