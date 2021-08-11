/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.fragments.companyviews.c2c

import androidx.navigation.fragment.navArgs
import com.sagoss.validationhorizon.databinding.FragmentC2cEntryTimeBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.EntryTimeBaseFragment

class EntryTimeC2cFragment : EntryTimeBaseFragment<FragmentC2cEntryTimeBinding>()  {

    private val args                        : EntryTimeC2cFragmentArgs by navArgs()
    override fun getViewBinding()           = FragmentC2cEntryTimeBinding.inflate(layoutInflater)
    override fun datePicker()               = binding.datePicker
    override fun timePicker()               = binding.timePicker
    override fun btnValidate()              = binding.btnValidate
    override fun currentVoucher()           = args.voucher
    override fun plate()                    = args.plateNumber
    override fun getToolbar()               = binding.toolbar
    override fun tvTitle()                  = binding.tvTitle

    override fun enterDateToFrag()          = EntryTimeC2cFragmentDirections
                                            .actionFragmentDateFromC2cToFragmentDateToC2c(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber)

    override fun enterHotelFrag()           = EntryTimeC2cFragmentDirections
                                            .actionFragmentDateFromC2cToFragmentHotelC2c(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber)

    override fun enterValidationFrag(
        dateTo: String,
        dateFrom: String)                   = EntryTimeC2cFragmentDirections
                                            .actionFragmentDateFromC2cToFragmentValidationComplete(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber,
                                                dateTo      = dateTo,
                                                dateFrom    = dateFrom)
}
