/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.fragments.companyviews.c2c

import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.databinding.FragmentC2cVoucherBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.VouchersListBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VoucherC2cFragment : VouchersListBaseFragment<FragmentC2cVoucherBinding>() {

    override fun getViewBinding()           = FragmentC2cVoucherBinding.inflate(layoutInflater)
    override fun getRecycler()              = binding.recyclerVoucher
    override fun getRecyclerItemColor()     = R.color.c2c_primary
    override fun getToolbar()               = binding.toolbar

    override fun getRecyclerDirection(
        voucher: Voucher)                   = VoucherC2cFragmentDirections
                                             .actionFragmentVouchersC2cToFragmentPlateRegistrationC2c(voucher)
}