package com.sagoss.validationhorizon.utils

import android.content.Context
import android.content.SharedPreferences
import com.sagoss.validationhorizon.utils.Constants.ACCESS_TOKEN
import com.sagoss.validationhorizon.utils.Constants.COMPANY_ID
import com.sagoss.validationhorizon.utils.Constants.EXPIRY_DATE
import com.sagoss.validationhorizon.utils.Constants.PREFS_NAME
import com.sagoss.validationhorizon.utils.Constants.REFRESH_TOKEN
import javax.inject.Inject


class Prefs @Inject constructor(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var accessToken: String?
        get() = prefs.getString(ACCESS_TOKEN, "")
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


}