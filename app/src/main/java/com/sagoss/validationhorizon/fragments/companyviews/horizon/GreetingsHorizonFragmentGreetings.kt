package com.sagoss.validationhorizon.fragments.companyviews.horizon

import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.sagoss.validationhorizon.databinding.FragmentHorizonGreetingsBinding
import com.sagoss.validationhorizon.fragments.basefragments.GreetingsBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GreetingsHorizonFragmentGreetings : GreetingsBaseFragment<FragmentHorizonGreetingsBinding>() {

    override fun getViewBinding() = FragmentHorizonGreetingsBinding.inflate(layoutInflater)
    override fun tvGreetingsMsg() = binding.tvWelcomeMsg
    override fun tvGreetingsMsgClickListener() = View.OnClickListener {
            findNavController().navigate(
                GreetingsHorizonFragmentGreetingsDirections
                    .actionFragmentGreetingsHorizonToFragmentVouchersHorizon())
    }

}