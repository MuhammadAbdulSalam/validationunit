/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.fragments.loginviews

import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sagoss.validationhorizon.MainActivity
import com.sagoss.validationhorizon.databinding.FragmentLoginCheckerBinding
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.InternetConnectionInterface
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginCheckerFragment : Fragment() {

    private lateinit var binding            : FragmentLoginCheckerBinding
    private lateinit var prefs              : Prefs
    private val viewModel                   : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        prefs = Prefs(requireContext())
        binding = FragmentLoginCheckerBinding.inflate(inflater, container, false)
        binding.progressbarLayout.visibility = View.VISIBLE

        val appId = Settings.Secure.getString(requireActivity().contentResolver, Settings.Secure.ANDROID_ID)
        Log.d("APP ID:" , "-------> $appId")

        return binding.root
    }

    @Override
    override fun onResume() {
        super.onResume()
        checkUserRegistration()
    }

    private fun checkUserRegistration() {
        if (prefs.accessToken.isEmpty()) {
            findNavController()
                .navigate(LoginCheckerFragmentDirections
                    .actionLoginCheckerToFragmentRegistration())
        }
        else {
            if(!HelperUtil.isNetworkAvailable(requireContext()))
            {
                binding.progressbarLayout.visibility = View.INVISIBLE
                if(prefs.config) enterGreetingsFrag() else enterNoConfigFrag()
            }
            else { setupGetConfigObserver("Bearer ${prefs.accessToken}") }
        }
    }

    /**
     * @param authToken authorisation Token as Header
     *
     * Retrieve Config data
     */
    private fun setupGetConfigObserver(authToken: String) {
        viewModel.getConfig(authToken).observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        prefs.config = true
                        binding.progressbarLayout.visibility = View.INVISIBLE
                        enterGreetingsFrag()
                    }
                    Status.ERROR -> {
                        binding.progressbarLayout.visibility = View.INVISIBLE
                        enterNoConfigFrag()
                    }
                    Status.LOADING -> { }
                }
            }
        })
    }

    private fun enterGreetingsFrag(){
        findNavController().navigate(
            LoginCheckerFragmentDirections
                .actionFragmentLoginCheckerToFragmentGreetingsHorizon()
        )
    }

    private fun enterNoConfigFrag(){
        findNavController()
            .navigate(LoginCheckerFragmentDirections.
            actionFragmentLoginCheckerToFragmentNoConfigHorizon())
    }
}