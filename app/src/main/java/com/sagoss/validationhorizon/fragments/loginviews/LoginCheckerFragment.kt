package com.sagoss.validationhorizon.fragments.loginviews

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.databinding.FragmentLoginCheckerBinding
import com.sagoss.validationhorizon.fragments.companyviews.horizon.NoConfigHorizonFragmentDirections
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginCheckerFragment : Fragment() {

    private lateinit var binding: FragmentLoginCheckerBinding
    private lateinit var prefs: Prefs
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        prefs = Prefs(requireContext())
        binding = FragmentLoginCheckerBinding.inflate(inflater, container, false)

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
                .navigate(LoginCheckerFragmentDirections.actionLoginCheckerToFragmentRegistration())
        }
        else {
            setupGetConfigObserver("Bearer ${prefs.accessToken}")
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
                        findNavController().navigate(
                            LoginCheckerFragmentDirections
                                .actionFragmentLoginCheckerToFragmentGreetingsHorizon()
                        )
                    }
                    Status.ERROR -> {
                        findNavController()
                            .navigate(LoginCheckerFragmentDirections.actionFragmentLoginCheckerToFragmentNoConfigHorizon())
                    }
                    Status.LOADING -> {
                        binding.progressbarLayout.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}