/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.testpack.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.launchFragmentInHiltContainer
import com.sagoss.validationhorizon.testpack.utils.TestHelper
import com.sagoss.validationhorizon.ui.fragments.companyviews.horizon.*
import com.sagoss.validationhorizon.ui.recycleradapter.VoucherRecyclerAdapter
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.Prefs
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class GreetingsFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup(){
        hiltRule.inject()
    }


    @Test
    fun voucherOneJourney() {
        val navController = mock(NavController::class.java)
       launchFragmentInHiltContainer<GreetingsHorizonFragmentGreetings>(
           navHostController = navController
       ){}

        onView(withId(R.id.tv_welcome_msg)).perform(click())

        verify(navController).navigate(
            GreetingsHorizonFragmentGreetingsDirections
            .actionFragmentGreetingsHorizonToFragmentVouchersHorizon())



        launchFragmentInHiltContainer<VoucherFragmentHorizon>(
            navHostController = navController
        ){}

        Thread.sleep(2000)

        onView(withId(R.id.recycler_voucher)).perform(
            RecyclerViewActions.
            actionOnItemAtPosition<VoucherRecyclerAdapter.VoucherViewHolder>(
                0, click()
            )
        )

//        verify(navController).navigate(
//            VoucherFragmentHorizonDirections
//                .actionFragmentVouchersHorisonToFragmentPlateRegistrationHorizon(TestHelper.dateToVoucher()))

        Thread.sleep(2000)

        val args = Bundle()
        args.putSerializable("voucher", TestHelper.dateToVoucher())
        launchFragmentInHiltContainer<PlateRegistrationHorizonFragment>(
            fragmentArgs = args,
            navHostController = navController
        ){}

        Thread.sleep(2000)

        onView(withId(R.id.tv_plate_no)).perform(typeText("ABC123"))
        onView(withId(R.id.tv_plate_no)).perform(click())

//        verify(navController).navigate(
//            PlateRegistrationHorizonFragmentDirections
//                .actionFragmentPlateRegistrationHorizonToFragmentEnterDateToHorizon(TestHelper.dateToVoucher(), "ABC123"))


        val args2 = Bundle()
        args2.putSerializable("voucher", TestHelper.dateToVoucher())
        args2.putString("plate_number", "ABC123")
        launchFragmentInHiltContainer<EnterDateToHorizonFragment>(
            fragmentArgs = args2,
            navHostController = navController
        ){}
        Thread.sleep(2000)
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.btnConfirm)).perform(click())
        Thread.sleep(2000)


        val args3 = Bundle()
        args3.putSerializable("voucher", TestHelper.dateToVoucher())
        args3.putString("plate_number", "ABC123")
        args3.putString("date_to", "")
        args3.putString("date_from", HelperUtil.getCurrentDateTimeString("YYYY-MM-dd HH:mm:ss"))
        launchFragmentInHiltContainer<ValidationResultsHorizonFragment>(
            fragmentArgs = args3,
            navHostController = navController
        ){}
        Thread.sleep(2000)


        onView(withId(R.id.btn_done)).perform(click())
                verify(navController).navigate(
                    ValidationResultsHorizonFragmentDirections
                        .actionFragmentHorizonValidationToFragmentGreetingsHorizon())


    }
}