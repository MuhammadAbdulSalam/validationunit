/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.fragments.companyviews.horizon

import com.sagoss.validationhorizon.databinding.FragmentHorizonNoConfigBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.NoConfigBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoConfigHorizonFragment : NoConfigBaseFragment<FragmentHorizonNoConfigBinding>()  {

    override fun getViewBinding()           = FragmentHorizonNoConfigBinding.inflate(layoutInflater)
    override fun tvDeviceID()               = binding.deviceIdText

    override fun getDirection()             = NoConfigHorizonFragmentDirections
                                            .actionFragmentNoConfigHorizonToFragmentGreetingsHorizon()
}