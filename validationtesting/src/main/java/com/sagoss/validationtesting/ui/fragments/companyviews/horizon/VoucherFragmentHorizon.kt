/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.ui.fragments.companyviews.horizon

import androidx.navigation.NavDirections
import com.sagoss.validationtesting.R
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.databinding.FragmentHorizonVoucherBinding
import com.sagoss.validationtesting.ui.fragments.basefragments.VouchersListBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VoucherFragmentHorizon : VouchersListBaseFragment<FragmentHorizonVoucherBinding>() {

    override fun getViewBinding()           = FragmentHorizonVoucherBinding.inflate(layoutInflater)
    override fun getRecycler()              = binding.recyclerVoucher
    override fun getRecyclerItemColor()     = R.color.horizon_primary
    override fun getToolbar()               = binding.toolbar

    override fun getRecyclerDirection(voucher: Voucher): NavDirections {
        return VoucherFragmentHorizonDirections
            .actionFragmentVouchersHorisonToFragmentPlateRegistrationHorizon(voucher)
    }
}