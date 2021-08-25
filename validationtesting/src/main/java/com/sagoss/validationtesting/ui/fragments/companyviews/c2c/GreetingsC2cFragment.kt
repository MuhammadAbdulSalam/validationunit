/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.ui.fragments.companyviews.c2c

import android.view.View
import androidx.navigation.fragment.findNavController
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.databinding.FragmentC2cGreetingsBinding
import com.sagoss.validationtesting.ui.fragments.basefragments.GreetingsBaseFragment
import com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia.GreetingsGaFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GreetingsC2cFragment : GreetingsBaseFragment<FragmentC2cGreetingsBinding>() {

    override fun getViewBinding()               = FragmentC2cGreetingsBinding.inflate(layoutInflater)
    override fun tvGreetingsMsg()               = binding.tvWelcomeMsg
    override fun tvVersionInfo()                = binding.tvAppVersion


    override fun tvGreetingsMsgClickListener(voucherToSend: Voucher?) = View.OnClickListener {
        if(voucherToSend == null)
        {
            findNavController().navigate(
                GreetingsC2cFragmentDirections
                    .actionFragmentGreetingsC2cToFragmentVouchersC2c()
            )
        }
        else
        {
            findNavController().navigate(
                GreetingsC2cFragmentDirections
                    .actionFragmentGreetingsC2cToFragmentPlateRegistrationC2c(voucherToSend))
        }
    }

}