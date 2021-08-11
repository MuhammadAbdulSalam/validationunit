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
import androidx.navigation.NavDirections
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.databinding.FragmentGaVoucherBinding
import com.sagoss.validationhorizon.databinding.FragmentHorizonVoucherBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.VouchersListBaseFragment
import com.sagoss.validationhorizon.ui.fragments.companyviews.horizon.VoucherFragmentHorizonDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VoucherGaFragment : VouchersListBaseFragment<FragmentGaVoucherBinding>() {

    override fun getViewBinding()           = FragmentGaVoucherBinding.inflate(layoutInflater)
    override fun getRecycler()              = binding.recyclerVoucher
    override fun getRecyclerItemColor()     = R.color.horizon_primary
    override fun getToolbar()               = binding.toolbar

    override fun getRecyclerDirection(
        voucher: Voucher)                   = VoucherFragmentHorizonDirections
                                            .actionFragmentVouchersHorisonToFragmentPlateRegistrationHorizon(voucher)
}
