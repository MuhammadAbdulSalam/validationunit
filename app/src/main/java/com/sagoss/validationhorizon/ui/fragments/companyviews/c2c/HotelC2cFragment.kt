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
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.databinding.FragmentC2cHotelBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.HotelBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelC2cFragment : HotelBaseFragment<FragmentC2cHotelBinding>() {
    private val args                        : HotelC2cFragmentArgs by navArgs()
    override fun getViewBinding()           = FragmentC2cHotelBinding.inflate(layoutInflater)
    override fun recycler()                 = binding.recycler
    override fun getVoucher()               = args.voucher
    override fun getItemColor()             = R.color.c2c_primary
    override fun plateNumber()              = args.plateNumber
    override fun getToolbar()               = binding.toolbar

    override fun validateFrag(
        dateFrom: String,
        dateTo: String)                     = HotelC2cFragmentDirections
                                            .actionFragmentHotelC2cToFragmentValidationComplete(
                                                plateNumber   = args.plateNumber,
                                                voucher       = args.voucher,
                                                dateTo        = dateTo,
                                                dateFrom      = dateFrom )
}