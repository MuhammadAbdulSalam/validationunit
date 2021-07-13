package com.sagoss.validationhorizon.utils

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

object Constants {
    const val API_URL_ONE                       = "https://blinkenterprise.co.uk/api"
    const val API_URL_TWO                       = "https://blinkenterprise.co.uk/api2"
    const val ENDPOINT_MOBILE                   = "/mobile"
    const val END_POINT_KIOSK_WEB_VALIDATE      = "/KioskWebValidate"


    const val AUTHORISATION                     = "Authorization"
    const val APPLICATION_JSON                  = "Content-Type: application/json"
    const val PLATE                             = "plate"
    const val TOKEN                             = "jtoken"
    const val CHECK_DATE_IN                     = "check_date_in"
    const val DATE_FROM                         = "date_from"
    const val DATE_TO                           = "date_to"

}