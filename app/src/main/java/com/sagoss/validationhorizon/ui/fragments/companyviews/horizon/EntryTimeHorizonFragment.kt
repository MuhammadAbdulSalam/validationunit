/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.fragments.companyviews.horizon

import androidx.navigation.fragment.navArgs
import com.sagoss.validationhorizon.databinding.FragmentHorizonEntryTimeBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.EntryTimeBaseFragment

class EntryTimeHorizonFragment : EntryTimeBaseFragment<FragmentHorizonEntryTimeBinding>()  {

    private val args                        : EntryTimeHorizonFragmentArgs by navArgs()
    override fun getViewBinding()           = FragmentHorizonEntryTimeBinding.inflate(layoutInflater)
    override fun datePicker()               = binding.datePicker
    override fun timePicker()               = binding.timePicker
    override fun btnValidate()              = binding.btnValidate
    override fun currentVoucher()           = args.voucher
    override fun plate()                    = args.plateNumber
    override fun getToolbar()               = binding.toolbar
    override fun tvTitle()                  = binding.tvTitle

    override fun enterDateToFrag()          = EntryTimeHorizonFragmentDirections
                                            .actionFragmentEntryTimeHorizonToFragmentEnterDateToHorizon(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber)

    override fun enterHotelFrag()           = EntryTimeHorizonFragmentDirections
                                            .actionFragmentEntryTimeHorizonToFragmentHorizonHotel(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber)

    override fun enterValidationFrag(
        dateTo: String,
        dateFrom: String)                   = EntryTimeHorizonFragmentDirections
                                            .actionFragmentEntryTimeHorizonToFragmentHorizonValidation(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber,
                                                dateTo      = dateTo,
                                                dateFrom    = dateFrom)
}