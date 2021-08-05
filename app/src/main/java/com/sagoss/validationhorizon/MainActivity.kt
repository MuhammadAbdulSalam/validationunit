/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.*
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.Prefs
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var noInternetDialog: AlertDialog

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var activityContext: Context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityContext = this
        noInternetDialog = HelperUtil.getErrorDialog(
            this, "No Internet Connection",
            "Please enable Wifi or Phone Internet to continue using this app.",
            false
        ).create()
    }

    private val internetStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val isDisconnected: Boolean =
                intent!!.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
            if (isDisconnected) noInternetDialog.show() else noInternetDialog.dismiss()
        }
    }

    @Override
    override fun onResume() {
        super.onResume()
        registerReceiver(
            internetStateReceiver,
            IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        )
    }

    @Override
    override fun onStop() {
        super.onStop()
        unregisterReceiver(internetStateReceiver)
    }
}