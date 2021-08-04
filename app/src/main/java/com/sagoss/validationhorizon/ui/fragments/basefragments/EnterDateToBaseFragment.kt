package com.sagoss.validationhorizon.ui.fragments.basefragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.Prefs
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SetTextI18n")
abstract class EnterDateToBaseFragment<VBinding : ViewBinding> : Fragment() {

    protected lateinit var binding              : VBinding
    private lateinit var prefs                  : Prefs
    private var dateToUnit                      = ""
    private var chosenDateAndTime               = ""
    private val calendar                        = Calendar.getInstance()
    private var incrementUnit                   = Calendar.DATE
    private var incrementUnitName               = "DAY"
    private var incrementAmount                 = 1
    private var initialAmount                   = 1
    private var minutesPerIncrement             = 1
    private var limit                           = 0
    private var plate                           = ""

    protected abstract fun getViewBinding()     : VBinding
    protected abstract fun getToolbar()         : MaterialToolbar
    protected abstract fun btnAdd()             : MaterialButton
    protected abstract fun btnSubtract()        : MaterialButton
    protected abstract fun btnConfirm()         : MaterialButton
    protected abstract fun durationTextView()   : TextView
    protected abstract fun expiryTextView()     : TextView
    protected abstract fun currentVoucher()     : Voucher
    protected abstract fun plate()              : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getToolbar().setNavigationOnClickListener { findNavController().navigateUp() }
        prefs = Prefs(requireContext())
        calendar.time = HelperUtil.getDateByString(prefs.date_from!!, "yyyy-MM-dd HH:mm:ss")
        dateToUnit = currentVoucher().dateToUnit!!
        limit = currentVoucher().dateToLimit!!
        plate = plate()

        setIncrementUnitAndValue()
        expiryTextView().text = prefs.date_from
        val initialDateTo = adjustDateAndTime(incrementUnit, incrementAmount)
        expiryTextView().text = HelperUtil.getFormattedDate(initialDateTo)
        var amount = initialAmount

        btnAdd().setOnClickListener {
            if (limit == 0 || (amount + incrementAmount) * minutesPerIncrement <= limit) {
                val adjustedDate = adjustDateAndTime(incrementUnit, incrementAmount)
                expiryTextView().text = HelperUtil.getFormattedDate(adjustedDate)
                amount += incrementAmount
                val unitName  = if(amount == 1 && incrementUnitName == "DAYS") "DAY" else incrementUnitName
                durationTextView().text = "$amount $unitName"
            } else {
                HelperUtil.getErrorDialog(requireContext(), getString(R.string.LIMIT_EXCEED),
                    getString(R.string.DURATION_LIMIT_MSG) + "$amount $incrementUnitName",
                    true
                )
            }
        }

        btnSubtract().setOnClickListener {
            if (amount > initialAmount) {
                val adjustedDate = adjustDateAndTime(incrementUnit, -incrementAmount)
                expiryTextView().text = HelperUtil.getFormattedDate(adjustedDate)
                amount -= incrementAmount
                val unitName  = if(amount == 1 && incrementUnitName == "DAYS") "DAY" else incrementUnitName
                durationTextView().text = "$amount $unitName"
            } else {
                HelperUtil.getErrorDialog(
                    requireContext(),
                    "Limit Error",
                    "The duration of your stay must be at least $amount $incrementUnitName",
                    true
                )
            }
        }
    }

    /**
     * @param unit units to use for increment
     * @param increment amount of increment
     * @param initial initial value to be shown
     * @param unitName name of unit eg minutes, hours etc
     * @param perIncremental if in minutes
     *
     * Adjust incremental counter for add and subtract buttons
     */
    private fun updateCalendar(unit: Int, increment: Int, initial: Int, unitName: String, perIncremental: Int?
    ) {
        incrementUnit = unit
        incrementAmount = increment
        initialAmount = initial
        incrementUnitName = if(initialAmount == 1 && unitName == "DAYS") "DAY" else unitName
        if (perIncremental != null) { minutesPerIncrement = perIncremental }
        durationTextView().text = "$initialAmount  $incrementUnitName"
        incrementUnitName = unitName
    }


    /**
     * Set incremental value based on voucher unit
     */
    private fun setIncrementUnitAndValue() {
        when (dateToUnit) {
            "DAILY" -> updateCalendar(Calendar.DATE, 1, 1, "DAYS", 1440)
            "HOURLY" -> updateCalendar(Calendar.HOUR, 1, 1, "HOURS", 60)
            "10MIN" -> updateCalendar(Calendar.MINUTE, 10, 10, "MINUTES", null)
            "15MIN" -> updateCalendar(Calendar.MINUTE, 15, 15, "MINUTES", null)
            "20MIN" -> updateCalendar(Calendar.MINUTE, 20, 20, "MINUTES", null)
            "30MIN" -> updateCalendar(Calendar.MINUTE, 30, 30, "MINUTES", null)
        }
    }


    /**
     * @param field field of date to be formatted eg day, month
     * @param amount incremental amount
     *
     * @return formatted date
     */
    @SuppressLint("NewApi", "WeekBasedYear")
    private fun adjustDateAndTime(field: Int, amount: Int): Date {
        calendar.add(field, amount)
        val adjustedDate = calendar.time
        val dateFormat = SimpleDateFormat("YYYY-MM-dd HH:mm:ss", Locale.UK)
        chosenDateAndTime = dateFormat.format(adjustedDate)
        return adjustedDate
    }

}