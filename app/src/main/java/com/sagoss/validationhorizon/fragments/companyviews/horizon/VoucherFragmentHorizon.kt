package com.sagoss.validationhorizon.fragments.companyviews.horizon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.databinding.FragmentHorizonPlateRegistrationBinding
import com.sagoss.validationhorizon.databinding.FragmentHorizonVoucherBinding
import com.sagoss.validationhorizon.fragments.basefragments.EnterPlateBaseFragment
import com.sagoss.validationhorizon.fragments.basefragments.VouchersListBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VoucherFragmentHorizon : VouchersListBaseFragment<FragmentHorizonVoucherBinding>() {
    override fun getViewBinding(): FragmentHorizonVoucherBinding = FragmentHorizonVoucherBinding.inflate(layoutInflater)
    override fun getRecycler(): RecyclerView = binding.recyclerVoucher
    override fun getRecyclerItemColor() = R.color.horizon_primary
    override fun getToolbar(): MaterialToolbar = binding.toolbar
    override fun getRecyclerDirection(voucher: Voucher): NavDirections {
        return VoucherFragmentHorizonDirections.actionFragmentVouchersHorisonToFragmentPlateRegistrationHorizon(voucher)
    }
}