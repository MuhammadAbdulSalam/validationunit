package com.sagoss.validationhorizon.fragments.companyviews.horizon

import com.sagoss.validationhorizon.databinding.FragmentGreetingsHorizonBinding
import com.sagoss.validationhorizon.fragments.basefragments.BaseFragment

class HorizonFragment :  BaseFragment<FragmentGreetingsHorizonBinding>() {

    val fragmentBinding = FragmentGreetingsHorizonBinding.inflate(layoutInflater)
    override fun getViewBinding() = binding

    fun something(){}
}