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
import com.sagoss.validationhorizon.databinding.FragmentC2cEnterDateToBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.EnterDateToBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EnterDateToC2cFragment : EnterDateToBaseFragment<FragmentC2cEnterDateToBinding>() {
    private val args: EnterDateToC2cFragmentArgs by navArgs()

    override fun getViewBinding()           = FragmentC2cEnterDateToBinding.inflate(layoutInflater)
    override fun getToolbar()               = binding.toolbar
    override fun btnAdd()                   = binding.btnAdd
    override fun btnSubtract()              = binding.btnSubtract
    override fun btnConfirm()               = binding.btnConfirm
    override fun currentVoucher()           = args.voucher
    override fun plate()                    = args.plateNumber
    override fun durationTextView()         = binding.durationField
    override fun expiryTextView()           = binding.ExitBeforeField

    override fun enterValidationFrag(
        dateTo: String,
        dateFrom: String)                   = EnterDateToC2cFragmentDirections
                                            .actionFragmentDateToC2cToFragmentValidationComplete(
                                                voucher = args.voucher,
                                                plateNumber = args.plateNumber,
                                                dateTo = dateTo,
                                                dateFrom = dateFrom)
}
