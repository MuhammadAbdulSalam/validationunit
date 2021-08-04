package com.sagoss.validationhorizon.ui.fragments.companyviews.horizon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.google.android.material.button.MaterialButton
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.databinding.FragmentHorizonEntryTimeBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.EntryTimeBaseFragment

class EntryTimeHorizonFragment : EntryTimeBaseFragment<FragmentHorizonEntryTimeBinding>()  {
    private val args                : EntryTimeHorizonFragmentArgs by navArgs()
    override fun getViewBinding()   = FragmentHorizonEntryTimeBinding.inflate(layoutInflater)
    override fun datePicker()       = binding.datePicker
    override fun timePicker()       = binding.timePicker
    override fun btnValidate()      = binding.btnValidate
    override fun currentVoucher()   = args.voucher
    override fun plate()            = args.plateNumber
}