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
import android.app.AlertDialog
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
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.sagoss.validationhorizon.MainActivity
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.InternetConnectionInterface
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel

abstract class NoConfigBaseFragment<VBinding : ViewBinding> : Fragment(), InternetConnectionInterface {

    private val viewModel                       : MainViewModel by viewModels()

    protected lateinit var binding              : VBinding
    private lateinit var runnable               : Runnable
    private lateinit var prefs                  : Prefs
    private lateinit var helperDialog           : AlertDialog

    private var handler                         = Handler(Looper.myLooper()!!)
    private var isRunning                       = false

    protected abstract fun tvDeviceID()         : TextView
    protected abstract fun getViewBinding()     : VBinding
    protected abstract fun getDirection()       : NavDirections

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
    }

    @SuppressLint("HardwareIds")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        prefs = Prefs(requireContext())
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {}
        helperDialog = HelperUtil.getErrorDialog(
            requireContext(), getString(R.string.NO_INTERNET_TITLE),
            getString(R.string.INTERNET_MSG),
            false).create()

        tvDeviceID().text =
            Settings.Secure.getString(requireActivity().contentResolver, Settings.Secure.ANDROID_ID)

        runnable = Runnable {
            isRunning = true
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
        viewModel.getConfig(authToken, requireContext()).observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        handler.removeCallbacks(runnable)
                        findNavController().navigate(getDirection())
                    }
                    Status.ERROR -> {}
                    Status.LOADING -> {}
                }
            }
        })
    }

    /**
     * Start get config runnable to check for config settings
     */
    @Override
    override fun onConnected() {
        helperDialog.dismiss()
        if(HelperUtil.isNetworkAvailable(requireContext())) runnable.run()
    }

    /**
     * Disable config check and show disconnected error message
     */
    @Override
    override fun onDisconnected() {
        if(isRunning) handler.removeCallbacks(runnable)
        isRunning = false
        helperDialog.show()
    }

    @Override
    override fun onStop() {
        super.onStop()
        isRunning = false
        MainActivity.connectionListener = null
        handler.removeCallbacks(runnable)
    }

    @Override
    override fun onResume() {
        super.onResume()
        MainActivity.connectionListener = this
        if(HelperUtil.isNetworkAvailable(requireContext())) runnable.run()
    }

}

