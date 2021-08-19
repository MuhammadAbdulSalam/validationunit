/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.tests.ui.dbconfig

import android.util.Log
import androidx.navigation.NavController
import androidx.test.filters.MediumTest
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.database.repository.DBRepository
import com.sagoss.validationtesting.tests.utils.Constants
import com.sagoss.validationtesting.tests.utils.TestHelper
import com.sagoss.validationtesting.tests.utils.TestHelper.runGreetingsFrag
import com.sagoss.validationtesting.tests.utils.TestHelper.runPlateRegFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.runValidation
import com.sagoss.validationtesting.tests.utils.TestHelper.runVouchersListFragment
import com.sagoss.validationtesting.tests.utils.TestHelper.updateDb
import com.sagoss.validationtesting.tests.utils.Vouchers
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
class ContractorVoucherJourney {

    @Inject lateinit var dbRepository       :DBRepository
    @get:Rule var hiltRule                  = HiltAndroidRule(this)
    private var prefs                       = null as Prefs?
    private var contractorVoucher           = null as Voucher?
    private val navController               = Mockito.mock(NavController::class.java)
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
      assert(updateDb(dbRepository))
    }

    @Test
    fun contractorVoucherHorizon(){
        runBlocking {
            contractorVoucher = dbRepository.getVoucher(Constants.CONTRACTOR_VOUCHER_NAME)
            assert(contractorVoucher != null)
        }

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsHorizonFragmentGreetings>(navController)
        verify(navController).navigate(
            GreetingsHorizonFragmentGreetingsDirections
                .actionFragmentGreetingsHorizonToFragmentVouchersHorizon()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherFragmentHorizon>(
            navController,
            Constants.CONTRACTOR_POS
        )
        verify(navController).navigate(
            VoucherFragmentHorizonDirections
                .actionFragmentVouchersHorisonToFragmentPlateRegistrationHorizon(contractorVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationHorizonFragment>(
            voucher = contractorVoucher!!,
            navController = navController,
            plate = NUMBER_PLATE
        )
        verify(navController).navigate(
            PlateRegistrationHorizonFragmentDirections
                .actionFragmentPlateRegistrationHorizonToFragmentHorizonValidation(
                    voucher = contractorVoucher!!,
                    plateNumber = NUMBER_PLATE,
                    dateTo = prefs?.chosenDate.toString(),
                    dateFrom = prefs?.date_from.toString()
                )
        )

        //Validate Plate Fragment
        runValidation<ValidationResultsHorizonFragment>(
            navController = navController,
            voucher = contractorVoucher!!,
            plate = NUMBER_PLATE,
            prefs = prefs!!
        )
        verify(navController).navigate(
            ValidationResultsHorizonFragmentDirections
                .actionFragmentHorizonValidationToFragmentGreetingsHorizon()
        )
    }

    @Test
    fun contractorVoucherC2c(){
        runBlocking {
            contractorVoucher = dbRepository.getVoucher(Constants.CONTRACTOR_VOUCHER_NAME)
            assert(contractorVoucher != null)
        }

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsC2cFragment>(navController)
        verify(navController).navigate(
            GreetingsC2cFragmentDirections
                .actionFragmentGreetingsC2cToFragmentVouchersC2c()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherC2cFragment>(
            navController,
            Constants.CONTRACTOR_POS
        )
        verify(navController).navigate(
            VoucherC2cFragmentDirections
                .actionFragmentVouchersC2cToFragmentPlateRegistrationC2c(contractorVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationC2cFragment>(
            voucher = contractorVoucher!!,
            navController = navController,
            plate = NUMBER_PLATE
        )
        verify(navController).navigate(
            PlateRegistrationC2cFragmentDirections
                .actionFragmentPlateRegistrationC2cToFragmentValidationComplete(
                    voucher = contractorVoucher!!,
                    plateNumber = NUMBER_PLATE,
                    dateTo = prefs?.chosenDate.toString(),
                    dateFrom = prefs?.date_from.toString()
                )
        )

        //Validate Plate Fragment
        runValidation<ValidationResultsC2cFragment>(
            navController = navController,
            voucher = contractorVoucher!!,
            plate = NUMBER_PLATE,
            prefs = prefs!!
        )
        verify(navController).navigate(
            ValidationResultsC2cFragmentDirections
                .actionFragmentValidationCompleteToFragmentGreetingsC2c()
        )
    }


    @Test
    fun contractorVoucherGa(){
        runBlocking {
            contractorVoucher = dbRepository.getVoucher(Constants.CONTRACTOR_VOUCHER_NAME)
            assert(contractorVoucher != null)
        }

        //Greetings Fragment
        prefs = runGreetingsFrag<GreetingsGaFragment>(navController)
        verify(navController).navigate(
            GreetingsGaFragmentDirections
                .actionFragmentGreetingsGaToFragmentVouchersGa()
        )

        //Voucher Fragment
        runVouchersListFragment<VoucherGaFragment>(
            navController,
            Constants.CONTRACTOR_POS
        )
        verify(navController).navigate(
            VoucherGaFragmentDirections
                .actionFragmentVouchersGaToFragmentPlateRegistrationGa(contractorVoucher!!)
        )

        //Plate Registration Fragment
        runPlateRegFragment<PlateRegistrationGaFragment>(
            voucher = contractorVoucher!!,
            navController = navController,
            plate = NUMBER_PLATE
        )
        verify(navController).navigate(
            PlateRegistrationGaFragmentDirections
                .actionFragmentPlateRegistrationGaToFragmentValidationGa(
                    voucher = contractorVoucher!!,
                    plateNumber = NUMBER_PLATE,
                    dateTo = prefs?.chosenDate.toString(),
                    dateFrom = prefs?.date_from.toString()
                )
        )

        //Validate Plate Fragment
        runValidation<ValidationResultsGaFragment>(
            navController = navController,
            voucher = contractorVoucher!!,
            plate = NUMBER_PLATE,
            prefs = prefs!!
        )
        verify(navController).navigate(
            ValidationResultsGaFragmentDirections
                .actionFragmentValidationGaToFragmentGreetingsGa()
        )
    }

}