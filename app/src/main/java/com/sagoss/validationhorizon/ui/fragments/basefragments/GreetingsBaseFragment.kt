/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.fragments.basefragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.sagoss.validationhorizon.BuildConfig
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel


abstract class GreetingsBaseFragment<VBinding : ViewBinding> : Fragment() {

    private val viewModel                                   : MainViewModel by viewModels()
    protected lateinit var binding                          : VBinding
    protected abstract fun getViewBinding()                 : VBinding
    protected abstract fun tvGreetingsMsg()                 : TextView
    protected abstract fun tvVersionInfo()                  : TextView

    protected abstract fun tvGreetingsMsgClickListener(
        voucherToSend: Voucher?)                            : View.OnClickListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {}

        tvGreetingsMsg().text =
            "Welcome to\n ${Prefs(requireContext()).locationName}\n Press here to begin"

        "Version: ${BuildConfig.VERSION_NAME}".also { tvVersionInfo().text = it }

        setupVouchersObserver()
    }

    /**
     * Retrieve all vouchers list from DB
     *
     * If voucher count only 1 then move to plate reg and pass current voucher
     */
    private fun setupVouchersObserver() {
        viewModel.getAllVouchers().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        if (resource.data!!.size == 1) {
                            tvGreetingsMsg().setOnClickListener(
                                tvGreetingsMsgClickListener(resource.data[0])
                            )
                        }
                        else
                        {
                            tvGreetingsMsg().setOnClickListener(
                                tvGreetingsMsgClickListener(null)
                            )
                        }
                    }
                    else -> {
                        tvGreetingsMsg().setOnClickListener(
                            tvGreetingsMsgClickListener(null)
                        )
                    }
                }
            }
        })
    }

}