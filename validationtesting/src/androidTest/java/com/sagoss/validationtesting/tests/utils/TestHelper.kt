/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.tests.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.TypeTextAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.sagoss.validationtesting.R
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.runner.launchFragmentInHiltContainer
import com.sagoss.validationtesting.ui.recycleradapter.VoucherRecyclerAdapter
import com.sagoss.validationtesting.utils.Prefs

object TestHelper {

    fun getValidationFragmentArgs(voucher: Voucher, plate: String, dateTo: String, dateFrom: String): Bundle {
        val validationFragmentArg = Bundle()
        validationFragmentArg.putSerializable(Constants.VOUCHER_ARG, voucher)
        validationFragmentArg.putString(Constants.PLATE_ARG, plate)
        validationFragmentArg.putString(Constants.DATE_TO_ARG, dateTo)
        validationFragmentArg.putString(Constants.DATE_FROM_ARG, dateFrom)
        return validationFragmentArg
    }

    fun getDateToArgs(voucher: Voucher, plate: String): Bundle {
        val dateToArgs = Bundle()
        dateToArgs.putSerializable(Constants.VOUCHER_ARG, voucher)
        dateToArgs.putString(Constants.PLATE_ARG, plate)
        return dateToArgs
    }

    fun getHotelFragArgs(voucher: Voucher, plate: String): Bundle {
        val dateToArgs = Bundle()
        dateToArgs.putSerializable(Constants.VOUCHER_ARG, voucher)
        dateToArgs.putString(Constants.PLATE_ARG, plate)
        return dateToArgs
    }

    fun getPlateRegistrationArgs(voucher: Voucher): Bundle {
        val plateRegArgs = Bundle()
        plateRegArgs.putSerializable(Constants.VOUCHER_ARG, voucher)
        return plateRegArgs
    }



    /**
     * Generic function to run Greetings Fragments for All UI clients
     *
     * Performs basic function of clicking on greetings Textview
     */
    inline fun <reified T : Fragment> runGreetingsFrag(navController: NavController): Prefs? {
        var prefs: Prefs? = null
        launchFragmentInHiltContainer<T>(
            navHostController = navController
        ) {
            prefs = Prefs(this.requireContext())
            prefs!!.locationName = "Android Test Location"
        }
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.tv_welcome_msg)).perform(ViewActions.click())
        return prefs
    }

    /**
     * Generic Function to run Voucher Fragment for all UI clients
     *
     * Once vouchers list is open, Select Item from reccyler at x position
     */
    inline fun <reified T : Fragment> runVouchersListFragment(navController: NavController, pos: Int) {
        launchFragmentInHiltContainer<T>(navHostController = navController) {}
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.recycler_voucher)).perform(
            RecyclerViewActions.actionOnItemAtPosition<VoucherRecyclerAdapter.VoucherViewHolder>(
                pos,
                ViewActions.click()
            )
        )
    }


    /**
     * @param voucher Voucher selected from recycler if Voucher list fragment
     *
     * Generic function to run plate registration Fragment
     * Enter dummy number plate
     * click on validate button
     */
    inline fun <reified T : Fragment> runPlateRegFragment(
        voucher: Voucher,
        navController: NavController,
        plate: String) {
        val args = getPlateRegistrationArgs(voucher)
        launchFragmentInHiltContainer<T>(
            fragmentArgs = args,
            navHostController = navController
        ) {}
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.tv_plate_no))
            .perform(TypeTextAction(plate)).perform(ViewActions.closeSoftKeyboard())
        Thread.sleep(250)
        Espresso.onView(ViewMatchers.withId(R.id.btn_validate)).perform(ViewActions.click())
        Thread.sleep(1000)
    }



    /**
     * @param voucher Voucher as passed from plate reg fragment
     * @param plate plate number as passed from plate reg fragment
     *
     * Generic function to run Date To Fragment
     * once date to frag reached, Add date twice
     * Click confirm
     */
    inline fun <reified T : Fragment> runDateToFragment(navController: NavController, voucher: Voucher, plate:String){
        val dateToArgs = getDateToArgs(voucher, plate)
        launchFragmentInHiltContainer<T>(
            fragmentArgs = dateToArgs,
            navHostController = navController
        ) {  }
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.btn_add)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btn_add)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btnConfirm)).perform(ViewActions.click())
    }

    /**
     * @param voucher Voucher as passed from plate reg fragment
     * @param plate plate number as passed from plate reg fragment
     *
     * Generic function to run validation fragment
     * check if success message is shown
     * Click done once message appears
     */
    inline fun <reified T : Fragment> runValidation(navController: NavController, voucher: Voucher, plate:String, prefs: Prefs?) {
        val validationFragmentArg = getValidationFragmentArgs(
            voucher,
            plate,
            prefs?.chosenDate.toString(),
            prefs?.date_from.toString()
        )
        launchFragmentInHiltContainer<T>(
            fragmentArgs = validationFragmentArg,
            navHostController = navController
        ) {}
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.btn_done))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_done)).perform(ViewActions.click())
    }

    /**
     * @param voucher Voucher as passed from plate reg fragment
     * @param plate plate number as passed from plate reg fragment
     *
     * Generic function to run validation fragment
     * check if success message is shown
     * Click done once message appears
     */
    inline fun <reified T : Fragment> runHotelFragment(navController: NavController, voucher: Voucher, plate:String) {
        val hotelFragArgs = getHotelFragArgs(voucher, plate,)
        launchFragmentInHiltContainer<T>(
            fragmentArgs = hotelFragArgs,
            navHostController = navController
        ) {}
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.recycler)).perform(
            RecyclerViewActions.actionOnItemAtPosition<VoucherRecyclerAdapter.VoucherViewHolder>(
                0,
                ViewActions.click()
            )
        )
    }



}