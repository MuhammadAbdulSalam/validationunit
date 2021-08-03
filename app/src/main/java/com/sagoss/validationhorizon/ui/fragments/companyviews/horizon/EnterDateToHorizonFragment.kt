package com.sagoss.validationhorizon.ui.fragments.companyviews.horizon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.navArgs
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.databinding.FragmentHorizonEnterDateToBinding
import com.sagoss.validationhorizon.databinding.FragmentHorizonPlateRegistrationBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.EnterDateToBaseFragment
import com.sagoss.validationhorizon.ui.fragments.basefragments.EnterPlateBaseFragment

class EnterDateToHorizonFragment : EnterDateToBaseFragment<FragmentHorizonEnterDateToBinding>() {
    private val args: EnterDateToHorizonFragmentArgs by navArgs()

    override fun getViewBinding()            = FragmentHorizonEnterDateToBinding.inflate(layoutInflater)
    override fun getToolbar()                = binding.toolbar
    override fun btnAdd()                    = binding.btnAdd
    override fun btnSubtract()               = binding.btnSubtract
    override fun btnConfirm()                = binding.btnConfirm
    override fun currentVoucher()            = args.voucher
    override fun plate()                     = args.plateNumber
    override fun durationTextView()          = binding.durationField
    override fun expiryTextView()            = binding.ExitBeforeField
}

