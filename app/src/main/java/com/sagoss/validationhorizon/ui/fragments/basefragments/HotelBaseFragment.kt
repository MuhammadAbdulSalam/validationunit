package com.sagoss.validationhorizon.ui.fragments.basefragments

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
import com.sagoss.validationhorizon.api.models.config.DateToFixed
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.ui.recycleradapter.HotelAdapter
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.Prefs

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

    fun onRecyclerItemSelected(dateToFixed: DateToFixed){
        val dateTo = HelperUtil.getDateTo(dateToFixed.unit, prefs.date_from!!)
        findNavController().navigate(validateFrag(dateTo = dateTo, dateFrom = prefs.date_from!!))
    }



}