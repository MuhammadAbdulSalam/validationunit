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
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sagoss.validationhorizon.utils.HelperUtil
import com.sagoss.validationhorizon.utils.InternetConnectionInterface
import com.sagoss.validationhorizon.utils.Prefs
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var activityContext        : Context
        var connectionListener              : InternetConnectionInterface? = null
        var isDisconnected                  = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityContext = this
    }

    private val internetStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (connectionListener != null) {
                isDisconnected =
                    intent!!.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
                if (isDisconnected) connectionListener!!.onDisconnected() else connectionListener!!.onConnected()
            }
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