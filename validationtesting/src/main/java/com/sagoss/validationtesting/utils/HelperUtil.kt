/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.utils

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
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

    /**
     * @param accessToken
     * @return token in correct format to make api call
     */
    fun getTokenFormat(accessToken:String): String{
        return "Bearer $accessToken"
    }

    /**
     * @return Boolean of current network status as connected true or disconnected false
     */
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

    /**
     * @param dateString date in string
     * @param format format of date required
     *
     * Converts date string to Date.class
     *
     * @return get date from date string
     */
    fun getDateByString(dateString : String, format : String) : Date{
        val dateFormat = SimpleDateFormat(format, Locale.UK)
        return dateFormat.parse(dateString)
    }

    /**
     * @param date date to extract suffix from
     *
     * @return day of month suffix to be added to date string
     */
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

    /**
     * @param date date to be converted to string
     *
     * @return Formatted date as our server requires
     */
    fun getFormattedDate(date : Date):String{
        val dayNumberSuffix = getDayOfMonthSuffix(date)
        val dateFormat = SimpleDateFormat("EEE dd'$dayNumberSuffix' MMM HH:mm",  Locale.UK)
        return dateFormat.format(date).uppercase(Locale.getDefault())

    }

    /**
     * @param dateString date to be converted to milli seconds
     * @param format format of date time
     *
     * @return milli seconds of date time
     */
    private fun getMillisecondsByDate(dateString : String, format : String) : Long{
        val dateFormat = SimpleDateFormat(format, Locale.UK)
        val date = dateFormat.parse(dateString)
        return date.time
    }

    /**
     * @param dateMillis date in millis
     * @param format format of required date string
     *
     * @return Date time to string
     */
    private fun getDateTimeString(dateMillis : Long, format : String ) : String{
        val dateFormat = SimpleDateFormat(format, Locale.UK)
        return dateFormat.format(dateMillis)
    }

    /**
     * @param durationInMinutes duration amount or units as of x minute to add
     * @param dateFrom starting point of date
     *
     * @return add duration to current date time to get date to
     */
    fun getDateTo(durationInMinutes: Int, dateFrom: String): String {
        val dateFromInMillisec = getMillisecondsByDate(
            dateFrom,
            "yyyy-MM-dd HH:mm:ss")
        val durationInMillisec: Long = durationInMinutes * 60000L
        val dateToinMillisec = dateFromInMillisec + durationInMillisec
        return getDateTimeString(dateToinMillisec, "yyyy-MM-dd HH:mm:ss")
    }

    fun tokenIsExpiring(expiryDate: String): Boolean {
        val dateFormatInput = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.UK)
        val expiryDate = dateFormatInput.parse(expiryDate)
        val calendar = Calendar.getInstance()
        val currentDate = calendar.time
        calendar.time = expiryDate
        calendar.add(Calendar.MONTH, -1)
        var validDate = calendar.time

        val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.UK)

        Log.d("EXPIRY DATE", "expiry: ${expiryDate}--- valid: ${dateFormat.format(validDate)}--- current: ${dateFormat.format(currentDate)}")
        var isExpiring = currentDate.compareTo(validDate)

        return isExpiring > 0
    }

}