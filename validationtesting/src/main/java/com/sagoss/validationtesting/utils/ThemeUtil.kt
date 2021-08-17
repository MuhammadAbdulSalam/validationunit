/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.utils

import androidx.navigation.NavDirections
import com.sagoss.validationtesting.R
import com.sagoss.validationtesting.ui.fragments.loginviews.LoginCheckerFragmentDirections

object ThemeUtil {

    /**
     * @param companyID company ID as recieved and stored
     *
     * Direction of app to be set according to company ID
     * Once No config fragment is reached rest of directions
     * will be selected from main_nav.xml directions accordingly
     *
     * @return initial no config fragment direction
     */
    fun getInitialNoConfigDirections(companyID: String): NavDirections {
        return when (companyID) {
            Constants.COMPANY_GREATER_ANGLIA -> LoginCheckerFragmentDirections
                .actionFragmentLoginCheckerToFragmentNoConfigGa()
            Constants.COMPANY_C2C -> LoginCheckerFragmentDirections
                .actionFragmentLoginCheckerToFragmentNoConfigHorizon()
            else -> LoginCheckerFragmentDirections
                .actionFragmentLoginCheckerToFragmentNoConfigHorizon()

        }
    }

    /**
     * @param companyID company ID as recieved and stored
     *
     * Direction of app to be set according to company ID
     * Once Greetings fragment is reached rest of directions
     * will be selected from main_nav.xml directions accordingly
     *
     * @return initial greetings fragment direction
     */
    fun getInitialGreetingsDirection(companyID: String): NavDirections {
        return when (companyID) {
            Constants.COMPANY_GREATER_ANGLIA -> LoginCheckerFragmentDirections
                .actionFragmentLoginCheckerToFragmentGreetingsGa()
            Constants.COMPANY_C2C -> LoginCheckerFragmentDirections
                .actionFragmentLoginCheckerToFragmentGreetingsC2c()
            else -> LoginCheckerFragmentDirections
                .actionFragmentLoginCheckerToFragmentGreetingsHorizon()

        }
    }

    /**
     * @param companyID company ID as received and stored
     *
     * @return Default theme color for app
     */
    fun getDefaultThemeColor(companyID: String): Int {
        return when (companyID) {
            Constants.COMPANY_GREATER_ANGLIA -> R.color.ga_primary
            Constants.COMPANY_C2C -> R.color.c2c_primary
            else -> R.color.horizon_primary
        }
    }

    /**
     * @param companyID as stored or received in response
     *
     * @return if regiestered return company logo else sagoss logo
     */
    fun getAppIcon(companyID: String): Int{
        return when (companyID) {
            Constants.COMPANY_GREATER_ANGLIA -> R.drawable.ga_logo
            Constants.COMPANY_C2C -> R.drawable.c2c_logo
            Constants.COMPANY_HORIZON -> R.drawable.horizon_logo
            else -> R.drawable.sagoss_logo
        }
    }
}