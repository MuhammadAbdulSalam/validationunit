package com.sagoss.validationhorizon.ui.fragments.basefragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.button.MaterialButton
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.utils.Prefs
import java.text.SimpleDateFormat
import java.util.*

abstract class EntryTimeBaseFragment<VBinding : ViewBinding> : Fragment() {

    protected lateinit var binding              : VBinding
    private lateinit var prefs                  : Prefs

    protected abstract fun getViewBinding()     : VBinding
    protected abstract fun datePicker()         : DatePicker
    protected abstract fun timePicker()         : TimePicker
    protected abstract fun btnValidate()        : MaterialButton
    protected abstract fun currentVoucher()         : Voucher
    protected abstract fun plate()              : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    @SuppressLint("SimpleDateFormat", "NewApi", "WeekBasedYear")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = Prefs(requireContext())

        btnValidate().setOnClickListener{
            val calendar = Calendar.getInstance()
            calendar.set(
                datePicker().year,
                datePicker().month,
                datePicker().dayOfMonth,
                timePicker().hour,
                timePicker().minute)
            val chosenDateAndTime = SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(calendar.time)
            prefs.date_from = chosenDateAndTime
            askDateTo()
        }
    }

    private fun askDateTo(){
        if(currentVoucher().dateTo)
        {
            if(!currentVoucher().dateToFixed.isNullOrEmpty()){
                if(currentVoucher().dateToFixed!!.size > 1)
                {
                    //TODO hotel activity
                }
                else if(currentVoucher().dateToFixed!!.size == 1)
                {
                    //TODO validate
                }
            }
            else {

                if(!currentVoucher().dateToUnit.isNullOrEmpty()){
                    //TODO ask for date to fragment
                }
            }


        }
        else
        {
              // TODO Validate
        }
    }

}