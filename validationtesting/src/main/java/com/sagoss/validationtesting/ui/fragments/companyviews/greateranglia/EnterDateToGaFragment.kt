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
import com.sagoss.validationtesting.databinding.FragmentGaEnterDateToBinding
import com.sagoss.validationtesting.ui.fragments.basefragments.EnterDateToBaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EnterDateToGaFragment : EnterDateToBaseFragment<FragmentGaEnterDateToBinding>() {
    private val args: EnterDateToGaFragmentArgs by navArgs()

    override fun getViewBinding()           = FragmentGaEnterDateToBinding.inflate(layoutInflater)
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
        dateFrom: String)                   = EnterDateToGaFragmentDirections
                                            .actionFragmentDateToGaToFragmentValidationGa(
                                                voucher = args.voucher,
                                                plateNumber = args.plateNumber,
                                                dateTo = dateTo,
                                                dateFrom = dateFrom)
}
