/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.fragments.basefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.addCallback
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.button.MaterialButton
import com.sagoss.validationhorizon.database.models.Request
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.utils.Constants
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel
import java.util.*
import kotlin.concurrent.schedule


abstract class ValidationResultsBaseFragment<VBinding : ViewBinding> : Fragment() {

    protected val viewModel                                 : MainViewModel by viewModels()
    protected lateinit var binding                          : VBinding
    protected abstract fun getViewBinding()                 : VBinding
    protected abstract fun currentVoucher()                 : Voucher
    protected abstract fun dateTo()                         : String
    protected abstract fun dateFrom()                       : String
    protected abstract fun plateNumber()                    : String
    protected abstract fun successCard()                    : CardView
    protected abstract fun failureCard()                    : CardView
    protected abstract fun progressbar()                    : LinearLayout
    protected abstract fun btnDone()                        : MaterialButton
    protected abstract fun plateTextBox()                   : TextView
    protected abstract fun enterHomeFrag()                  : NavDirections
    private var timer                                       = Timer("schedule", true)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {}
        btnDone().setOnClickListener{
            timer.cancel()
            findNavController().navigate(enterHomeFrag())
        }
        loadingView()
        if(HelperUtil.isNetworkAvailable(requireContext())) setupVouchersObserver() else storeOffline()
    }

    /**
     * Validate Number Plate
     * If date_to is "" set it to null, Retrofit will ignore this param if null
     *
     * Setup Results view according to results
     */
    private fun setupVouchersObserver() {
        viewModel.checkVoucher(
            plate = plateNumber(), token = currentVoucher().key, date_from = dateFrom(), date_to = dateTo())
            .observe(viewLifecycleOwner, {
            it?.let { resource ->
                goToGreetings()
                when (resource.status) {
                    Status.SUCCESS ->
                        when(resource.data!!.valid) {
                            Constants.MATCH_REDEEMED-> successView()
                            Constants.NOT_APPLICABLE,
                            Constants.NO_MATCH-> errorView()
                        }
                    Status.ERROR -> errorView()
                    Status.LOADING -> loadingView()
                }
            }
        })
    }

    /**
     * If request is done offline, Store date into DB
     *
     * Date base insert dao results are taken as validation results
     * If added show success message else error
     */
    private fun storeOffline(){
        viewModel.saveRequest(Request(
            id = 0,
            plate = plateNumber(),
            token = currentVoucher().key,
            dateFrom = dateFrom(),
            dateTo = dateTo(),
            dateSaved = HelperUtil.getCurrentDateTimeString("YYYY-MM-dd HH:mm:ss")
        )).observe(viewLifecycleOwner, {
            it.let {
                resource ->
                when(resource.status)
                {
                    Status.SUCCESS ->{ successView() }
                    Status.ERROR -> errorView()
                    Status.LOADING -> loadingView()
                }
            }
        })
    }

    /**
     * Make success view visible
     * Set plate text to TextBox
     */
    private fun successView(){
        successCard().visibility    = View.VISIBLE
        failureCard().visibility    = View.INVISIBLE
        progressbar().visibility    = View.INVISIBLE
        btnDone().visibility        = View.VISIBLE
        plateTextBox().text         = plateNumber()
    }

    /**
     * Show Error Card and error message
     */
    private fun errorView(){
        successCard().visibility    = View.INVISIBLE
        failureCard().visibility    = View.VISIBLE
        progressbar().visibility    = View.INVISIBLE
        btnDone().visibility        = View.VISIBLE
    }

    /**
     * Hide results view and show progressbar
     */
    private fun loadingView(){
        successCard().visibility    = View.INVISIBLE
        failureCard().visibility    = View.INVISIBLE
        progressbar().visibility    = View.VISIBLE
        btnDone().visibility        = View.INVISIBLE
    }

    /**
     * If no activity by user, wait 30 seconds and go to Greetings Screen
     */
    private fun goToGreetings(){
        timer.schedule(30000L) {
            activity?.runOnUiThread{ findNavController().navigate(enterHomeFrag()) }
            timer.cancel()
        }
    }
}