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
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.TypeTextAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
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
import com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia.*
import com.sagoss.validationtesting.ui.fragments.companyviews.horizon.*
import com.sagoss.validationtesting.ui.recycleradapter.VoucherRecyclerAdapter
import com.sagoss.validationtesting.util.Constants
import com.sagoss.validationtesting.util.TestHelper
import com.sagoss.validationtesting.util.Vouchers
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
    lateinit var dbRepository: DBRepository

    private lateinit var testContext: Context
    var prefs: Prefs? = null

    private val NUMBER_PLATE = "ABC123"
    val navController: NavController = mock(NavController::class.java)

    @Before
    fun setup() {
        hiltRule.inject()
        testContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun updateDatabaseVouchers() {
        var success = true
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
            success = false
            e.printStackTrace()
        }
        assert(success)
    }

    @Test
    fun voucherOneHorizonTest() {

        var academyVoucher: Voucher?

        runBlocking { academyVoucher = dbRepository.getVoucher(Constants.ACADEMY_VOUCHER_NAME) }
        assert(academyVoucher != null)

        //Greetings Fragment
        runGreetingsFrag<GreetingsHorizonFragmentGreetings>()
        verify(navController).navigate(
            GreetingsHorizonFragmentGreetingsDirections
                .actionFragmentGreetingsHorizonToFragmentVouchersHorizon()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherFragmentHorizon>()
        verify(navController).navigate(
            VoucherFragmentHorizonDirections
                .actionFragmentVouchersHorisonToFragmentPlateRegistrationHorizon(academyVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationHorizonFragment>(academyVoucher!!)
        verify(navController).navigate(
            PlateRegistrationHorizonFragmentDirections
                .actionFragmentPlateRegistrationHorizonToFragmentEnterDateToHorizon(
                    voucher = academyVoucher!!, plateNumber = NUMBER_PLATE
                )
        )

        //Date To Fragment
        runDateToFragment<EnterDateToHorizonFragment>(academyVoucher!!, NUMBER_PLATE)
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
       runValidation<ValidationResultsHorizonFragment>(academyVoucher!!, NUMBER_PLATE)
        verify(navController).navigate(
            ValidationResultsHorizonFragmentDirections
                .actionFragmentHorizonValidationToFragmentGreetingsHorizon()
        )
    }

    @Test
    fun voucherOneC2cTest() {
        var academyVoucher: Voucher?

        runBlocking { academyVoucher = dbRepository.getVoucher(Constants.ACADEMY_VOUCHER_NAME) }
        assert(academyVoucher != null)

        //Greetings Fragment
        runGreetingsFrag<GreetingsC2cFragment>()
        verify(navController).navigate(
            GreetingsC2cFragmentDirections
                .actionFragmentGreetingsC2cToFragmentVouchersC2c()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherC2cFragment>()
        verify(navController).navigate(
            VoucherC2cFragmentDirections
                .actionFragmentVouchersC2cToFragmentPlateRegistrationC2c(academyVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationC2cFragment>(academyVoucher!!)
        verify(navController).navigate(
            PlateRegistrationC2cFragmentDirections
                .actionFragmentPlateRegistrationC2cToFragmentDateToC2c(
                    voucher = academyVoucher!!, plateNumber = NUMBER_PLATE
                )
        )

        //Date To Fragment
        runDateToFragment<EnterDateToC2cFragment>(academyVoucher!!, NUMBER_PLATE)
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
        runValidation<ValidationResultsC2cFragment>(academyVoucher!!, NUMBER_PLATE)
        verify(navController).navigate(
            ValidationResultsC2cFragmentDirections
                .actionFragmentValidationCompleteToFragmentGreetingsC2c()
        )
    }

    @Test
    fun voucherOneGaTest() {
        var academyVoucher: Voucher?

        runBlocking { academyVoucher = dbRepository.getVoucher(Constants.ACADEMY_VOUCHER_NAME) }
        assert(academyVoucher != null)

        //Greetings Fragment
        runGreetingsFrag<GreetingsGaFragment>()
        verify(navController).navigate(
            GreetingsGaFragmentDirections
                .actionFragmentGreetingsGaToFragmentVouchersGa()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherGaFragment>()
        verify(navController).navigate(
            VoucherGaFragmentDirections
                .actionFragmentVouchersGaToFragmentPlateRegistrationGa(academyVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationGaFragment>(academyVoucher!!)
        verify(navController).navigate(
            PlateRegistrationGaFragmentDirections
                .actionFragmentPlateRegistrationGaToFragmentDateToGa(
                    voucher = academyVoucher!!, plateNumber = NUMBER_PLATE
                )
        )

        //Date To Fragment
        runDateToFragment<EnterDateToGaFragment>(academyVoucher!!, NUMBER_PLATE)
        verify(navController).navigate(
            EnterDateToGaFragmentDirections
                .actionFragmentDateToGaToFragmentValidationGa(
                    dateFrom = prefs?.date_from.toString(),
                    dateTo = prefs?.chosenDate.toString(),
                    voucher = academyVoucher!!,
                    plateNumber = NUMBER_PLATE
                )
        )

        //Validate Plate Fragment
        runValidation<ValidationResultsGaFragment>(academyVoucher!!, NUMBER_PLATE)
        verify(navController).navigate(
            ValidationResultsGaFragmentDirections
                .actionFragmentValidationGaToFragmentGreetingsGa()
        )
    }


    private inline fun <reified T : Fragment> runGreetingsFrag() {
        launchFragmentInHiltContainer<T>(
            navHostController = navController
        ) {
            Prefs(this.requireContext()).locationName = "Android Test Location"
        }
        Thread.sleep(1000)
        onView(withId(R.id.tv_welcome_msg)).perform(click())

    }

    private inline fun <reified T : Fragment> runVouchersListFragment() {
        launchFragmentInHiltContainer<T>(navHostController = navController) {}
        Thread.sleep(1000)
        onView(withId(R.id.recycler_voucher)).perform(
            RecyclerViewActions.actionOnItemAtPosition<VoucherRecyclerAdapter.VoucherViewHolder>(
                Constants.ACADEMY_USER_POS,
                click()
            )
        )
    }

    private inline fun <reified T : Fragment> runPlateRegFragment(voucher: Voucher) {
        val args = TestHelper.getPlateRegistrationArgs(voucher)
        launchFragmentInHiltContainer<T>(
            fragmentArgs = args,
            navHostController = navController
        ) {}
        Thread.sleep(1000)
        onView(withId(R.id.tv_plate_no))
            .perform(TypeTextAction(NUMBER_PLATE)).perform(closeSoftKeyboard())
        Thread.sleep(250)
        onView(withId(R.id.btn_validate)).perform(click())
        Thread.sleep(2000)
    }

    private inline fun <reified T : Fragment> runDateToFragment(voucher: Voucher, plate:String) {
        val dateToArgs = TestHelper.getDateToArgs(voucher, plate)
        launchFragmentInHiltContainer<T>(
            fragmentArgs = dateToArgs,
            navHostController = navController
        ) { prefs = Prefs(this.requireContext()) }
        Thread.sleep(1000)
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.btnConfirm)).perform(click())
    }

    private inline fun <reified T : Fragment> runValidation(voucher: Voucher, plate:String) {
        val validationFragmentArg = TestHelper.getValidationFragmentArgs(
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
        onView(withId(R.id.btn_done)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_done)).perform(click())
    }




}