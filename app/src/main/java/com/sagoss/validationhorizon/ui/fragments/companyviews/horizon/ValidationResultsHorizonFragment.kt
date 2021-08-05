package com.sagoss.validationhorizon.ui.fragments.companyviews.horizon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavDirections
import androidx.navigation.fragment.navArgs
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.databinding.FragmentHorizonValidationResultsBinding
import com.sagoss.validationhorizon.databinding.FragmentHorizonVoucherBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.ValidationResultsBaseFragment
import com.sagoss.validationhorizon.ui.fragments.basefragments.VouchersListBaseFragment
import com.sagoss.validationhorizon.utils.Constants
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