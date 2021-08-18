/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.dbconfigtest.ui

import android.content.Context
import android.os.Bundle
import androidx.navigation.NavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.TypeTextAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import androidx.test.platform.app.InstrumentationRegistry
import com.sagoss.validationtesting.R
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.database.repository.DBRepository
import com.sagoss.validationtesting.launchFragmentInHiltContainer
import com.sagoss.validationtesting.ui.fragments.companyviews.c2c.*
import com.sagoss.validationtesting.ui.fragments.companyviews.horizon.*
import com.sagoss.validationtesting.ui.recycleradapter.VoucherRecyclerAdapter
import com.sagoss.validationtesting.util.Constants
import com.sagoss.validationtesting.util.TestHelper
import com.sagoss.validationtesting.util.Vouchers
import com.sagoss.validationtesting.utils.HelperUtil
import com.sagoss.validationtesting.utils.Prefs
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class VoucherJourney {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @Inject
    lateinit var dbRepository           : DBRepository

    private lateinit var testContext    : Context

    private val NUMBER_PLATE            = "ABC123"

    @Before
    fun setup(){
        hiltRule.inject()
        testContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun updateDatabaseVouchers(){
        var success =  true
        try {
            runBlocking { dbRepository.deleteAllVouchers() }
            runBlocking {
                dbRepository.insertAllVouchers(listOf(
                    Vouchers.academyUserVoucher(),
                    Vouchers.contractorVoucher(),
                    Vouchers.staffVoucher(),
                    Vouchers.disabledVoucher()))
            }
        }
        catch (e: Exception)
        {
            success = false
            e.printStackTrace()
        }
        assert(success)
    }


    @Test
    fun voucherOneHorizonTest() {
        val navController = mock(NavController::class.java)
        var academyVoucher: Voucher?

        runBlocking { academyVoucher = dbRepository.getVoucher(Constants.ACADEMY_VOUCHER_NAME) }
        assert(academyVoucher!= null)

        //Greetings Fragment
        launchFragmentInHiltContainer<GreetingsHorizonFragmentGreetings>(
            navHostController = navController){
            Prefs(this.requireContext()).locationName = "Android Test Location"
        }
        Thread.sleep(1000)
        onView(withId(R.id.tv_welcome_msg)).perform(click())
        verify(navController).navigate(
            GreetingsHorizonFragmentGreetingsDirections
                .actionFragmentGreetingsHorizonToFragmentVouchersHorizon())


        //Voucher Fragment
        launchFragmentInHiltContainer<VoucherFragmentHorizon>(navHostController = navController){}
        Thread.sleep(1000)
        onView(withId(R.id.recycler_voucher)).perform(
            RecyclerViewActions.
            actionOnItemAtPosition<VoucherRecyclerAdapter.VoucherViewHolder>(Constants.ACADEMY_USER_POS, click()))
        verify(navController).navigate(
            VoucherFragmentHorizonDirections
                .actionFragmentVouchersHorisonToFragmentPlateRegistrationHorizon(academyVoucher!!))
        Thread.sleep(1000)


        //Plate Registration Fragment
        val args = TestHelper.getPlateRegistrationArgs(academyVoucher!!)
        launchFragmentInHiltContainer<PlateRegistrationHorizonFragment>(
            fragmentArgs = args,
            navHostController = navController
        ){}
        Thread.sleep(1000)
        onView(withId(R.id.tv_plate_no))
            .perform( TypeTextAction(NUMBER_PLATE)).perform(closeSoftKeyboard())
        Thread.sleep(250)
        onView(withId(R.id.btn_validate)).perform(click())
        Thread.sleep(1000)
        verify(navController).navigate(
            PlateRegistrationHorizonFragmentDirections
                .actionFragmentPlateRegistrationHorizonToFragmentEnterDateToHorizon(
                    voucher = academyVoucher!!, plateNumber = NUMBER_PLATE))


        //Date To Fragment
        var prefs: Prefs? = null
        val dateToArgs = TestHelper.getDateToArgs(academyVoucher!!, NUMBER_PLATE)
        launchFragmentInHiltContainer<EnterDateToHorizonFragment>(
            fragmentArgs = dateToArgs,
            navHostController = navController
        ){
            prefs = Prefs(this.requireContext())
        }
        Thread.sleep(1000)
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.btnConfirm)).perform(click())
        verify(navController).navigate(
            EnterDateToHorizonFragmentDirections
                .actionFragmentEnterDateToHorizonToFragmentHorizonValidation(
                    dateFrom = prefs?.date_from.toString(),
                    dateTo = prefs?.chosenDate.toString(),
                    voucher = academyVoucher!!,
                    plateNumber = NUMBER_PLATE
                )
        )

        //Validate Plate Fragment
        val validationFragmentArg = TestHelper.getValidationFragmentArgs(
            academyVoucher!!, NUMBER_PLATE,prefs?.chosenDate.toString(), prefs?.date_from.toString())
        launchFragmentInHiltContainer<ValidationResultsHorizonFragment>(
            fragmentArgs = validationFragmentArg,
            navHostController = navController
        ){}
        Thread.sleep(1000)
        onView(withId(R.id.btn_done)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_done)).perform(click())
        verify(navController).navigate(
            ValidationResultsHorizonFragmentDirections
                .actionFragmentHorizonValidationToFragmentGreetingsHorizon())
    }

    @Test
    fun voucherOneC2cTest() {
        val navController = mock(NavController::class.java)
        var academyVoucher: Voucher?

        runBlocking { academyVoucher = dbRepository.getVoucher(Constants.ACADEMY_VOUCHER_NAME) }
        assert(academyVoucher!= null)

        //Greetings Fragment
        launchFragmentInHiltContainer<GreetingsC2cFragment>(
            navHostController = navController){
            Prefs(this.requireContext()).locationName = "Android Test Location"
        }
        Thread.sleep(1000)
        onView(withId(R.id.tv_welcome_msg)).perform(click())
        verify(navController).navigate(
            GreetingsC2cFragmentDirections
                .actionFragmentGreetingsC2cToFragmentVouchersC2c())


        //Voucher Fragment
        launchFragmentInHiltContainer<VoucherC2cFragment>(navHostController = navController){}
        Thread.sleep(1000)
        onView(withId(R.id.recycler_voucher)).perform(
            RecyclerViewActions.
            actionOnItemAtPosition<VoucherRecyclerAdapter.VoucherViewHolder>(Constants.ACADEMY_USER_POS, click()))
        verify(navController).navigate(
            VoucherC2cFragmentDirections
                .actionFragmentVouchersC2cToFragmentPlateRegistrationC2c(academyVoucher!!))
        Thread.sleep(1000)


        //Plate Registration Fragment
        val args = TestHelper.getPlateRegistrationArgs(academyVoucher!!)
        launchFragmentInHiltContainer<PlateRegistrationC2cFragment>(
            fragmentArgs = args,
            navHostController = navController
        ){}
        Thread.sleep(1000)
        onView(withId(R.id.tv_plate_no))
            .perform( TypeTextAction(NUMBER_PLATE)).perform(closeSoftKeyboard())
        Thread.sleep(250)
        onView(withId(R.id.btn_validate)).perform(click())
        Thread.sleep(1000)
        verify(navController).navigate(
            PlateRegistrationC2cFragmentDirections
                .actionFragmentPlateRegistrationC2cToFragmentDateToC2c(
                    voucher = academyVoucher!!, plateNumber = NUMBER_PLATE))


        //Date To Fragment
        var prefs: Prefs? = null
        val dateToArgs = TestHelper.getDateToArgs(academyVoucher!!, NUMBER_PLATE)
        launchFragmentInHiltContainer<EnterDateToC2cFragment>(
            fragmentArgs = dateToArgs,
            navHostController = navController
        ){
            prefs = Prefs(this.requireContext())
        }
        Thread.sleep(1000)
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.btnConfirm)).perform(click())
        verify(navController).navigate(
            EnterDateToC2cFragmentDirections
                .actionFragmentDateToC2cToFragmentValidationComplete(
                    dateFrom = prefs?.date_from.toString(),
                    dateTo = prefs?.chosenDate.toString(),
                    voucher = academyVoucher!!,
                    plateNumber = NUMBER_PLATE
                )
        )

        //Validate Plate Fragment
        val validationFragmentArg = TestHelper.getValidationFragmentArgs(
            academyVoucher!!, NUMBER_PLATE,prefs?.chosenDate.toString(), prefs?.date_from.toString())
        launchFragmentInHiltContainer<ValidationResultsC2cFragment>(
            fragmentArgs = validationFragmentArg,
            navHostController = navController
        ){}
        Thread.sleep(1000)
        onView(withId(R.id.btn_done)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_done)).perform(click())
        verify(navController).navigate(
            ValidationResultsC2cFragmentDirections
                .actionFragmentValidationCompleteToFragmentGreetingsC2c())
    }


}