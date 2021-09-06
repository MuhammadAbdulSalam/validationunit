/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.ui.fragments.companyviews.c2c

import com.sagoss.validationtesting.databinding.FragmentC2cNoConfigBinding
import com.sagoss.validationtesting.ui.fragments.basefragments.NoConfigBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoConfigC2cFragment : NoConfigBaseFragment<FragmentC2cNoConfigBinding>()  {

    override fun getViewBinding()           = FragmentC2cNoConfigBinding.inflate(layoutInflater)
    override fun tvDeviceID()               = binding.deviceIdText

    override fun getDirection()             = NoConfigC2cFragmentDirections
                                             .actionFragmentNoConfigC2cToFragmentGreetingsC2c()
}