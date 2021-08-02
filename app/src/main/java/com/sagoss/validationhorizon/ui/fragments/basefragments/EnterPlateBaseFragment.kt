package com.sagoss.validationhorizon.ui.fragments.basefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.ui.dialogs.DialogDateTo
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.Prefs
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel


abstract class EnterPlateBaseFragment<VBinding : ViewBinding> : Fragment() {

    protected val viewModel: MainViewModel by viewModels()

    private lateinit var prefs: Prefs
    protected lateinit var binding: VBinding

    protected abstract fun getViewBinding(): VBinding
    protected abstract fun tvPlateTextView(): TextView
    protected abstract fun getToolbar(): MaterialToolbar
    protected abstract fun validateButton(): MaterialButton
    protected abstract fun currentVoucher(): Voucher

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = Prefs(requireContext())
        getToolbar().setNavigationOnClickListener { findNavController().navigateUp() }
        validateButton().setOnClickListener { validateNumberPlate() }
    }

    /**
     * Validate Number Plate
     *
     * Check with API if number plate is valid or not Using Api Two
     */
    private fun validateNumberPlate() {
        val plate = tvPlateTextView().text?.toString()
        val token = currentVoucher().key

        viewModel.checkDateIn(plate!!, token, "1").observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> onCheckDateInSuccess(resource.data!!.valid)
                    Status.ERROR -> { TODO() }
                    Status.LOADING -> { }
                }
            }
        })
    }

    /**
     * check if numberplate valid
     *
     * Ask for durations according to voucher duration types
     */
    private fun onCheckDateInSuccess(valid: String) {
        val dateFrom = HelperUtil.getCurrentDateTimeString("YYYY-MM-dd HH:mm:ss")
        if(currentVoucher().dateFrom) { askForDuration() }
        else
        {
            prefs.date_from = dateFrom
            askForDateTo()
        }
    }

    private fun askForDateTo(){
        val dialogDateTo = DialogDateTo(requireContext())
        dialogDateTo.show()

    }

    private fun askForDuration(){

    }

}