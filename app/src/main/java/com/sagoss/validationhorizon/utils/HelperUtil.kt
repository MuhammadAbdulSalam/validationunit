/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.utils

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.NavDirections
import com.sagoss.validationhorizon.ui.fragments.loginviews.LoginCheckerFragmentDirections
import java.text.SimpleDateFormat
import java.util.*


object HelperUtil {

    /**
     * @param context current activity
     * @param title title of alert dialog
     * @param msg message to show on dialog
     * @param buttons show buttons or no
     *
     * @return alert dialog for different error messages
     */
    fun getErrorDialog(context: Context, title: String, msg: String, buttons: Boolean): AlertDialog.Builder{

        return when(buttons)
        {
            false ->AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setCancelable(false)
            else-> AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Ok") { dialog, _ -> dialog.dismiss() }
                .setCancelable(false)
        }
    }

    fun getTokenFormat(accessToken:String): String{
        return "Bearer $accessToken"
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetwork
        return activeNetworkInfo != null
    }

    /**
     * @param format format of date time eg YY:MM:DD hh:mm:ss
     *
     * @return string of current date time
     */
    fun getCurrentDateTimeString(format : String): String {
        val current = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat(format, Locale.UK)
        return dateFormat.format(current)
    }


    fun getDateByString(dateString : String, format : String) : Date{
        val dateFormat = SimpleDateFormat(format, Locale.UK)
        return dateFormat.parse(dateString)
    }

    private fun getDayOfMonthSuffix(date: Date): String {
        val dayFormat: SimpleDateFormat = SimpleDateFormat("dd",  Locale.UK)
        val day = dayFormat.format(date).toInt()
        if (day in 11..13) {
            return "th"
        }
        return when (day % 10) {
            1 -> "st"
            2 -> "nd"
            3 -> "rd"
            else -> "th"
        }
    }

    fun getFormattedDate(date : Date):String{
        val dayNumberSuffix = HelperUtil.getDayOfMonthSuffix(date)
        val dateFormat = SimpleDateFormat("EEE dd'$dayNumberSuffix' MMM HH:mm",  Locale.UK)
        return dateFormat.format(date).uppercase(Locale.getDefault())

    }

    private fun getMillisecondsByDate(dateString : String, format : String) : Long{

        val dateFormat = SimpleDateFormat(format, Locale.UK)
        val date = dateFormat.parse(dateString)
        return date.time
    }

    private fun getDateTimeString(dateMillis : Long, format : String ) : String{
        val dateFormat = SimpleDateFormat(format, Locale.UK)
        return dateFormat.format(dateMillis)
    }

    fun getDateTo(durationInMinutes: Int, dateFrom: String): String {
        val dateFromInMillisec =getMillisecondsByDate(
            dateFrom,
            "yyyy-MM-dd HH:mm:ss")
        val durationInMillisec: Long = durationInMinutes * 60000L
        val dateToinMillisec = dateFromInMillisec + durationInMillisec
        return getDateTimeString(dateToinMillisec, "yyyy-MM-dd HH:mm:ss")
    }
}