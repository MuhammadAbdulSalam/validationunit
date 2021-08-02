package com.sagoss.validationhorizon.ui.fragments.companyviews.horizon

import com.sagoss.validationhorizon.databinding.FragmentHorizonNoConfigBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.NoConfigBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoConfigHorizonFragment : NoConfigBaseFragment<FragmentHorizonNoConfigBinding>()  {
        override fun getViewBinding() = FragmentHorizonNoConfigBinding.inflate(layoutInflater)
        override fun tvDeviceID() = binding.deviceIdText
}