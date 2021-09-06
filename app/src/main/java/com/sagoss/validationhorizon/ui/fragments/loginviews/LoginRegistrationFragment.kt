/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.fragments.loginviews

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sagoss.validationhorizon.BuildConfig
import com.sagoss.validationhorizon.MainActivity
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import com.sagoss.validationhorizon.databinding.FragmentLoginRegistrationBinding
import com.sagoss.validationhorizon.utils.*
import com.sagoss.validationhorizon.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("HardwareIds")
class LoginRegistrationFragment : Fragment(), InternetConnectionInterface {

    private lateinit var binding        : FragmentLoginRegistrationBinding
    private lateinit var prefs          : Prefs
    private lateinit var helperDialog   : AlertDialog
    private val viewModel               : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        prefs = Prefs(requireContext())
        binding = FragmentLoginRegistrationBinding.inflate(inflater, container, false)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {}
        "Version: ${BuildConfig.VERSION_NAME}".also { binding.tvAppVersion.text = it }
        helperDialog = HelperUtil.getErrorDialog(
            requireContext(), getString(R.string.NO_INTERNET_TITLE),
            getString(R.string.INTERNET_MSG),
            false
        ).create()

        binding.registerButton.setOnClickListener {
            val registrationRequest = RegistrationRequest(
                username = binding.registrationUsernameEditText.text.toString(),
                password = binding.registrationPasswordEditText.text.toString(),
                app_id = Constants.APP_ID,
                mobile_id = Settings.Secure.getString(requireActivity().contentResolver,
                    Settings.Secure.ANDROID_ID),
                version = Constants.VERSION
            )
            if(HelperUtil.isNetworkAvailable(requireContext()))setupRegistrationObserver(registrationRequest)
        }
        return binding.root
    }

    /**
     * @param registrationRequest registration request body
     *
     * Retrieve Registration Data
     */
    private fun setupRegistrationObserver(registrationRequest: RegistrationRequest) {
        viewModel.getRegistration(registrationRequest, requireContext()).observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.progressCircular.visibility = View.INVISIBLE
                        findNavController().popBackStack()
                    }
                    Status.ERROR -> {
                        binding.progressCircular.visibility = View.INVISIBLE
                        HelperUtil.getErrorDialog(requireContext(), "Something Went Wrong",
                            resource.message.toString(), true).create().show()
                    }
                    Status.LOADING -> {
                        binding.progressCircular.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    /**
     * Show no internet dialog on network disconnected
     */
    @Override
    override fun onDisconnected() {
        helperDialog.show()
    }

    /**
     * hide no internet dialog on network disconnected
     */
    @Override
    override fun onConnected() {
        helperDialog.dismiss()
    }

    @Override
    override fun onResume() {
        super.onResume()
        MainActivity.connectionListener = this
    }

    @Override
    override fun onStop() {
        super.onStop()
        MainActivity.connectionListener = null
    }
}