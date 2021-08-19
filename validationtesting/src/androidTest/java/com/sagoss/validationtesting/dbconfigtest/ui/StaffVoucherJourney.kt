/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.dbconfigtest.ui

import android.util.Log
import androidx.navigation.NavController
import androidx.test.filters.MediumTest
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.database.repository.DBRepository
import com.sagoss.validationtesting.ui.fragments.companyviews.c2c.*
import com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia.*
import com.sagoss.validationtesting.ui.fragments.companyviews.horizon.*
import com.sagoss.validationtesting.util.Constants
import com.sagoss.validationtesting.util.Constants.STAFF_POS
import com.sagoss.validationtesting.util.TestHelper
import com.sagoss.validationtesting.util.TestHelper.runGreetingsFrag
import com.sagoss.validationtesting.util.TestHelper.runHotelFragment
import com.sagoss.validationtesting.util.TestHelper.runPlateRegFragment
import com.sagoss.validationtesting.util.TestHelper.runValidation
import com.sagoss.validationtesting.util.TestHelper.runVouchersListFragment
import com.sagoss.validationtesting.utils.Prefs
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class StaffVoucherJourney {

    @Inject lateinit var dbRepository       : DBRepository
    @get:Rule var hiltRule                  = HiltAndroidRule(this)
    private var prefs                       = null as Prefs?
    private var staffVoucher                = null as Voucher?
    private val navController               = Mockito.mock(NavController::class.java)
    private val NUMBER_PLATE                = "ABC123"

    /**
     * setup hilt rule inject
     */
    @Before
    fun setup() {
        hiltRule.inject()
    }


    @Test
    fun voucherStaffHorizon(){
        runBlocking {
            staffVoucher = dbRepository.getVoucher(Constants.STAFF_VOUCHER_NAME)
            assert(staffVoucher != null)
        }

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsHorizonFragmentGreetings>(navController)
        verify(navController).navigate(
            GreetingsHorizonFragmentGreetingsDirections
                .actionFragmentGreetingsHorizonToFragmentVouchersHorizon()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherFragmentHorizon>(navController, STAFF_POS)
        verify(navController).navigate(
            VoucherFragmentHorizonDirections
                .actionFragmentVouchersHorisonToFragmentPlateRegistrationHorizon(staffVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationHorizonFragment>(
            voucher = staffVoucher!!,
            navController = navController,
            plate = NUMBER_PLATE
        )
        verify(navController).navigate(
            PlateRegistrationHorizonFragmentDirections
                .actionFragmentPlateRegistrationHorizonToFragmentHorizonHotel(
                    voucher = staffVoucher!!, plateNumber = NUMBER_PLATE
                )
        )

        //Date To Fragment
        runHotelFragment<HotelHorizonFragment>(
            navController, staffVoucher!!, NUMBER_PLATE)
        verify(navController).navigate(
            HotelHorizonFragmentDirections
                .actionFragmentHorizonHotelToFragmentHorizonValidation(
                    dateFrom = prefs?.date_from.toString(),
                    dateTo = prefs?.chosenDate.toString(),
                    voucher = staffVoucher!!,
                    plateNumber = NUMBER_PLATE
                )
        )

        //Validate Plate Fragment
        runValidation<ValidationResultsHorizonFragment>(
            navController = navController,
            voucher = staffVoucher!!,
            plate = NUMBER_PLATE,
            prefs = prefs!!
        )
        verify(navController).navigate(
            ValidationResultsHorizonFragmentDirections
                .actionFragmentHorizonValidationToFragmentGreetingsHorizon()
        )
    }


    @Test
    fun voucherStaffC2c(){
        runBlocking {
            staffVoucher = dbRepository.getVoucher(Constants.STAFF_VOUCHER_NAME)
            assert(staffVoucher != null)
        }

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsC2cFragment>(navController)
        verify(navController).navigate(
            GreetingsC2cFragmentDirections
                .actionFragmentGreetingsC2cToFragmentVouchersC2c()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherC2cFragment>(navController, STAFF_POS)
        verify(navController).navigate(
            VoucherC2cFragmentDirections
                .actionFragmentVouchersC2cToFragmentPlateRegistrationC2c(staffVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationC2cFragment>(
            voucher = staffVoucher!!,
            navController = navController,
            plate = NUMBER_PLATE
        )
        verify(navController).navigate(
            PlateRegistrationC2cFragmentDirections
                .actionFragmentPlateRegistrationC2cToFragmentHotelC2c(
                    voucher = staffVoucher!!, plateNumber = NUMBER_PLATE
                )
        )

        //Date To Fragment
        runHotelFragment<HotelC2cFragment>(
            navController, staffVoucher!!, NUMBER_PLATE)
        verify(navController).navigate(
            HotelC2cFragmentDirections
                .actionFragmentHotelC2cToFragmentValidationComplete(
                    dateFrom = prefs?.date_from.toString(),
                    dateTo = prefs?.chosenDate.toString(),
                    voucher = staffVoucher!!,
                    plateNumber = NUMBER_PLATE
                )
        )

        //Validate Plate Fragment
        runValidation<ValidationResultsC2cFragment>(
            navController = navController,
            voucher = staffVoucher!!,
            plate = NUMBER_PLATE,
            prefs = prefs!!
        )
        verify(navController).navigate(
            ValidationResultsC2cFragmentDirections
                .actionFragmentValidationCompleteToFragmentGreetingsC2c()
        )
    }

    @Test
    fun voucherStaffGa(){
        runBlocking {
            staffVoucher = dbRepository.getVoucher(Constants.STAFF_VOUCHER_NAME)
            assert(staffVoucher != null)
        }

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsGaFragment>(navController)
        verify(navController).navigate(
            GreetingsGaFragmentDirections
                .actionFragmentGreetingsGaToFragmentVouchersGa()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherGaFragment>(navController, STAFF_POS)
        verify(navController).navigate(
            VoucherGaFragmentDirections
                .actionFragmentVouchersGaToFragmentPlateRegistrationGa(staffVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationGaFragment>(
            voucher = staffVoucher!!,
            navController = navController,
            plate = NUMBER_PLATE
        )
        verify(navController).navigate(
            PlateRegistrationGaFragmentDirections
                .actionFragmentPlateRegistrationGaToFragmentHotelGa(
                    voucher = staffVoucher!!, plateNumber = NUMBER_PLATE
                )
        )

        //Date To Fragment
        runHotelFragment<HotelGaFragment>(
            navController, staffVoucher!!, NUMBER_PLATE)
        verify(navController).navigate(
            HotelGaFragmentDirections
                .actionFragmentHotelGaToFragmentValidationGa(
                    dateFrom = prefs?.date_from.toString(),
                    dateTo = prefs?.chosenDate.toString(),
                    voucher = staffVoucher!!,
                    plateNumber = NUMBER_PLATE
                )
        )

        //Validate Plate Fragment
        runValidation<ValidationResultsGaFragment>(
            navController = navController,
            voucher = staffVoucher!!,
            plate = NUMBER_PLATE,
            prefs = prefs!!
        )
        verify(navController).navigate(
            ValidationResultsGaFragmentDirections
                .actionFragmentValidationGaToFragmentGreetingsGa()
        )
    }

}
