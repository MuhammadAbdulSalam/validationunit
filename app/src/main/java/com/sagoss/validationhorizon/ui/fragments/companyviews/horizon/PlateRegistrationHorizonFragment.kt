package com.sagoss.validationhorizon.ui.fragments.companyviews.horizon


import androidx.navigation.fragment.navArgs
import com.sagoss.validationhorizon.databinding.FragmentHorizonPlateRegistrationBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.EnterPlateBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlateRegistrationHorizonFragment : EnterPlateBaseFragment<FragmentHorizonPlateRegistrationBinding>()  {
    private val args: PlateRegistrationHorizonFragmentArgs by navArgs()

    override fun getViewBinding()       = FragmentHorizonPlateRegistrationBinding.inflate(layoutInflater)
    override fun tvPlateTextView()      = binding.tvPlateNo
    override fun getToolbar()           = binding.toolbar
    override fun validateButton()       = binding.btnValidate
    override fun currentVoucher()       = args.voucher
}