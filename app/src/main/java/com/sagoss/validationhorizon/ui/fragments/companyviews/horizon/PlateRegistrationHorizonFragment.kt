package com.sagoss.validationhorizon.ui.fragments.companyviews.horizon


import androidx.navigation.fragment.navArgs
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

    override fun enterEntryDateFrag()   = PlateRegistrationHorizonFragmentDirections
                                        .actionFragmentPlateRegistrationHorizonToFragmentEntryTimeHorizon(
                                            voucher        = currentVoucher(),
                                            plateNumber    = tvPlateTextView().text.toString())

    override fun enterHotelFrag()       = PlateRegistrationHorizonFragmentDirections
                                        .actionFragmentPlateRegistrationHorizonToFragmentHorizonHotel(
                                            voucher        = currentVoucher(),
                                            plateNumber    = tvPlateTextView().text.toString())

    override fun enterValidationFrag(dateTo: String, dateFrom: String)
                                        = PlateRegistrationHorizonFragmentDirections
                                        .actionFragmentPlateRegistrationHorizonToFragmentHorizonValidation(
                                            voucher         = args.voucher,
                                            plateNumber     = binding.tvPlateNo.text.toString(),
                                            dateTo          = dateTo,
                                            dateFrom        = dateFrom)
}