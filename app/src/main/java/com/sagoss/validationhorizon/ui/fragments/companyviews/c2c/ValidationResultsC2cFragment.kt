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
import com.sagoss.validationhorizon.databinding.FragmentC2cValidationCompleteBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.ValidationResultsBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ValidationResultsC2cFragment : ValidationResultsBaseFragment<FragmentC2cValidationCompleteBinding>() {
    private val args                        : ValidationResultsC2cFragmentArgs by navArgs()
    override fun getViewBinding()           = FragmentC2cValidationCompleteBinding.inflate(layoutInflater)
    override fun currentVoucher()           = args.voucher
    override fun dateTo()                   = args.dateTo
    override fun dateFrom()                 = args.dateFrom
    override fun plateNumber()              = args.plateNumber
    override fun plateTextBox()             = binding.tvPlateNo
    override fun successCard()              = binding.successCard
    override fun failureCard()              = binding.failureCard
    override fun progressbar()              = binding.layoutProgressbar
    override fun btnDone()                  = binding.btnDone
    override fun enterHomeFrag()            = ValidationResultsC2cFragmentDirections
                                            .actionFragmentValidationCompleteToFragmentGreetingsC2c()
}