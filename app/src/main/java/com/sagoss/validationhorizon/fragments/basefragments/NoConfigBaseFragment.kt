package com.sagoss.validationhorizon.fragments.basefragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel

abstract class NoConfigBaseFragment<VBinding : ViewBinding> : Fragment() {

    val viewModel: MainViewModel by viewModels()
    protected lateinit var binding: VBinding
    protected abstract fun tvDeviceID(): TextView
    protected abstract fun getViewBinding(): VBinding
    lateinit var prefs: Prefs


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

        setupGetConfigObserver("Bearer ${prefs.accessToken.toString()}")

        return binding.root
    }

    /**
     * @param authToken authorisation Token as Header
     *
     * Synchronised Api call response.
     */
    private fun setupGetConfigObserver(authToken: String) {

        viewModel.getConfig(authToken).observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {

                    }
                    Status.LOADING -> {

                    }
                }
            }
        })
    }

}

