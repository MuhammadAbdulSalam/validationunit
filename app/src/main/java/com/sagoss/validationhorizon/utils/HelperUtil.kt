package com.sagoss.validationhorizon.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import com.sagoss.validationhorizon.databinding.DialogWarningBinding
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
     * @param format format of date time eg YY:MM:DD hh:mm:ss
     *
     * @return string of current date time
     */
    fun getCurrentDateTimeString(format : String): String {
        val current = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat(format, Locale.UK)

        return dateFormat.format(current)
    }


}