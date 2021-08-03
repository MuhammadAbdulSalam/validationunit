package com.sagoss.validationhorizon.ui.fragments.companyviews.horizon


import androidx.navigation.NavDirections
import androidx.navigation.fragment.navArgs
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.sagoss.validationhorizon.R
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
    override fun defaultColor()         = R.color.horizon_primary
    override fun progressbar()          = binding.progressbarValidate
    override fun enterDateToFrag()      = PlateRegistrationHorizonFragmentDirections
                                         .actionFragmentPlateRegistrationHorizonToFragmentEnterDateToHorizon(
                                             voucher        = currentVoucher(),
                                             plateNumber    = tvPlateTextView().text.toString())

    override fun enterEntryDateFrag(): NavDirections {
        TODO("Not yet implemented")
    }
}