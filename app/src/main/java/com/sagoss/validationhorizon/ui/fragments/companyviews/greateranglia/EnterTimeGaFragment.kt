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
import com.sagoss.validationhorizon.databinding.FragmentGaEnterTimeBinding
import com.sagoss.validationhorizon.databinding.FragmentHorizonEntryTimeBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.EntryTimeBaseFragment
import com.sagoss.validationhorizon.ui.fragments.companyviews.horizon.EntryTimeHorizonFragmentArgs
import com.sagoss.validationhorizon.ui.fragments.companyviews.horizon.EntryTimeHorizonFragmentDirections


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
