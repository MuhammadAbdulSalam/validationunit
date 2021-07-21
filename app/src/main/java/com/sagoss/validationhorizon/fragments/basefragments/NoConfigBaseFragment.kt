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
import com.sagoss.validationhorizon.fragments.companyviews.horizon.NoConfigHorizonFragmentDirections
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel

abstract class NoConfigBaseFragment<VBinding : ViewBinding> : Fragment() {

    protected val viewModel: MainViewModel by viewModels()
    protected lateinit var binding: VBinding
    protected abstract fun tvDeviceID(): TextView
    protected abstract fun getViewBinding(): VBinding
    private var handler = Handler(Looper.myLooper()!!)
    private lateinit var runnable: Runnable

    private lateinit var prefs: Prefs


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
            handler.postDelayed(runnable, 10000)
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
                                .actionFragmentNoConfigHorizonToFragmentGreetingsHorizon(""))
                    }
                    Status.ERROR -> {}
                    Status.LOADING -> {}
                }
            }
        })
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        runnable.run()
    }

}

