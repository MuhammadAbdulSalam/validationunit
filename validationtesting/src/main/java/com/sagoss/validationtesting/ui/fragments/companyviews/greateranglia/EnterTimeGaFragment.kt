/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia

import androidx.navigation.fragment.navArgs
import com.sagoss.validationtesting.databinding.FragmentGaEnterTimeBinding
import com.sagoss.validationtesting.ui.fragments.basefragments.EntryTimeBaseFragment


class EnterTimeGaFragment : EntryTimeBaseFragment<FragmentGaEnterTimeBinding>()  {

    private val args                        : EnterTimeGaFragmentArgs by navArgs()
    override fun getViewBinding()           = FragmentGaEnterTimeBinding.inflate(layoutInflater)
    override fun datePicker()               = binding.datePicker
    override fun timePicker()               = binding.timePicker
    override fun btnValidate()              = binding.btnValidate
    override fun currentVoucher()           = args.voucher
    override fun plate()                    = args.plateNumber
    override fun getToolbar()               = binding.toolbar
    override fun tvTitle()                  = binding.tvTitle

    override fun enterDateToFrag()          = EnterTimeGaFragmentDirections
                                            .actionFragmentDateFromGaToFragmentDateToGa(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber)

    override fun enterHotelFrag()           = EnterTimeGaFragmentDirections
                                            .actionFragmentDateFromGaToFragmentHotelGa(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber)

    override fun enterValidationFrag(
        dateTo: String,
        dateFrom: String)                   = EnterTimeGaFragmentDirections
                                            .actionFragmentDateFromGaToFragmentValidationGa(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber,
                                                dateTo      = dateTo,
                                                dateFrom    = dateFrom)
}
