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
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.google.android.material.appbar.MaterialToolbar
import com.sagoss.validationtesting.api.models.config.DateToFixed
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.ui.recycleradapter.HotelAdapter
import com.sagoss.validationtesting.utils.HelperUtil
import com.sagoss.validationtesting.utils.Prefs

abstract class HotelBaseFragment<VBinding : ViewBinding> : Fragment() {

    private lateinit var prefs                  : Prefs
    protected lateinit var binding              : VBinding
    protected abstract fun getViewBinding()     : VBinding
    protected abstract fun recycler()           : RecyclerView
    protected abstract fun getVoucher()         : Voucher
    protected abstract fun getItemColor()       : Int
    protected abstract fun plateNumber()        : String
    protected abstract fun getToolbar()         : MaterialToolbar
    protected abstract fun validateFrag(
        dateFrom: String,
        dateTo: String
    )                                           : NavDirections

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getToolbar().setNavigationOnClickListener { findNavController().navigateUp() }
        prefs = Prefs(requireContext())
        val listOfDateToFixed = getVoucher().dateToFixed
        val recyclerView = recycler()
        val adapter = HotelAdapter(getItemColor(), this)

        recyclerView.adapter = adapter
        adapter.submitList(listOfDateToFixed)
        adapter.notifyDataSetChanged()
    }

    /**
     * @param dateToFixed item selected from recycler
     *
     * Move direction according to item selected
     */
    fun onRecyclerItemSelected(dateToFixed: DateToFixed){
        val dateTo = HelperUtil.getDateTo(dateToFixed.unit, prefs.date_from!!)
        prefs.chosenDate = dateTo
        findNavController().navigate(validateFrag(dateTo = dateTo, dateFrom = prefs.date_from!!))
    }



}