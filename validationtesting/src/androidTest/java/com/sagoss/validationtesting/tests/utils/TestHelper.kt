/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.tests.utils

import android.content.Context
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
import com.sagoss.validationtesting.database.repository.DBRepository
import com.sagoss.validationtesting.runner.launchFragmentInHiltContainer
import com.sagoss.validationtesting.ui.fragments.loginviews.LoginCheckerFragment
import com.sagoss.validationtesting.ui.fragments.loginviews.LoginCheckerFragmentDirections
import com.sagoss.validationtesting.ui.fragments.loginviews.LoginRegistrationFragment
import com.sagoss.validationtesting.ui.recycleradapter.VoucherRecyclerAdapter
import com.sagoss.validationtesting.utils.HelperUtil
import com.sagoss.validationtesting.utils.Prefs
import kotlinx.coroutines.runBlocking
import org.mockito.Mockito

object TestHelper {

    enum class Direction {
        DATE_TO, DATE_FROM, HOTEL, VALIDATE_DATE_TO, VALIDATE
    }

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

    fun updateDb(dbRepository: DBRepository): Boolean{
        try {
            runBlocking { dbRepository.deleteAllVouchers() }
            runBlocking {
                dbRepository.insertAllVouchers(
                    listOf(
                        Vouchers.academyUserVoucher(),
                        Vouchers.contractorVoucher(),
                        Vouchers.staffVoucher(),
                        Vouchers.disabledVoucher()
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
        return true
    }


    fun resetConfigRegistration(dbRepository: DBRepository, context:Context): Boolean{
        return try{
            runBlocking { dbRepository.deleteAllVouchers() }
            val prefs = Prefs(context)
            prefs.accessToken = ""
            prefs.companyId = "default"
            prefs.config = false
            assert(HelperUtil.isNetworkAvailable(context))
            true
        } catch (e: Exception){
            false
        }
    }



    /**
     * Generic function to run Fragments with 0 params for All UI clients
     */
    inline fun <reified T : Fragment> runFragment(navController: NavController): Context? {
        var context: Context? = null
        launchFragmentInHiltContainer<T>(
            navHostController = navController
        ) { context = this.requireContext() }
        return context
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
    inline fun <reified T : Fragment> runPlateRegFragment(voucher: Voucher, navController: NavController, plate: String) : Context? {

        val args = getPlateRegistrationArgs(voucher)
        var context: Context? = null

        launchFragmentInHiltContainer<T>(
            fragmentArgs = args, navHostController = navController
        ) { context = this.requireContext() }

        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.tv_plate_no))
            .perform(TypeTextAction(plate)).perform(ViewActions.closeSoftKeyboard())
        Thread.sleep(250)
        Espresso.onView(ViewMatchers.withId(R.id.btn_validate)).perform(ViewActions.click())
        Thread.sleep(2000)

        return context
    }



    /**
     * @param voucher Voucher as passed from plate reg fragment
     * @param plate plate number as passed from plate reg fragment
     *
     * Generic function to run Date To Fragment
     * once date to frag reached, Add date twice
     * Click confirm
     */
    inline fun <reified T : Fragment> runDateToFragment(navController: NavController, voucher: Voucher, plate:String) : Context? {
        var context = null as Context?
        val dateToArgs = getDateToArgs(voucher, plate)
        launchFragmentInHiltContainer<T>(
            fragmentArgs = dateToArgs, navHostController = navController
        ) {context = this.requireContext() }
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.btn_add)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btn_add)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btnConfirm)).perform(ViewActions.click())

