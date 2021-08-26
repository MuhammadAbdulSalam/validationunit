/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.sagoss.validationtesting.utils.HelperUtil
import com.sagoss.validationtesting.utils.InternetConnectionInterface
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var noInternetButton           : ExtendedFloatingActionButton

    companion object{
        var connectionListener              : InternetConnectionInterface? = null
        var isDisconnected                  = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        noInternetButton = findViewById(R.id.no_internet_button)
        if(HelperUtil.isNetworkAvailable(this)) noInternetButton.visibility = View.INVISIBLE
        else noInternetButton.visibility = View.VISIBLE
    }

    /**
     * Internet broadcast receiver
     *
     * Gets network status to update network button and inform fragments
     */
    private val internetStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            isDisconnected =
                intent!!.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
            if(isDisconnected) noInternetButton.visibility = View.VISIBLE
            else noInternetButton.visibility = View.INVISIBLE
            if (connectionListener != null) {
                if (isDisconnected) connectionListener!!.onDisconnected()
                else connectionListener!!.onConnected()
            }
        }
    }

    /**
     * Register Internet broadcast to listen to internet connection
     */
    @Override
    override fun onResume() {
        super.onResume()
        registerReceiver(
            internetStateReceiver,
            IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        )
    }

    /**
     * Unregister Internet broadcast
     */
    @Override
    override fun onStop() {
        super.onStop()
        unregisterReceiver(internetStateReceiver)
    }
}