/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.fragments.basefragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.sagoss.validationhorizon.ui.fragments.companyviews.horizon.NoConfigHorizonFragmentDirections
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel

abstract class NoConfigBaseFragment<VBinding : ViewBinding> : Fragment() {

    protected val viewModel                     : MainViewModel by viewModels()
    protected lateinit var binding              : VBinding
    private lateinit var runnable               : Runnable
    private lateinit var prefs                  : Prefs
    private var handler                         = Handler(Looper.myLooper()!!)

    protected abstract fun tvDeviceID()         : TextView
    protected abstract fun getViewBinding()     : VBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
    }

    @SuppressLint("HardwareIds")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        prefs = Prefs(requireContext())
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {}

        tvDeviceID().text =
            Settings.Secure.getString(requireActivity().contentResolver, Settings.Secure.ANDROID_ID)
        runnable = Runnable {
            setupGetConfigObserver("Bearer ${prefs.accessToken.toString()}")
            handler.postDelayed(runnable, 60000)
        }

        return binding.root
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
                        handler.removeCallbacks(runnable)
                        findNavController().navigate(
                            NoConfigHorizonFragmentDirections
                                .actionFragmentNoConfigHorizonToFragmentGreetingsHorizon())
                    }
                    Status.ERROR -> {}
                    Status.LOADING -> {}
                }
            }
        })
    }

    @Override
    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(runnable)
    }

    @Override
    override fun onResume() {
        super.onResume()
        runnable.run()
    }

}

