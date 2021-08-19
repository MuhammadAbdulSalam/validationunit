/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.ui.fragments.basefragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.sagoss.validationtesting.R
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.utils.HelperUtil
import com.sagoss.validationtesting.utils.Prefs
import java.text.SimpleDateFormat
import java.util.*

abstract class EntryTimeBaseFragment<VBinding : ViewBinding> : Fragment() {

    protected lateinit var binding                  : VBinding
    private lateinit var prefs                      : Prefs

    protected abstract fun getViewBinding()         : VBinding
    protected abstract fun datePicker()             : DatePicker
    protected abstract fun timePicker()             : TimePicker
    protected abstract fun btnValidate()            : MaterialButton
    protected abstract fun tvTitle()                : TextView
    protected abstract fun currentVoucher()         : Voucher
    protected abstract fun plate()                  : String
    protected abstract fun getToolbar()             : MaterialToolbar
    protected abstract fun enterDateToFrag()        : NavDirections
    protected abstract fun enterHotelFrag()         : NavDirections
    protected abstract fun enterValidationFrag(
        dateTo: String,
        dateFrom: String)                           : NavDirections

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    @SuppressLint("SimpleDateFormat", "NewApi", "WeekBasedYear")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getToolbar().setNavigationOnClickListener { findNavController().navigateUp() }
        prefs = Prefs(requireContext())
        tvTitle().text = getString(R.string.entry_time_label, plate().uppercase(Locale.getDefault()))

        btnValidate().setOnClickListener{
            val calendar = Calendar.getInstance()
            calendar.set(
                datePicker().year,
                datePicker().month,
                datePicker().dayOfMonth,
                timePicker().hour,
                timePicker().minute)
            val chosenDateAndTime = SimpleDateFormat("YYYY-MM-dd HH:mm:ss")
                .format(calendar.time)
            prefs.date_from = chosenDateAndTime
            askDateTo()
        }
    }

    /**
     * If contains dateToList move to Hotel Frag
     * If date to is required move to date to fragment
     * if date to is not required then validate current plate
     */
    private fun askDateTo(){
        if(currentVoucher().dateTo)
        {
            if(!currentVoucher().dateToFixed.isNullOrEmpty()){
                if(currentVoucher().dateToFixed!!.size > 1) {
                    findNavController().navigate(enterHotelFrag()) }
                else if(currentVoucher().dateToFixed!!.size == 1)
                {
                    val dateFixed = currentVoucher().dateToFixed?.get(0)
                    val dateTo = HelperUtil.getDateTo(
                        dateFixed?.unit!!,
                        prefs.date_from.toString())
                    prefs.chosenDate = dateTo
                    findNavController().navigate(enterValidationFrag(
                        dateTo,
                        prefs.date_from.toString()))
                }
            }
            else {
                if(!currentVoucher().dateToUnit.isNullOrEmpty()){
                    findNavController().navigate(enterDateToFrag()) }
            }
        }
        else {
            prefs.chosenDate = ""
            findNavController().navigate(enterValidationFrag("", prefs.date_from.toString()))
        }
    }


}