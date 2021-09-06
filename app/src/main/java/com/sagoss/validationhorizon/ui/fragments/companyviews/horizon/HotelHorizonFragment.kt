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
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.databinding.FragmentHorizonHotelBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.HotelBaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HotelHorizonFragment : HotelBaseFragment<FragmentHorizonHotelBinding>() {
    private val args                        : HotelHorizonFragmentArgs by navArgs()
    override fun getViewBinding()           = FragmentHorizonHotelBinding.inflate(layoutInflater)
    override fun recycler()                 = binding.recycler
    override fun getVoucher()               = args.voucher
    override fun getItemColor()             = R.color.horizon_primary
    override fun plateNumber()              = args.plateNumber
    override fun getToolbar()               = binding.toolbar

    override fun validateFrag(
        dateFrom: String,
        dateTo: String)                     = HotelHorizonFragmentDirections
                                            .actionFragmentHorizonHotelToFragmentHorizonValidation(
                                             plateNumber   = args.plateNumber,
                                             voucher       = args.voucher,
                                             dateTo        = dateTo,
                                             dateFrom      = dateFrom )
}