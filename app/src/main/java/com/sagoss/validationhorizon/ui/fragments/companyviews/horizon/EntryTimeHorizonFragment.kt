package com.sagoss.validationhorizon.ui.fragments.companyviews.horizon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.navigation.NavArgs
import androidx.navigation.NavDirections
import androidx.navigation.fragment.navArgs
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.databinding.FragmentHorizonEntryTimeBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.EntryTimeBaseFragment

class EntryTimeHorizonFragment : EntryTimeBaseFragment<FragmentHorizonEntryTimeBinding>()  {

    private val args                        : EntryTimeHorizonFragmentArgs by navArgs()
    override fun getViewBinding()           = FragmentHorizonEntryTimeBinding.inflate(layoutInflater)
    override fun datePicker()               = binding.datePicker
    override fun timePicker()               = binding.timePicker
    override fun btnValidate()              = binding.btnValidate
    override fun currentVoucher()           = args.voucher
    override fun plate()                    = args.plateNumber
    override fun getToolbar()               = binding.toolbar
    override fun tvTitle()                  = binding.tvTitle

    override fun enterDateToFrag()          = EntryTimeHorizonFragmentDirections
                                            .actionFragmentEntryTimeHorizonToFragmentEnterDateToHorizon(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber)

    override fun enterHotelFrag()           = EntryTimeHorizonFragmentDirections
                                            .actionFragmentEntryTimeHorizonToFragmentHorizonHotel(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber)

    override fun enterValidationFrag(
        dateTo: String,
        dateFrom: String)                   = EntryTimeHorizonFragmentDirections
                                            .actionFragmentEntryTimeHorizonToFragmentHorizonValidation(
                                                voucher     = args.voucher,
                                                plateNumber = args.plateNumber,
                                                dateTo      = dateTo,
                                                dateFrom    = dateFrom)
}