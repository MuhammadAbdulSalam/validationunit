/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.tests.ui.dbconfig

import androidx.navigation.NavController
import androidx.test.filters.MediumTest
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.database.repository.DBRepository
import com.sagoss.validationtesting.tests.utils.Constants
import com.sagoss.validationtesting.tests.utils.TestHelper.runDateFrom
import com.sagoss.validationtesting.tests.utils.TestHelper.runGreetingsFrag
import com.sagoss.validationtesting.tests.utils.TestHelper.runPlateRegFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.runValidation
import com.sagoss.validationtesting.tests.utils.TestHelper.runVouchersListFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.updateDb
import com.sagoss.validationtesting.ui.fragments.companyviews.c2c.*
import com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia.*
import com.sagoss.validationtesting.ui.fragments.companyviews.horizon.*
import com.sagoss.validationtesting.utils.Prefs
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
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

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class DisabledVoucherJourney {

    @Inject lateinit var dbRepository           : DBRepository
    @get:Rule var hiltRule                      = HiltAndroidRule(this)
    private var prefs                           = null as Prefs?
    private var disabledVoucher                 = null as Voucher?
    private val navController                   = Mockito.mock(NavController::class.java)
    private val numberPlate                     = "ABC123"

    /**
     * setup hilt rule inject
     */
    @Before
    fun setup() {
        hiltRule.inject()
    }

    /**
     * Update voucher in Database
     * Delete existing Vouchers and update new vouchers for use
     */
    @Test
    fun aDatabaseVouchers() {
        assert(updateDb(dbRepository))
    }

    /**
     * Run Navigation Test for success vouchers on Horizon UI
     *
     * Result will be success only if a whole journey is complete
     */
    @Test
    fun voucherDisabledHorizonTest() {
        runBlocking { disabledVoucher = dbRepository.getVoucher(Constants.DISABLED_VOUCHER_NAME)}
        assert(disabledVoucher != null)

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsHorizonFragmentGreetings>(navController)
        verify(navController).navigate(
            GreetingsHorizonFragmentGreetingsDirections
                .actionFragmentGreetingsHorizonToFragmentVouchersHorizon()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherFragmentHorizon>(
            navController,
            Constants.DISABLED_POS
        )
        verify(navController).navigate(
            VoucherFragmentHorizonDirections
                .actionFragmentVouchersHorisonToFragmentPlateRegistrationHorizon(disabledVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationHorizonFragment>(
            voucher = disabledVoucher!!,
            navController = navController,
            plate = numberPlate
        )
        verify(navController).navigate(
            PlateRegistrationHorizonFragmentDirections
                .actionFragmentPlateRegistrationHorizonToFragmentEntryTimeHorizon(
                    voucher = disabledVoucher!!, plateNumber = numberPlate
                )
        )

        //Date from Fragment
        runDateFrom<EntryTimeHorizonFragment>(navController, disabledVoucher!!, numberPlate)
        verify(navController).navigate(
            EntryTimeHorizonFragmentDirections
                .actionFragmentEntryTimeHorizonToFragmentHorizonValidation(
                    dateFrom = prefs?.date_from.toString(),
                    dateTo = prefs?.chosenDate.toString(),
                    voucher = disabledVoucher!!,
                    plateNumber = numberPlate
                )
        )

        //Validate Plate Fragment
        runValidation<ValidationResultsHorizonFragment>(
            navController = navController,
            voucher = disabledVoucher!!,
            plate = numberPlate,
            prefs = prefs!!
        )
        verify(navController).navigate(
            ValidationResultsHorizonFragmentDirections
                .actionFragmentHorizonValidationToFragmentGreetingsHorizon()
        )
    }


    /**
     * Run Navigation Test for success vouchers on C2C UI
     *
     * Result will be success only if a whole journey is complete
     */
    @Test
    fun voucherDisabledC2cTest() {
        runBlocking { disabledVoucher = dbRepository.getVoucher(Constants.DISABLED_VOUCHER_NAME)}
        assert(disabledVoucher != null)

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsC2cFragment>(navController)
        verify(navController).navigate(
            GreetingsC2cFragmentDirections.actionFragmentGreetingsC2cToFragmentVouchersC2c()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherC2cFragment>(navController, Constants.DISABLED_POS)
        verify(navController).navigate(
            VoucherC2cFragmentDirections
                .actionFragmentVouchersC2cToFragmentPlateRegistrationC2c(disabledVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationC2cFragment>(
            voucher = disabledVoucher!!,
            navController = navController,
            plate = numberPlate
        )
        verify(navController).navigate(
            PlateRegistrationC2cFragmentDirections
                .actionFragmentPlateRegistrationC2cToFragmentDateFromC2c(
                    voucher = disabledVoucher!!, plateNumber = numberPlate
                )
        )

        //Date from Fragment
        runDateFrom<EntryTimeC2cFragment>(navController, disabledVoucher!!, numberPlate)
        verify(navController).navigate(
            EntryTimeC2cFragmentDirections
                .actionFragmentDateFromC2cToFragmentValidationComplete(
                    dateFrom = prefs?.date_from.toString(),
                    dateTo = prefs?.chosenDate.toString(),
                    voucher = disabledVoucher!!,
                    plateNumber = numberPlate
                )
        )

        //Validate Plate Fragment
        runValidation<ValidationResultsC2cFragment>(
            navController = navController,
            voucher = disabledVoucher!!,
            plate = numberPlate,
            prefs = prefs!!
        )
        verify(navController).navigate(
            ValidationResultsC2cFragmentDirections
                .actionFragmentValidationCompleteToFragmentGreetingsC2c()
        )
    }

    /**
     * Run Navigation Test for success vouchers on C2C UI
     *
     * Result will be success only if a whole journey is complete
     */
    @Test
    fun voucherDisabledGaTest() {
        runBlocking { disabledVoucher = dbRepository.getVoucher(Constants.DISABLED_VOUCHER_NAME)}
        assert(disabledVoucher != null)

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsGaFragment>(navController)
        verify(navController).navigate(
            GreetingsGaFragmentDirections.actionFragmentGreetingsGaToFragmentVouchersGa()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherGaFragment>(navController, Constants.DISABLED_POS)
        verify(navController).navigate(
            VoucherGaFragmentDirections
                .actionFragmentVouchersGaToFragmentPlateRegistrationGa(disabledVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationGaFragment>(
            voucher = disabledVoucher!!,
            navController = navController,
            plate = numberPlate
        )
        verify(navController).navigate(
            PlateRegistrationGaFragmentDirections
                .actionFragmentPlateRegistrationGaToFragmentDateFromGa(
                    voucher = disabledVoucher!!, plateNumber = numberPlate
                )
        )

        //Date from Fragment
        runDateFrom<EnterTimeGaFragment>(navController, disabledVoucher!!, numberPlate)
        verify(navController).navigate(
            EnterTimeGaFragmentDirections
                .actionFragmentDateFromGaToFragmentValidationGa(
                    dateFrom = prefs?.date_from.toString(),
                    dateTo = prefs?.chosenDate.toString(),
                    voucher = disabledVoucher!!,
                    plateNumber = numberPlate
                )
        )

        //Validate Plate Fragment
        runValidation<ValidationResultsGaFragment>(
            navController = navController,
            voucher = disabledVoucher!!,
            plate = numberPlate,
            prefs = prefs!!
        )
        verify(navController).navigate(
            ValidationResultsGaFragmentDirections
                .actionFragmentValidationGaToFragmentGreetingsGa()
        )
    }

}
