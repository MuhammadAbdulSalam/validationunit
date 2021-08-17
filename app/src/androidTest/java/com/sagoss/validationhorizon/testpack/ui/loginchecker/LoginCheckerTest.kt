/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.testpack.ui.loginchecker

import android.util.Log
import androidx.navigation.NavController
import androidx.test.filters.MediumTest
import com.sagoss.validationhorizon.launchFragmentInHiltContainer
import com.sagoss.validationhorizon.ui.fragments.loginviews.LoginCheckerFragment
import com.sagoss.validationhorizon.ui.fragments.loginviews.LoginCheckerFragmentDirections
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.ThemeUtil
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class LoginCheckerTest {

    private val TAG = "REGISTRATION TEST"

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup(){
        hiltRule.inject()
    }

    @Test
    fun loginToRegistration(){
        var prefs: Prefs? = null
        val navController = Mockito.mock(NavController::class.java)

        launchFragmentInHiltContainer<LoginCheckerFragment>(
            navHostController = navController
        ){
            prefs = Prefs(requireContext())
        }

        Thread.sleep(2000);

        if(prefs!!.accessToken == "")
        {
            Log.d(TAG, "Entering Registration Fragment")
            Mockito.verify(navController).navigate(
            LoginCheckerFragmentDirections
                .actionLoginCheckerToFragmentRegistration())
        }
        else if(prefs!!.config) {
            Log.d(TAG, "Entering Greetings Fragment")
            Mockito.verify(navController).navigate(
                ThemeUtil.getInitialGreetingsDirection(prefs!!.companyId.toString()))
        }
        else if(!prefs!!.config)
        {
            Log.d(TAG, "Entering NO CONFIG Fragment")
            Mockito.verify(navController).navigate(
                ThemeUtil.getInitialNoConfigDirections(prefs!!.companyId.toString()))
        }
    }
}