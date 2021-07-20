package com.sagoss.validationhorizon.fragments.basefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.sagoss.validationhorizon.viewmodel.MainViewModel


abstract class BaseFragment<VBinding : ViewBinding> : Fragment() {

    val viewModel: MainViewModel by viewModels()
    protected lateinit var binding: VBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    protected abstract fun getViewBinding(): VBinding

    open fun setUpViews() {}



}