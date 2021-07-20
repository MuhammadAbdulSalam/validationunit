package com.sagoss.validationhorizon.database.models

import com.google.gson.annotations.SerializedName
import com.sagoss.validationhorizon.api.models.config.DateToFixed
import com.sagoss.validationhorizon.utils.Constants

data class Voucher(
    @SerializedName(Constants.VOUCHER_NAME)
    var voucherName: String = "",

    @SerializedName(Constants.VOUCHER_ID)
    var voucherId: Int = 0,

    @SerializedName(Constants.VOUCHER_SERVER_ID)
    var voucherServerID: Int = 0,

    @SerializedName(Constants.VOUCHER_KEY)
    var key: String = "",

    @SerializedName(Constants.VOUCHER_DATE_FROM)
    var dateFrom: Boolean = false,

    @SerializedName(Constants.VOUCHER_DATE_TO)
    var dateTo: Boolean = false,

    @SerializedName(Constants.VOUCHER_DATE_TO_UNIT)
    var dateToUnit : String? = "",

    @SerializedName(Constants.VOUCHER_DATE_TO_LIMIT)
    var dateToLimit : Int? = 0,

    @SerializedName(Constants.VOUCHER_WORK_OFFLINE)
    var workOffline : Boolean = false,

    @SerializedName(Constants.VOUCHER_DATE_TO_FIXED)
    var dateToFixed : List<DateToFixed>? = null
)
