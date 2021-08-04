package com.sagoss.validationhorizon.ui.fragments.basefragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel
import org.w3c.dom.Text


abstract class ValidationResultsBaseFragment<VBinding : ViewBinding> : Fragment() {

    protected val viewModel                                 : MainViewModel by viewModels()
    protected lateinit var binding                          : VBinding
    protected abstract fun getViewBinding()                 : VBinding
    protected abstract fun currentVoucher()                 : Voucher
    protected abstract fun dateTo()                         : String
    protected abstract fun dateFrom()                       : String
    protected abstract fun plateNumber()                    : String
    protected abstract fun successMsg()                     : String
    protected abstract fun plateTextBox()                   : TextView
    protected abstract fun msgTextBox()                     : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVouchersObserver()

    }

    /**
     * @param authToken authorisation Token as Header
     *
     * Validate Number Plate
     */
    private fun setupVouchersObserver() {
        val dateTo = if(dateTo() == "") null else dateTo()
        viewModel.checkVoucher(
            plate = plateNumber(), token = currentVoucher().key, date_from = dateFrom(), date_to = dateTo)
            .observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        if(resource.data!!.valid == "1")
                        {
                            plateTextBox().text = plateNumber()
                            msgTextBox().text = successMsg()
                        }
                    }
                    Status.ERROR -> { }
                    Status.LOADING -> { }
                }
            }
        })
    }
}