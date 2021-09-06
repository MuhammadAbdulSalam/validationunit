/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.tests.ui.apiconfig.vouchers

import androidx.navigation.NavController
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.MediumTest
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.database.repository.DBRepository
import com.sagoss.validationtesting.tests.utils.Constants
import com.sagoss.validationtesting.tests.utils.TestHelper
import com.sagoss.validationtesting.tests.utils.TestHelper.runDateFrom
import com.sagoss.validationtesting.tests.utils.TestHelper.runDateToFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.runHotelFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.runPlateRegFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.runVouchersListFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.voucherDirection
import com.sagoss.validationtesting.ui.fragments.companyviews.c2c.*
import com.sagoss.validationtesting.ui.fragments.companyviews.horizon.*
import com.sagoss.validationtesting.ui.fragments.loginviews.LoginCheckerFragment
import com.sagoss.validationtesting.ui.fragments.loginviews.LoginCheckerFragmentDirections
import com.sagoss.validationtesting.utils.Prefs
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters
import org.mockito.Mockito
import org.mockito.Mockito.verify
import javax.inject.Inject


/**
 * -------------------IMPORTANT------------------
 *
 * To Run these tests successfully, Device must
 * have a config on Blink
 * These tests are to test if blink config
 * journey works correctly.
 *
 * ---------------------------------------------
 */