        return context
    }

    /**
     * @param voucher Voucher as passed from plate reg fragment
     * @param plate plate number as passed from plate reg fragment
     *
     * Generic function to run validation fragment
     * check if success message is shown
     * Click done once message appears
     */
    inline fun <reified T : Fragment> runValidation(navController: NavController, voucher: Voucher, plate:String, prefs: Prefs?): Context? {
        var context = null as Context?
        val validationFragmentArg = getValidationFragmentArgs(
            voucher,
            plate,
            prefs?.chosenDate.toString(),
            prefs?.date_from.toString()
        )
        launchFragmentInHiltContainer<T>(
            fragmentArgs = validationFragmentArg,
            navHostController = navController
        ) {context = this.requireContext()}
        Thread.sleep(3000)
        Espresso.onView(ViewMatchers.withId(R.id.btn_done))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_done)).perform(ViewActions.click())
        return context
    }

    /**
     * @param voucher Voucher as passed from plate reg fragment
     * @param plate plate number as passed from plate reg fragment
     *
     * Generic function to run Hotel fragment
     * check if success message is shown
     * Click done once message appears
     */
    inline fun <reified T : Fragment> runHotelFragment(navController: NavController, voucher: Voucher, plate:String): Context? {
        val hotelFragArgs = getHotelFragArgs(voucher, plate,)
        var context = null as Context?

        launchFragmentInHiltContainer<T>(
            fragmentArgs = hotelFragArgs,
            navHostController = navController
        ) {context = this.requireContext()}
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.recycler)).perform(
            RecyclerViewActions.actionOnItemAtPosition<VoucherRecyclerAdapter.VoucherViewHolder>(
                0,
                ViewActions.click()
            )
        )
        return context
    }

    /**
     * @param voucher Voucher as passed
     * @param plate plate number as passed
     *
     * Generic function to run DateFrom/EntryTime fragment
     * check if success message is shown
     * Click done once message appears
     */
    inline fun <reified T : Fragment> runDateFrom(navController: NavController, voucher: Voucher, plate:String) {
        val hotelFragArgs = getDateToArgs(voucher, plate,)
        launchFragmentInHiltContainer<T>(
            fragmentArgs = hotelFragArgs,
            navHostController = navController
        ) {}
        Espresso.onView(ViewMatchers.withId(R.id.btn_validate)).perform(ViewActions.click())
    }


    /**
     * @param username username for registration
     * @param password password for registration
     *
     * Once registration is success Move back to login checker
     * Test if no config or Greetings Screen directions work fine
     */
    fun registrationTest(username: String, password: String, navController: NavController) {
        val requireContext = runFragment<LoginCheckerFragment>(navController = navController)
        Thread.sleep(1000)

        val prefs = Prefs(requireContext!!)
        Mockito.verify(navController).navigate(
            LoginCheckerFragmentDirections.actionLoginCheckerToFragmentRegistration()
        )

        prefs.accessToken = ""
        prefs.companyId = "default"
        prefs.config = false

        runFragment<LoginRegistrationFragment>(navController = navController)
        Espresso.onView(ViewMatchers.withId(R.id.registrationUsernameEditText))
            .perform(TypeTextAction(username))
            .perform(ViewActions.closeSoftKeyboard())
        Thread.sleep(250)

        Espresso.onView(ViewMatchers.withId(R.id.registrationPasswordEditText))
            .perform(TypeTextAction(password))
            .perform(ViewActions.closeSoftKeyboard())
        Thread.sleep(250)

        Espresso.onView(ViewMatchers.withId(R.id.registerButton)).perform(ViewActions.click())
        Thread.sleep(2000)
        val registered = prefs?.accessToken.toString().isNotEmpty()

        assert(registered)
    }



    /**
     * Check if dates needs to be entered manually
     * Navigate according to date_to and date_from requirements
     */
    fun voucherDirection(voucher: Voucher): Direction {
        if (voucher.dateTo) {
            if (!voucher.dateToFixed.isNullOrEmpty()) {
                if (voucher.dateToFixed!!.size > 1) {
                    return Direction.HOTEL
                } else if (voucher.dateToFixed!!.size == 1) {
                    return Direction.VALIDATE_DATE_TO
                }
            } else if (!voucher.dateToUnit.isNullOrEmpty()) {
                return Direction.DATE_TO
            }
        } else {
            return Direction.VALIDATE
        }
        return Direction.DATE_FROM
    }


}