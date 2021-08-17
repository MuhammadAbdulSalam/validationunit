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
import com.sagoss.validationtesting.R
import com.sagoss.validationtesting.databinding.FragmentGaHotelBinding
import com.sagoss.validationtesting.ui.fragments.basefragments.HotelBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelGaFragment : HotelBaseFragment<FragmentGaHotelBinding>() {
    private val args                        : HotelGaFragmentArgs by navArgs()
    override fun getViewBinding()           = FragmentGaHotelBinding.inflate(layoutInflater)
    override fun recycler()                 = binding.recycler
    override fun getVoucher()               = args.voucher
    override fun getItemColor()             = R.color.ga_primary
    override fun plateNumber()              = args.plateNumber
    override fun getToolbar()               = binding.toolbar

    override fun validateFrag(
        dateFrom: String,
        dateTo: String)                     = HotelGaFragmentDirections
                                            .actionFragmentHotelGaToFragmentValidationGa(
                                                plateNumber   = args.plateNumber,
                                                voucher       = args.voucher,
                                                dateTo        = dateTo,
                                                dateFrom      = dateFrom )
}