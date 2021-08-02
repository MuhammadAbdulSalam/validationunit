package com.sagoss.validationhorizon.ui.fragments.loginviews

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import com.sagoss.validationhorizon.databinding.FragmentLoginRegistrationBinding
import com.sagoss.validationhorizon.utils.Constants
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("HardwareIds")
class LoginRegistrationFragment : Fragment() {

    private lateinit var binding: FragmentLoginRegistrationBinding
    private lateinit var prefs: Prefs
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        prefs = Prefs(requireContext())
        binding = FragmentLoginRegistrationBinding.inflate(inflater, container, false)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {}

        binding.registerButton.setOnClickListener {
            val registrationRequest = RegistrationRequest(
                username = binding.registrationUsernameEditText.text.toString(),
                password = binding.registrationPasswordEditText.text.toString(),
                app_id = Constants.APP_ID,
                mobile_id = Settings.Secure.getString(requireActivity().contentResolver,
                    Settings.Secure.ANDROID_ID),
                version = Constants.VERSION
            )
            setupRegistrationObserver(registrationRequest)
        }
        return binding.root
    }

    /**
     * @param registrationRequest registration request body
     *
     * Retrieve Registration Data
     */
    private fun setupRegistrationObserver(registrationRequest: RegistrationRequest) {
        viewModel.getRegistration(registrationRequest).observe(viewLifecycleOwner, {
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
}