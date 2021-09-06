/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.ui.fragments.basefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.utils.HelperUtil
import com.sagoss.validationtesting.utils.Prefs
import com.sagoss.validationtesting.utils.Status
import com.sagoss.validationtesting.viewmodel.MainViewModel


abstract class EnterPlateBaseFragment<VBinding : ViewBinding> : Fragment() {

    private val viewModel                           : MainViewModel by viewModels()
    private lateinit var prefs                      : Prefs
    protected lateinit var binding                  : VBinding

    protected abstract fun getViewBinding()         : VBinding
    protected abstract fun tvPlateTextView()        : EditText
    protected abstract fun getToolbar()             : MaterialToolbar
    protected abstract fun validateButton()         : MaterialButton
    protected abstract fun currentVoucher()         : Voucher
    protected abstract fun defaultColor()           : Int
    protected abstract fun progressbar()            : CircularProgressIndicator
    protected abstract fun enterDateToFrag()        : NavDirections
    protected abstract fun enterEntryDateFrag()     : NavDirections
    protected abstract fun enterHotelFrag()         : NavDirections
    protected abstract fun enterValidationFrag(
        dateTo: String,
        dateFrom: String)                           : NavDirections

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = Prefs(requireContext())
        getToolbar().setNavigationOnClickListener { findNavController().navigateUp() }
        progressbar().setIndicatorColor(ContextCompat.getColor(requireContext(), defaultColor()))

        validateButton().setOnClickListener {
            if(tvPlateTextView().text.isEmpty())
            {
                HelperUtil.getErrorDialog(this.requireContext(), "Enter Plate Number",
                    "Please insert a valid number plate.",
                    true).show()
            }
            else
            {
                progressbar().visibility = View.VISIBLE
                validateButton().visibility = View.INVISIBLE
                if(HelperUtil.isNetworkAvailable(requireContext())) { validateNumberPlate() }
                else
                {
                    if (currentVoucher().dateFrom) findNavController().navigate(enterEntryDateFrag())
                    else askForDateTo()
                }
            }
        }
    }

    /**
     * Validate Number Plate
     * Check with API if number plate is valid or not Using Api Two
     */
    private fun validateNumberPlate() {
        val plate = tvPlateTextView().text?.toString()
        val token = currentVoucher().key

        viewModel.checkDateIn(plate!!, token, "1").observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progressbar().visibility = View.INVISIBLE
                        validateButton().visibility = View.VISIBLE
                        if (currentVoucher().dateFrom) findNavController().navigate(enterEntryDateFrag()) else askForDateTo()
                    }
                    Status.ERROR -> {
                        progressbar().visibility = View.INVISIBLE
                        validateButton().visibility = View.VISIBLE
                        //TODO show error
                    }
                    Status.LOADING -> { }
                }
            }
        })
    }

    /**
     * Check if dates needs to be entered manually
     * Navigate according to date_to and date_from requirements
     */
    private fun askForDateTo() {
        val dateFrom = HelperUtil.getCurrentDateTimeString("YYYY-MM-dd HH:mm:ss")
        prefs.date_from = dateFrom
        if (currentVoucher().dateTo) {
            if (!currentVoucher().dateToFixed.isNullOrEmpty()) {
                if (currentVoucher().dateToFixed!!.size > 1) {
                    findNavController().navigate(enterHotelFrag())
                    }
                    else if (currentVoucher().dateToFixed!!.size == 1) {
                    val dateFixed = currentVoucher().dateToFixed?.get(0)
                        val dateTo = HelperUtil.getDateTo(dateFixed?.unit!!, prefs.date_from.toString())
                        prefs.chosenDate = dateTo
                        findNavController().navigate(enterValidationFrag(dateTo, dateFrom))
                    }
            } else if (!currentVoucher().dateToUnit.isNullOrEmpty()) {
                findNavController().navigate(enterDateToFrag()) }
        }
        else {
            prefs.chosenDate = ""
            findNavController().navigate(enterValidationFrag("", dateFrom)) }
    }

}