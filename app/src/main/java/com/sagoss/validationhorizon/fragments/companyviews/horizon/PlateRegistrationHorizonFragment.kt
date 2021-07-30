package com.sagoss.validationhorizon.fragments.companyviews.horizon


import android.view.View
import android.widget.TextView
import android.widget.Toolbar
import com.sagoss.validationhorizon.databinding.FragmentHorizonPlateRegistrationBinding
import com.sagoss.validationhorizon.fragments.basefragments.EnterPlateBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlateRegistrationHorizonFragment : EnterPlateBaseFragment<FragmentHorizonPlateRegistrationBinding>()  {
    override fun getViewBinding() = FragmentHorizonPlateRegistrationBinding.inflate(layoutInflater)
    override fun tvPlateTextView() = binding.tvPlateNo
    override fun btnValidateClickListener(arg: String): View.OnClickListener {
            TODO()
    }

    override fun getToolbar()= binding.toolbar


}