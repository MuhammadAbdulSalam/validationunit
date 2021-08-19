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
import com.sagoss.validationtesting.ui.fragments.companyviews.c2c.*
import com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia.*
import com.sagoss.validationtesting.ui.fragments.companyviews.horizon.*
import com.sagoss.validationtesting.tests.utils.Constants
import com.sagoss.validationtesting.tests.utils.Constants.ACADEMY_USER_POS
import com.sagoss.validationtesting.tests.utils.TestHelper.runDateToFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.runGreetingsFrag
import com.sagoss.validationtesting.tests.utils.TestHelper.runPlateRegFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.runValidation
import com.sagoss.validationtesting.tests.utils.TestHelper.runVouchersListFragment
import com.sagoss.validationtesting.tests.utils.Vouchers
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
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AcademyUserJourney {

    @Inject lateinit var dbRepository       : DBRepository
    @get:Rule var hiltRule                  = HiltAndroidRule(this)
    private var prefs                       = null as Prefs?
    private var academyVoucher              = null as Voucher?
    private val navController               = mock(NavController::class.java)
    private val NUMBER_PLATE                = "ABC123"

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

    /**
     * Run Navigation Test for success vouchers on Horizon UI
     *
     * Result will be success only if a whole journey is complete
     */
    @Test
    fun voucherAcademyUserHorizonTest() {
        runBlocking { academyVoucher = dbRepository.getVoucher(Constants.ACADEMY_VOUCHER_NAME)}
        assert(academyVoucher != null)

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsHorizonFragmentGreetings>(navController)
        verify(navController).navigate(
            GreetingsHorizonFragmentGreetingsDirections
                .actionFragmentGreetingsHorizonToFragmentVouchersHorizon()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherFragmentHorizon>(navController, ACADEMY_USER_POS)
        verify(navController).navigate(
            VoucherFragmentHorizonDirections
                .actionFragmentVouchersHorisonToFragmentPlateRegistrationHorizon(academyVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationHorizonFragment>(
            voucher = academyVoucher!!,
            navController = navController,
            plate = NUMBER_PLATE
        )
        verify(navController).navigate(
            PlateRegistrationHorizonFragmentDirections
                .actionFragmentPlateRegistrationHorizonToFragmentEnterDateToHorizon(
                    voucher = academyVoucher!!, plateNumber = NUMBER_PLATE
                )
        )

        //Date To Fragment
        runDateToFragment<EnterDateToHorizonFragment>(navController,academyVoucher!!, NUMBER_PLATE)
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
       runValidation<ValidationResultsHorizonFragment>(
           navController =  navController,
           voucher = academyVoucher!!,
           plate = NUMBER_PLATE,
           prefs = prefs!!)
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
    fun voucherAcademyUserC2cTest() {
        runBlocking { academyVoucher = dbRepository.getVoucher(Constants.ACADEMY_VOUCHER_NAME)}
        assert(academyVoucher != null)

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsC2cFragment>(navController)
        verify(navController).navigate(
            GreetingsC2cFragmentDirections
                .actionFragmentGreetingsC2cToFragmentVouchersC2c()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherC2cFragment>(navController, ACADEMY_USER_POS)
        verify(navController).navigate(
            VoucherC2cFragmentDirections
                .actionFragmentVouchersC2cToFragmentPlateRegistrationC2c(academyVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationC2cFragment>(academyVoucher!!, navController, NUMBER_PLATE)
        verify(navController).navigate(
            PlateRegistrationC2cFragmentDirections
                .actionFragmentPlateRegistrationC2cToFragmentDateToC2c(
                    voucher = academyVoucher!!, plateNumber = NUMBER_PLATE
                )
        )

        //Date To Fragment
        runDateToFragment<EnterDateToC2cFragment>(navController,academyVoucher!!, NUMBER_PLATE)
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
        runValidation<ValidationResultsC2cFragment>(
            navController =  navController,
            voucher = academyVoucher!!,
            plate = NUMBER_PLATE,
            prefs = prefs!!)
        verify(navController).navigate(
            ValidationResultsC2cFragmentDirections
                .actionFragmentValidationCompleteToFragmentGreetingsC2c()
        )
    }

    /**
     * Run Navigation Test for success vouchers on GA UI
     *
     * Result will be success only if a whole journey is complete
     */
    @Test
    fun voucherAcademyUserGaTest() {
        runBlocking { academyVoucher = dbRepository.getVoucher(Constants.ACADEMY_VOUCHER_NAME)}
        assert(academyVoucher != null)

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsGaFragment>(navController)
        verify(navController).navigate(
            GreetingsGaFragmentDirections
                .actionFragmentGreetingsGaToFragmentVouchersGa()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherGaFragment>(navController, ACADEMY_USER_POS)
        verify(navController).navigate(
            VoucherGaFragmentDirections
                .actionFragmentVouchersGaToFragmentPlateRegistrationGa(academyVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationGaFragment>(academyVoucher!!, navController, NUMBER_PLATE)
        verify(navController).navigate(
            PlateRegistrationGaFragmentDirections
                .actionFragmentPlateRegistrationGaToFragmentDateToGa(
                    voucher = academyVoucher!!, plateNumber = NUMBER_PLATE
                )
        )

        //Date To Fragment
        runDateToFragment<EnterDateToGaFragment>(navController,academyVoucher!!, NUMBER_PLATE)
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
        runValidation<ValidationResultsGaFragment>(
            navController =  navController,
            voucher = academyVoucher!!,
            plate = NUMBER_PLATE,
            prefs = prefs!!)
        verify(navController).navigate(
            ValidationResultsGaFragmentDirections
                .actionFragmentValidationGaToFragmentGreetingsGa()
        )
    }

}