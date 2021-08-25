/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.tests.ui.apiconfig.registrationlogin

import android.content.Context
import androidx.navigation.NavController
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.MediumTest
import com.sagoss.validationtesting.tests.utils.Constants.C2C_PASSWORD
import com.sagoss.validationtesting.tests.utils.Constants.C2C_USERNAME
import com.sagoss.validationtesting.tests.utils.Constants.GA_PASSWORD
import com.sagoss.validationtesting.tests.utils.Constants.GA_USERNAME
import com.sagoss.validationtesting.tests.utils.Constants.HORIZON_PASSWORD
import com.sagoss.validationtesting.tests.utils.Constants.HORIZON_USERNAME
import com.sagoss.validationtesting.tests.utils.TestHelper.registrationTest
import com.sagoss.validationtesting.tests.utils.TestHelper.runFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.runGreetingsFrag
import com.sagoss.validationtesting.ui.fragments.companyviews.c2c.GreetingsC2cFragment
import com.sagoss.validationtesting.ui.fragments.companyviews.c2c.NoConfigC2cFragment
import com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia.GreetingsGaFragment
import com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia.NoConfigGaFragment
import com.sagoss.validationtesting.ui.fragments.companyviews.horizon.GreetingsHorizonFragmentGreetings
import com.sagoss.validationtesting.ui.fragments.loginviews.LoginCheckerFragment
import com.sagoss.validationtesting.ui.fragments.loginviews.LoginCheckerFragmentDirections
import com.sagoss.validationtesting.utils.HelperUtil
import com.sagoss.validationtesting.utils.Prefs
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters
import org.mockito.Mockito

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class RegistrationJourney {

    @get:Rule var hiltRule                  = HiltAndroidRule(this)
    private var prefs                       = null as Prefs?
    private val navController               = Mockito.mock(NavController::class.java)
    private var networkConnected            = false
    private val requireContext              = ApplicationProvider
                                                .getApplicationContext<HiltTestApplication>()
    /**
     * setup hilt rule inject
     */
    @Before
    fun setup() {
        hiltRule.inject()
    }

    /**
     * Clear data from preferences to delete previous registration
     *
     * check if networks is connected
     */
    @Test
    fun a_resetRegistrationData(){
        prefs = Prefs(requireContext!!)
        prefs?.accessToken = ""
        prefs?.companyId= "default"
        prefs?.config = false
        Thread.sleep(1000)
        networkConnected = HelperUtil.isNetworkAvailable(requireContext!!)
        assert(networkConnected)
    }

    /**
     * Start Login checker and enter Horizon username password
     *
     * Once registration is success Move back to login checker
     * Test if no config or Greetings Screen directions work fine
     */
    @Test
    fun registrationHorizonTest() {

        registrationTest(HORIZON_USERNAME, HORIZON_PASSWORD, navController)
        runFragment<LoginCheckerFragment>(navController = navController)
        prefs = Prefs(requireContext!!)
        Thread.sleep(1000)
        if(!prefs?.config!!)
        {
            Thread.sleep(1000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections.actionFragmentLoginCheckerToFragmentNoConfigHorizon()
            )
        }
        else
        {
            Thread.sleep(1000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections.actionFragmentLoginCheckerToFragmentGreetingsHorizon()
            )
            runGreetingsFrag<GreetingsHorizonFragmentGreetings>(navController = navController)
            Thread.sleep(500)
        }

        prefs?.accessToken = ""
        prefs?.companyId= "default"
        prefs?.config = false

    }

    /**
     * Start Login checker and enter C2c username password
     *
     * Once registration is success Move back to login checker
     * Test if no config or Greetings Screen directions work fine
     */
    @Test
    fun registrationC2CTest() {

        registrationTest(C2C_USERNAME,C2C_PASSWORD, navController)
        runFragment<LoginCheckerFragment>(navController = navController)
        prefs = Prefs(requireContext!!)
        Thread.sleep(1000)
        if(!prefs?.config!!)
        {
            Thread.sleep(1000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections.actionFragmentLoginCheckerToFragmentNoConfigC2c()
            )
            runFragment<NoConfigC2cFragment>(navController = navController)
            Thread.sleep(1000)
        }
        else
        {
            Thread.sleep(1000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections.actionFragmentLoginCheckerToFragmentGreetingsC2c()
            )
            runGreetingsFrag<GreetingsC2cFragment>(navController = navController)
            Thread.sleep(500)
        }
        prefs?.accessToken = ""
        prefs?.companyId= "default"
        prefs?.config = false
    }

    /**
     * Start Login checker and enter Ga username password
     *
     * Once registration is success Move back to login checker
     * Test if no config or Greetings Screen directions work fine
     */
    @Test
    fun registrationGaTest() {

        registrationTest(GA_USERNAME, GA_PASSWORD, navController )
        runFragment<LoginCheckerFragment>(navController = navController)
        prefs = Prefs(requireContext!!)
        Thread.sleep(1000)
        if(!prefs?.config!!)
        {
            Thread.sleep(1000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections.actionFragmentLoginCheckerToFragmentNoConfigGa()
            )
            runFragment<NoConfigGaFragment>(navController = navController)
            Thread.sleep(2000)
        }
        else
        {
            Thread.sleep(1000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections.actionFragmentLoginCheckerToFragmentGreetingsGa()
            )
            runGreetingsFrag<GreetingsGaFragment>(navController = navController)
            Thread.sleep(500)
        }

        prefs?.accessToken = ""
        prefs?.companyId= "default"
        prefs?.config = false
    }

}