/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.fragments.companyviews.greateranglia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.databinding.FragmentGaNoConfigBinding
import com.sagoss.validationhorizon.databinding.FragmentHorizonNoConfigBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.NoConfigBaseFragment
import com.sagoss.validationhorizon.ui.fragments.companyviews.horizon.NoConfigHorizonFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoConfigGaFragment : NoConfigBaseFragment<FragmentGaNoConfigBinding>()  {

    override fun getViewBinding()           = FragmentGaNoConfigBinding.inflate(layoutInflater)
    override fun tvDeviceID()               = binding.deviceIdText

    override fun getDirection()             = NoConfigGaFragmentDirections
                                            .actionFragmentNoConfigGaToFragmentGreetingsGa()
}