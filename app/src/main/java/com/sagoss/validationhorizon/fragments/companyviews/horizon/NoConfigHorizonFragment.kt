package com.sagoss.validationhorizon.fragments.companyviews.horizon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.databinding.FragmentGreetingsHorizonBinding
import com.sagoss.validationhorizon.databinding.FragmentNoConfigHorizonBinding
import com.sagoss.validationhorizon.fragments.basefragments.BaseFragment
import com.sagoss.validationhorizon.fragments.basefragments.NoConfigBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoConfigHorizonFragment : NoConfigBaseFragment<FragmentNoConfigHorizonBinding>()  {
        override fun getViewBinding() = FragmentNoConfigHorizonBinding.inflate(layoutInflater)
        override fun tvDeviceID() = binding.deviceIdText
}