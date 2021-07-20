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
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginCheckerFragment : Fragment() {

    private lateinit var binding: FragmentLoginCheckerBinding
    private lateinit var prefs: Prefs

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
        if (prefs.accessToken == "") {
           findNavController()
                .navigate(LoginCheckerFragmentDirections.actionLoginCheckerToFragmentRegistration())
        }
        else
        {
          findNavController()
                .navigate(LoginCheckerFragmentDirections.actionFragmentLoginCheckerToFragmentNoConfigHorizon())
        }
    }
}