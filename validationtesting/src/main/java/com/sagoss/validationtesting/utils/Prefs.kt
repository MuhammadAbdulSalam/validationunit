/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.utils

import android.content.Context
import android.content.SharedPreferences
import com.sagoss.validationtesting.utils.Constants.ACCESS_TOKEN
import com.sagoss.validationtesting.utils.Constants.COMPANY_ID
import com.sagoss.validationtesting.utils.Constants.CONFIG
import com.sagoss.validationtesting.utils.Constants.DATE_FROM
import com.sagoss.validationtesting.utils.Constants.EXPIRY_DATE
import com.sagoss.validationtesting.utils.Constants.LOCATION_NAME
import com.sagoss.validationtesting.utils.Constants.PREFS_NAME
import com.sagoss.validationtesting.utils.Constants.REFRESH_TOKEN
import com.sagoss.validationtesting.utils.Constants.SITE_ID
import com.sagoss.validationtesting.utils.Constants.STATUS
import javax.inject.Inject


class Prefs @Inject constructor(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var accessToken: String
        get() = if(prefs.getString(ACCESS_TOKEN, "") == null) "" else prefs.getString(ACCESS_TOKEN, "")!!
        set(value) = prefs.edit().putString(ACCESS_TOKEN, value).apply()

    var expiryDate: String?
        get() = prefs.getString(EXPIRY_DATE, "")
        set(value) = prefs.edit().putString(EXPIRY_DATE, value).apply()

    var refreshToken: String?
        get() = prefs.getString(REFRESH_TOKEN, "")
        set(value) = prefs.edit().putString(REFRESH_TOKEN, value).apply()

    var companyId: String?
        get() = prefs.getString(COMPANY_ID, "default")
        set(value) = prefs.edit().putString(COMPANY_ID, value).apply()

    var locationName: String?
        get() = prefs.getString(LOCATION_NAME, "")
        set(value) = prefs.edit().putString(LOCATION_NAME, value).apply()

    var siteId: String?
        get() = prefs.getString(SITE_ID, "")
        set(value) = prefs.edit().putString(SITE_ID, value).apply()

    var status: String?
        get() = prefs.getString(STATUS, "")
        set(value) = prefs.edit().putString(STATUS, value).apply()

    var date_from : String?
        get() = prefs.getString(DATE_FROM, "")
        set(value) = prefs.edit().putString(DATE_FROM, value).apply()

    var config : Boolean
        get() = prefs.getBoolean(CONFIG, false)
        set(value) = prefs.edit().putBoolean(CONFIG, value).apply()
}