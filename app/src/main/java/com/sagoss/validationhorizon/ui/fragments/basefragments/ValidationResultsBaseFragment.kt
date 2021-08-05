package com.sagoss.validationhorizon.ui.fragments.basefragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.utils.Constants
import com.sagoss.validationhorizon.utils.Status
import com.sagoss.validationhorizon.viewmodel.MainViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.schedule


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
    protected abstract fun enterHomeFrag()                  : NavDirections
    private var timer                                       = Timer("schedule", true)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {}
        setupVouchersObserver()
        goToGreetings()
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
                    Status.SUCCESS ->
                        when(resource.data!!.valid) {
                            Constants.MATCH_REDEEMED-> successView()
                            Constants.NOT_APPLICABLE,
                            Constants.NO_MATCH-> errorView()
                        }
                    Status.ERROR -> errorView()
                    Status.LOADING -> loadingView()
                }
            }
        })
    }

    private fun successView(){
        plateTextBox().text = plateNumber()
        msgTextBox().text = successMsg()
    }
    private fun errorView(){

    }

    private fun loadingView(){

    }

    private fun goToGreetings(){
        timer.schedule(10000L) {
            activity?.runOnUiThread{ findNavController().navigate(enterHomeFrag()) }
            timer.cancel()
        }
    }
}