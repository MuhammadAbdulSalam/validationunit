package com.sagoss.validationhorizon.fragments.basefragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.viewmodel.MainViewModel


abstract class GreetingsBaseFragment<VBinding : ViewBinding> : Fragment() {

    protected lateinit var binding: VBinding
    protected abstract fun getViewBinding(): VBinding
    protected abstract fun tvGreetingsMsg(): TextView
    protected abstract fun tvGreetingsMsgClickListener() : View.OnClickListener


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {}

        tvGreetingsMsg().text =
            "Welcome to\n ${Prefs(requireContext()).locationName}\n Press here to begin"
        tvGreetingsMsg().setOnClickListener(tvGreetingsMsgClickListener())
    }


}