@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserJourneyHorizon {

    @Inject
    lateinit var dbRepository                   : DBRepository
    @get:Rule var hiltRule                      = HiltAndroidRule(this)
    private val navController                   = Mockito.mock(NavController::class.java)
    private var selectedVoucher                 = null as Voucher?
    private val numberPlate                     = "ABC123"
    private val requireContext                  = ApplicationProvider
                                                .getApplicationContext<HiltTestApplication>()

    /**
     * setup hilt rule inject
     */
    @Before
    fun setup() {
        hiltRule.inject()
    }

    /**
     * Delete previous registration
     * check internet connection
     */
    @Test
    fun a_resetDeviceRegistration() {
        assert(TestHelper.resetConfigRegistration(dbRepository, requireContext))
    }

    /**
     * Register Device with username and password
     */
    @Test
    fun b_registerDeviceC2c() {

        TestHelper.registrationTest(
            username = Constants.HORIZON_USERNAME,
            password = Constants.HORIZON_PASSWORD,
            navController = navController
        )
        TestHelper.runFragment<LoginCheckerFragment>(navController = navController)
        val prefs = Prefs(requireContext!!)
        Thread.sleep(2000)
        if (!prefs.config) {
            verify(navController).navigate(
                LoginCheckerFragmentDirections.actionFragmentLoginCheckerToFragmentNoConfigHorizon()
            )
            TestHelper.runFragment<NoConfigC2cFragment>(navController = navController)
        } else {
            verify(navController).navigate(
                LoginCheckerFragmentDirections.actionFragmentLoginCheckerToFragmentGreetingsHorizon()
            )
        }
    }

    /**
     * Enter Greetings fragment
     * click on greetings message to check direction
     */
    @Test
    fun c_greetingsFragmentC2c() {

        val voucherCount = runBlocking { dbRepository.getVoucherCount() }
        TestHelper.runGreetingsFrag<GreetingsHorizonFragmentGreetings>(navController = navController)
        if (voucherCount == 1) {
            selectedVoucher = runBlocking { dbRepository.getAllVoucher()[0] }
            verify(navController).navigate(
                GreetingsHorizonFragmentGreetingsDirections
                    .actionFragmentGreetingsHorizonToFragmentPlateRegistrationHorizon(
                        selectedVoucher!!
                    )
            )
        } else {
            verify(navController).navigate(
                GreetingsHorizonFragmentGreetingsDirections
                    .actionFragmentGreetingsHorizonToFragmentVouchersHorizon()
            )
        }
    }

    /**
     * Enter voucher fragment
     * if number of vouchers is 1 just move to plate reg
     */
    @Test
    fun d_voucherFragmentC2c() {
        val voucherCount = runBlocking { dbRepository.getVoucherCount() }
        selectedVoucher = runBlocking { dbRepository.getAllVoucher()[0] }
        if (voucherCount > 1) {
            //Voucher Fragment
            runVouchersListFragment<VoucherFragmentHorizon>(
                navController,
                0
            )
            verify(navController).navigate(
                VoucherFragmentHorizonDirections
                    .actionFragmentVouchersHorisonToFragmentPlateRegistrationHorizon(selectedVoucher!!)
            )
        }
    }

    /**
     * Enter Plate Registration Fragment
     * enter plate and click validate
     * Follow directions according to voucher settings
     */
    @Test
    fun e_plateRegistration() {
        selectedVoucher = runBlocking { dbRepository.getAllVoucher()[0] }
        runPlateRegFragment<PlateRegistrationHorizonFragment>(
            voucher = selectedVoucher!!,
            navController = navController,
            plate = numberPlate
        )
        if ((selectedVoucher!!.dateFrom)) {
            verify(navController).navigate(
                PlateRegistrationHorizonFragmentDirections
                    .actionFragmentPlateRegistrationHorizonToFragmentEntryTimeHorizon(
                        selectedVoucher!!,
                        numberPlate
                    )
            )
        } else {
            val prefs = Prefs(requireContext!!)
            when (voucherDirection(selectedVoucher!!)) {
                TestHelper.Direction.VALIDATE_DATE_TO -> {
                    verify(navController).navigate(
                        PlateRegistrationHorizonFragmentDirections
                            .actionFragmentPlateRegistrationHorizonToFragmentHorizonValidation(
                                voucher = selectedVoucher!!,
                                plateNumber = numberPlate,
                                dateFrom = prefs.date_from.toString(),
                                dateTo = prefs.chosenDate.toString()
                            )
                    )
                }
                TestHelper.Direction.DATE_TO -> {
                    verify(navController).navigate(
                        PlateRegistrationHorizonFragmentDirections
                            .actionFragmentPlateRegistrationHorizonToFragmentEnterDateToHorizon(
                                selectedVoucher!!,
                                numberPlate
                            )
                    )
                }
                TestHelper.Direction.DATE_FROM -> { }
                TestHelper.Direction.HOTEL -> {
                    verify(navController).navigate(
                        PlateRegistrationHorizonFragmentDirections
                            .actionFragmentPlateRegistrationHorizonToFragmentHorizonHotel(
                                selectedVoucher!!,
                                numberPlate
                            )
                    )
                }
                TestHelper.Direction.VALIDATE -> {
                    verify(navController).navigate(
                        PlateRegistrationHorizonFragmentDirections
                            .actionFragmentPlateRegistrationHorizonToFragmentHorizonValidation(
                                voucher = selectedVoucher!!,
                                plateNumber = numberPlate,
                                dateFrom = prefs.date_from.toString(),
                                dateTo = ""
                            )
                    )
                }
            }
        }
    }

    /**
     * Enter Date From fragment
     * Only enter fragment if needed by voucher config
     */
    @Test
    fun f_dateFromFragmentC2C() {
        selectedVoucher = runBlocking { dbRepository.getAllVoucher()[0] }
        if (selectedVoucher!!.dateFrom) {
            runDateFrom<EntryTimeHorizonFragment>(
                voucher = selectedVoucher!!,
                navController = navController,
                plate = numberPlate
            )
            val prefs = Prefs(requireContext!!)
            when (voucherDirection(selectedVoucher!!)) {
                TestHelper.Direction.VALIDATE_DATE_TO -> {
                    verify(navController).navigate(
                        EntryTimeHorizonFragmentDirections
                            .actionFragmentEntryTimeHorizonToFragmentHorizonValidation(
                                voucher = selectedVoucher!!,
                                plateNumber = numberPlate,
                                dateFrom = prefs.date_from.toString(),
                                dateTo = prefs.chosenDate.toString()
                            )
                    )
                }
                TestHelper.Direction.DATE_TO -> {
                    verify(navController).navigate(
                        EntryTimeHorizonFragmentDirections
                            .actionFragmentEntryTimeHorizonToFragmentEnterDateToHorizon(
                                selectedVoucher!!,
                                numberPlate
                            )
                    )
                }
                TestHelper.Direction.DATE_FROM -> { }
                TestHelper.Direction.HOTEL -> {
                    verify(navController).navigate(
                        EntryTimeHorizonFragmentDirections
                            .actionFragmentEntryTimeHorizonToFragmentHorizonHotel(
                                selectedVoucher!!,
                                numberPlate
                            )
                    )
                }
                TestHelper.Direction.VALIDATE -> {
                    verify(navController).navigate(
                        EntryTimeHorizonFragmentDirections
                            .actionFragmentEntryTimeHorizonToFragmentHorizonValidation(
                                voucher = selectedVoucher!!,
                                plateNumber = numberPlate,
                                dateFrom = prefs.date_from.toString(),
                                dateTo = ""
                            )
                    )
                }
            }
        }
    }

    /**
     * Enter Date To fragment
     * Only enter fragment if needed by voucher config
     */
    @Test
    fun g_dateToFragmentC2C() {
        selectedVoucher = runBlocking { dbRepository.getAllVoucher()[0] }
        if (voucherDirection(selectedVoucher!!) == TestHelper.Direction.DATE_TO) {
            runDateToFragment<EnterDateToHorizonFragment>(
                navController, selectedVoucher!!, numberPlate
            )
            val prefs = Prefs(requireContext!!)
            verify(navController).navigate(
                EnterDateToHorizonFragmentDirections
                    .actionFragmentEnterDateToHorizonToFragmentHorizonValidation(
                        dateFrom = prefs.date_from.toString(),
                        dateTo = prefs.chosenDate.toString(),
                        voucher = selectedVoucher!!,
                        plateNumber = numberPlate
                    )
            )
        }
    }

    /**
     * Enter Hotel fragment
     * Only enter fragment if needed by voucher config
     */
    @Test
    fun h_hotelFragmentC2c() {
        selectedVoucher = runBlocking { dbRepository.getAllVoucher()[0] }
        if (voucherDirection(selectedVoucher!!) == TestHelper.Direction.HOTEL) {
           runHotelFragment<HotelHorizonFragment>(
                navController, selectedVoucher!!, numberPlate
            )
            val prefs = Prefs(requireContext!!)
            verify(navController).navigate(
                HotelHorizonFragmentDirections
                    .actionFragmentHorizonHotelToFragmentHorizonValidation(
                        dateFrom = prefs.date_from.toString(),
                        dateTo = prefs.chosenDate.toString(),
                        voucher = selectedVoucher!!,
                        plateNumber = numberPlate
                    )
            )
        }
    }

    /**
     * Enter Validate fragment
     * Only enter fragment if needed by voucher config
     */
    @Test
    fun i_validateFragment() {
        selectedVoucher = runBlocking { dbRepository.getAllVoucher()[0] }
        ApplicationProvider.getApplicationContext<HiltTestApplication>()
        val prefs = Prefs(requireContext!!)
        TestHelper.runValidation<ValidationResultsHorizonFragment>(
            navController = navController,
            voucher = selectedVoucher!!,
            plate = numberPlate,
            prefs = prefs
        )
        verify(navController).navigate(
            ValidationResultsHorizonFragmentDirections
                .actionFragmentHorizonValidationToFragmentGreetingsHorizon()
        )
    }

}

