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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sagoss.validationhorizon.databinding.FragmentLoginCheckerBinding
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.utils.ThemeUtil
import com.sagoss.validationhorizon.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginCheckerFragment : Fragment() {

    private lateinit var binding            : FragmentLoginCheckerBinding
    private lateinit var prefs              : Prefs
    private val viewModel                   : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        prefs = Prefs(requireContext())
        binding = FragmentLoginCheckerBinding.inflate(inflater, container, false)
        binding.progressbarLayout.visibility = View.VISIBLE

        return binding.root
    }

    @Override
    override fun onResume() {
        super.onResume()
        checkUserRegistration()
    }

    /**
     * Check user registration
     * Move to fragment according to registration status and network connection
     */
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
            else { setupGetConfigObserver(HelperUtil.getTokenFormat(prefs.accessToken))}
        }
    }

    /**
     * @param authToken authorisation Token as Header
     *
     * Retrieve Config data
     * On success start background worker
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

    /**
     * Check initial direction for greetings page
     * Rest direction will be followed accordingly
     */
    private fun enterGreetingsFrag(){
        findNavController().navigate(ThemeUtil.getInitialGreetingsDirection(prefs.companyId!!))
    }

    /**
     * Move to no config fragment according to company ID
     * Check initial direction for No config page
     * Rest direction will be followed accordingly
     */
    private fun enterNoConfigFrag(){
        findNavController().navigate(ThemeUtil.getInitialNoConfigDirections(prefs.companyId!!))
    }
}