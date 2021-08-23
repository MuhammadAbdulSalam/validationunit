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
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.TypeTextAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.sagoss.validationtesting.R
import com.sagoss.validationtesting.database.repository.DBRepository
import com.sagoss.validationtesting.tests.utils.Constants.C2C_PASSWORD
import com.sagoss.validationtesting.tests.utils.Constants.C2C_USERNAME
import com.sagoss.validationtesting.tests.utils.Constants.GA_PASSWORD
import com.sagoss.validationtesting.tests.utils.Constants.GA_USERNAME
import com.sagoss.validationtesting.tests.utils.Constants.HORIZON_PASSWORD
import com.sagoss.validationtesting.tests.utils.Constants.HORIZON_USERNAME
import com.sagoss.validationtesting.tests.utils.TestHelper.runFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.runGreetingsFrag
import com.sagoss.validationtesting.ui.fragments.companyviews.c2c.GreetingsC2cFragment
import com.sagoss.validationtesting.ui.fragments.companyviews.c2c.NoConfigC2cFragment
import com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia.GreetingsGaFragment
import com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia.NoConfigGaFragment
import com.sagoss.validationtesting.ui.fragments.companyviews.horizon.GreetingsHorizonFragmentGreetings
import com.sagoss.validationtesting.ui.fragments.loginviews.LoginCheckerFragment
import com.sagoss.validationtesting.ui.fragments.loginviews.LoginCheckerFragmentDirections
import com.sagoss.validationtesting.ui.fragments.loginviews.LoginRegistrationFragment
import com.sagoss.validationtesting.utils.HelperUtil
import com.sagoss.validationtesting.utils.Prefs
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters
import org.mockito.Mockito
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class RegistrationJourney {

    @Inject lateinit var dbRepository       : DBRepository
    @get:Rule var hiltRule                  = HiltAndroidRule(this)
    private var prefs                       = null as Prefs?
    private val navController               = Mockito.mock(NavController::class.java)
    private var requireContext              = null as Context?
    private var networkConnected            = false

    /**
     * setup hilt rule inject
     */
    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun a_resetRegistrationData(){
        requireContext = runFragment<LoginCheckerFragment>(navController = navController)
        prefs = Prefs(requireContext!!)
        prefs?.accessToken = ""
        prefs?.companyId= "default"
        prefs?.config = false
        Thread.sleep(1000)
        networkConnected = HelperUtil.isNetworkAvailable(requireContext!!)
        assert(networkConnected)
    }

    /**
     *
     */
    @Test
    fun registrationHorizonTest() {
        assert(networkConnected)

        registrationTest(HORIZON_USERNAME, HORIZON_PASSWORD)
        runFragment<LoginCheckerFragment>(navController = navController)
        Thread.sleep(1000)
        if(!prefs?.config!!)
        {
            Thread.sleep(1000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections
                    .actionFragmentLoginCheckerToFragmentNoConfigHorizon())
        }
        else
        {
            Thread.sleep(1000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections
                    .actionFragmentLoginCheckerToFragmentGreetingsHorizon())
            runGreetingsFrag<GreetingsHorizonFragmentGreetings>(navController = navController)
            Thread.sleep(2000)
        }

        prefs?.accessToken = ""
        prefs?.companyId= "default"
        prefs?.config = false

    }

    @Test
    fun registrationC2CTest() {
        assert(networkConnected)

        registrationTest(C2C_USERNAME,C2C_PASSWORD)
        runFragment<LoginCheckerFragment>(navController = navController)
        Thread.sleep(1000)
        if(!prefs?.config!!)
        {
            Thread.sleep(1000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections
                    .actionFragmentLoginCheckerToFragmentNoConfigC2c())
            runFragment<NoConfigC2cFragment>(navController = navController)
            Thread.sleep(1000)
        }
        else
        {
            Thread.sleep(1000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections
                    .actionFragmentLoginCheckerToFragmentGreetingsC2c())
            runGreetingsFrag<GreetingsC2cFragment>(navController = navController)
            Thread.sleep(2000)
        }
        prefs?.accessToken = ""
        prefs?.companyId= "default"
        prefs?.config = false
    }

    @Test
    fun registrationGaTest() {
        assert(networkConnected)

        registrationTest(GA_USERNAME, GA_PASSWORD )
        runFragment<LoginCheckerFragment>(navController = navController)
        Thread.sleep(1000)
        if(!prefs?.config!!)
        {
            Thread.sleep(2000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections
                    .actionFragmentLoginCheckerToFragmentNoConfigGa())
            runFragment<NoConfigGaFragment>(navController = navController)
            Thread.sleep(2000)
        }
        else
        {
            Thread.sleep(2000)
            Mockito.verify(navController).navigate(
                LoginCheckerFragmentDirections
                    .actionFragmentLoginCheckerToFragmentGreetingsGa())
            runGreetingsFrag<GreetingsGaFragment>(navController = navController)
            Thread.sleep(2000)
        }

        prefs?.accessToken = ""
        prefs?.companyId= "default"
        prefs?.config = false
    }

    private fun registrationTest(username: String, password: String) {
        requireContext = runFragment<LoginCheckerFragment>(navController = navController)
        Thread.sleep(1000)

        prefs = Prefs(requireContext!!)
        Mockito.verify(navController).navigate(
            LoginCheckerFragmentDirections
                .actionLoginCheckerToFragmentRegistration()
        )

        prefs?.accessToken = ""
        prefs?.companyId= "default"
        prefs?.config = false

        runFragment<LoginRegistrationFragment>(navController = navController)
        onView(withId(R.id.registrationUsernameEditText))
            .perform(TypeTextAction(username))
            .perform(closeSoftKeyboard())
        Thread.sleep(250)

        onView(withId(R.id.registrationPasswordEditText))
            .perform(TypeTextAction(password))
            .perform(closeSoftKeyboard())
        Thread.sleep(250)

        onView(withId(R.id.registerButton)).perform(click())
        Thread.sleep(4000)
        val registered = prefs?.accessToken.toString().isNotEmpty()

        assert(registered)
    }

}