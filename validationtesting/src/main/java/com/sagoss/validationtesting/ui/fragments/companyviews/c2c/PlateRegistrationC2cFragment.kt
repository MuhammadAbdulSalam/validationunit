/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.ui.fragments.companyviews.c2c

import androidx.navigation.fragment.navArgs
import com.sagoss.validationtesting.R
import com.sagoss.validationtesting.databinding.FragmentC2cPlateRegistrationBinding
import com.sagoss.validationtesting.ui.fragments.basefragments.EnterPlateBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlateRegistrationC2cFragment : EnterPlateBaseFragment<FragmentC2cPlateRegistrationBinding>() {

    private val args                        : PlateRegistrationC2cFragmentArgs by navArgs()

    override fun getViewBinding()           = FragmentC2cPlateRegistrationBinding.inflate(layoutInflater)
    override fun tvPlateTextView()          = binding.tvPlateNo
    override fun getToolbar()               = binding.toolbar
    override fun validateButton()           = binding.btnValidate
    override fun currentVoucher()           = args.voucher
    override fun defaultColor()             = R.color.c2c_primary
    override fun progressbar()              = binding.progressbarValidate

    override fun enterDateToFrag()          = PlateRegistrationC2cFragmentDirections
                                            .actionFragmentPlateRegistrationC2cToFragmentDateToC2c(
                                                voucher     = currentVoucher(),
                                                plateNumber = tvPlateTextView().text.toString()
                                            )

    override fun enterEntryDateFrag()       = PlateRegistrationC2cFragmentDirections
                                            .actionFragmentPlateRegistrationC2cToFragmentDateFromC2c(
                                                voucher     = currentVoucher(),
                                                plateNumber = tvPlateTextView().text.toString()
                                            )

    override fun enterHotelFrag()           = PlateRegistrationC2cFragmentDirections
                                            .actionFragmentPlateRegistrationC2cToFragmentHotelC2c(
                                                voucher     = currentVoucher(),
                                                plateNumber = tvPlateTextView().text.toString()
                                            )

    override fun enterValidationFrag(
        dateTo: String,
        dateFrom: String)                   = PlateRegistrationC2cFragmentDirections
                                            .actionFragmentPlateRegistrationC2cToFragmentValidationComplete(
                                                voucher     = args.voucher,
                                                plateNumber = binding.tvPlateNo.text.toString(),
                                                dateTo      = dateTo,
                                                dateFrom    = dateFrom
                                            )

}