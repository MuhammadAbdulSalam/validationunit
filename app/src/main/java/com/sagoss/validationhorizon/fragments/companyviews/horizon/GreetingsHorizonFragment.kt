package com.sagoss.validationhorizon.fragments.companyviews.horizon

import com.sagoss.validationhorizon.databinding.FragmentGreetingsHorizonBinding
import com.sagoss.validationhorizon.fragments.basefragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GreetingsHorizonFragment :  BaseFragment<FragmentGreetingsHorizonBinding>() {

    override fun getViewBinding() = FragmentGreetingsHorizonBinding.inflate(layoutInflater)
}