package com.sagoss.validationhorizon.utils

import retrofit2.http.*

object Constants {
    const val API_URL_ONE                       = "https://blinkenterprise.co.uk/api/"
    const val API_URL_TWO                       = "https://blinkenterprise.co.uk/api2/"
    const val ENDPOINT_MOBILE                   = "mobile"
    const val ENDPOINT_CONFIG                   = "mobile/DataSync?key=config"

    const val END_POINT_KIOSK_WEB_VALIDATE      = "KioskWebValidate"

    const val AUTHORISATION                     = "Authorization"
    const val APPLICATION_JSON                  = "Content-Type: application/json"
    const val PLATE                             = "plate"
    const val TOKEN                             = "jtoken"
    const val CHECK_DATE_IN                     = "check_date_in"
    const val DATE_FROM                         = "date_from"
    const val DATE_TO                           = "date_to"

    const val PREFS_NAME                        = "prefs"
    const val ACCESS_TOKEN                      = "access_token"
    const val EXPIRY_DATE                       = "expiry_date"
    const val REFRESH_TOKEN                     = "refresh_token"
    const val COMPANY_ID                        = "company_id"
    const val LOCATION_NAME                     = "location_name"
    const val SITE_ID                           = "site_id"
    const val STATUS                            = "status"

    const val PARAM_USERNAME                    = "username"
    const val PARAM_PASSWORD                    = "password"
    const val PARAM_APP_ID                      = "app_id"
    const val PARAM_MOBILE_ID                   = "mobile_id"
    const val PARAM_VERSION                     = "version"


    const val TABLE_REQUESTS                    = "requests"

    const val REQUEST_ID                        = "id"
    const val REQUEST_PLATE                     = "plate"
    const val REQUEST_TOKEN                     = "request_token"
    const val REQUEST_DATE_FROM                 = "date_from"
    const val REQUEST_DATE_TO                   = "date_to"
    const val REQUEST_DATE_SAVED                = "date_saved"

    const val TABLE_VOUCHERS                    = "vouchers"

    const val VOUCHER_NAME                      = "voucher_name"
    const val VOUCHER_ID                        = "voucher_id"
    const val VOUCHER_SERVER_ID                 = "voucher_server_id"
    const val VOUCHER_KEY                       = "key"
    const val VOUCHER_DATE_FROM                 = "date_from"
    const val VOUCHER_DATE_TO                   = "date_to"
    const val VOUCHER_DATE_TO_UNIT              = "date_to_unit"
    const val VOUCHER_DATE_TO_FIXED             = "date_to_fixed"
    const val VOUCHER_DATE_TO_LIMIT             = "date_to_limit"
    const val VOUCHER_WORK_OFFLINE              = "work_offline"

    const val APP_ID                            = "validation"
    const val VERSION                           = "1.0"

    const val C2C_MSG                           = "Thank you. Your vehicle has been exempted for 24h from point of entry"
    const val GREATER_ANGLIA_MSG                = "Thank you. Your vehicle has been exempted for 24h from point of entry"
    const val HORIZON_MSG                       = "Thank you. Your vehicle has been exempted."

}