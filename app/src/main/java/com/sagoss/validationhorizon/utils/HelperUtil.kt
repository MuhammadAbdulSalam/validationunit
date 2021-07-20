package com.sagoss.validationhorizon.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import com.sagoss.validationhorizon.databinding.DialogWarningBinding

object HelperUtil {

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
}