/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.fragments.companyviews.greateranglia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.databinding.FragmentGaPlateRegistrationBinding
import com.sagoss.validationhorizon.databinding.FragmentHorizonPlateRegistrationBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.EnterPlateBaseFragment
import com.sagoss.validationhorizon.ui.fragments.companyviews.horizon.PlateRegistrationHorizonFragmentArgs
import com.sagoss.validationhorizon.ui.fragments.companyviews.horizon.PlateRegistrationHorizonFragmentDirections
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PlateRegistrationGaFragment : EnterPlateBaseFragment<FragmentGaPlateRegistrationBinding>() {

    private val args                        : PlateRegistrationGaFragmentArgs by navArgs()

    override fun getViewBinding()           = FragmentGaPlateRegistrationBinding.inflate(layoutInflater)
    override fun tvPlateTextView()          = binding.tvPlateNo
    override fun getToolbar()               = binding.toolbar
    override fun validateButton()           = binding.btnValidate
    override fun currentVoucher()           = args.voucher
    override fun defaultColor()             = R.color.ga_primary
    override fun progressbar()              = binding.progressbarValidate

    override fun enterDateToFrag()          = PlateRegistrationGaFragmentDirections
                                            .actionFragmentPlateRegistrationGaToFragmentDateToGa(
                                                voucher     = currentVoucher(),
                                                plateNumber = tvPlateTextView().text.toString()
                                            )

    override fun enterEntryDateFrag()       = PlateRegistrationGaFragmentDirections
                                            .actionFragmentPlateRegistrationGaToFragmentDateFromGa(
                                                voucher     = currentVoucher(),
                                                plateNumber = tvPlateTextView().text.toString()
                                            )

    override fun enterHotelFrag()           = PlateRegistrationGaFragmentDirections
                                            .actionFragmentPlateRegistrationGaToFragmentHotelGa(
                                                voucher     = currentVoucher(),
                                                plateNumber = tvPlateTextView().text.toString()
                                            )

    override fun enterValidationFrag(
        dateTo: String,
        dateFrom: String)                   = PlateRegistrationGaFragmentDirections
                                            .actionFragmentPlateRegistrationGaToFragmentValidationGa(
                                                voucher     = args.voucher,
                                                plateNumber = binding.tvPlateNo.text.toString(),
                                                dateTo      = dateTo,
                                                dateFrom    = dateFrom
                                            )

}