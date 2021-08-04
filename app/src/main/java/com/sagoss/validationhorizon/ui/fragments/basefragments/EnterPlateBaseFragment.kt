package com.sagoss.validationhorizon.ui.fragments.basefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.ui.dialogs.DialogEntryTime
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel


abstract class EnterPlateBaseFragment<VBinding : ViewBinding> : Fragment() {

    protected val viewModel: MainViewModel by viewModels()

    private lateinit var prefs                  : Prefs
    protected lateinit var binding              : VBinding

    protected abstract fun getViewBinding()     : VBinding
    protected abstract fun tvPlateTextView()    : TextView
    protected abstract fun getToolbar()         : MaterialToolbar
    protected abstract fun validateButton()     : MaterialButton
    protected abstract fun currentVoucher()     : Voucher
    protected abstract fun defaultColor()       : Int
    protected abstract fun progressbar()        : CircularProgressIndicator
    protected abstract fun enterDateToFrag()    : NavDirections
    protected abstract fun enterEntryDateFrag() : NavDirections
    protected abstract fun enterHotelFrag()     : NavDirections



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = Prefs(requireContext())
        getToolbar().setNavigationOnClickListener { findNavController().navigateUp() }
        progressbar().setIndicatorColor(ContextCompat.getColor(requireContext(), defaultColor()))

        validateButton().setOnClickListener {
            validateNumberPlate()
            progressbar().visibility = View.VISIBLE
            validateButton().visibility = View.INVISIBLE
        }
    }

    /**
     * Validate Number Plate
     *
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
                        if (currentVoucher().dateFrom) askForEntryTime() else askForDateTo()
                    }
                    Status.ERROR -> {
                        progressbar().visibility = View.INVISIBLE
                        validateButton().visibility = View.VISIBLE
                        //TODO show error
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
    }

    private fun askForDateTo() {
        val dateFrom = HelperUtil.getCurrentDateTimeString("YYYY-MM-dd HH:mm:ss")
        prefs.date_from = dateFrom

        if (currentVoucher().dateTo) {
            if (!currentVoucher().dateToFixed.isNullOrEmpty()) {
                if (currentVoucher().dateToFixed!!.size > 1) {
                    findNavController().navigate(enterHotelFrag())
                } else if (currentVoucher().dateToFixed!!.size == 1) {
                    //TODO check voucher validate
                }
            } else {
                if (!currentVoucher().dateToUnit.isNullOrEmpty()) {
                    askDateToFrag()
                }
            }
        } else {
            // TODO regidster plate check voucher
        }
    }

    /**
     * Show Fragment to enter a valid till date
     */
    private fun askDateToFrag() {
      findNavController().navigate(enterDateToFrag())
    }

    /**
     * Show Enter Entry Time fragment
     */
    private fun askForEntryTime() {
        findNavController().navigate(enterEntryDateFrag())
    }

}