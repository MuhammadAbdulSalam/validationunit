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
import com.sagoss.validationhorizon.databinding.FragmentHorizonValidationResultsBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.ValidationResultsBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ValidationResultsHorizonFragment : ValidationResultsBaseFragment<FragmentHorizonValidationResultsBinding>() {
    private val args                        : ValidationResultsHorizonFragmentArgs by navArgs()
    override fun getViewBinding()           = FragmentHorizonValidationResultsBinding.inflate(layoutInflater)
    override fun currentVoucher()           = args.voucher
    override fun dateTo()                   = args.dateTo
    override fun dateFrom()                 = args.dateFrom
    override fun plateNumber()              = args.plateNumber
    override fun plateTextBox()             = binding.tvPlateNo
    override fun successCard()              = binding.successCard
    override fun failureCard()              = binding.failureCard
    override fun progressbar()              = binding.layoutProgressbar
    override fun btnDone()                  = binding.btnDone
    override fun enterHomeFrag()            = ValidationResultsHorizonFragmentDirections
                                            .actionFragmentHorizonValidationToFragmentGreetingsHorizon()
}