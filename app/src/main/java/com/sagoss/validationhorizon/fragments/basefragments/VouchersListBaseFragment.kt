package com.sagoss.validationhorizon.fragments.basefragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.google.android.material.appbar.MaterialToolbar
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.fragments.companyviews.horizon.NoConfigHorizonFragmentDirections
import com.sagoss.validationhorizon.recycleradapter.VoucherRecyclerAdapter
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel

abstract class VouchersListBaseFragment<VBinding : ViewBinding> : Fragment() {

    protected lateinit var binding: VBinding
    protected abstract fun getViewBinding(): VBinding
    protected abstract fun getRecycler(): RecyclerView
    protected abstract fun getRecyclerDirection(voucher: Voucher): NavDirections
    protected abstract fun getRecyclerItemColor(): Int
    protected abstract fun getToolbar(): MaterialToolbar

    protected val viewModel: MainViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VoucherRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getToolbar().setNavigationOnClickListener { findNavController().navigateUp() }

        recyclerView = getRecycler()
        adapter = VoucherRecyclerAdapter(getRecyclerItemColor(), this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false)

        setupVouchersObserver()
    }

    /**
     * @param authToken authorisation Token as Header
     *
     * Retrieve Config data
     */
    private fun setupVouchersObserver() {
        viewModel.getAllVouchers().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        adapter.submitList(resource.data)
                        adapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> { }
                    Status.LOADING -> { }
                }
            }
        })
    }

    /**
     * Direction from voucher recycler item selected
     */
    fun onRecyclerClick(voucher: Voucher){
        findNavController().navigate(getRecyclerDirection(voucher))
    }

}