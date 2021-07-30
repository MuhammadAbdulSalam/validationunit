package com.sagoss.validationhorizon.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.sagoss.validationhorizon.api.models.config.DateToFixed
import com.sagoss.validationhorizon.utils.Constants
import java.io.Serializable

@Entity(tableName = Constants.TABLE_VOUCHERS)
data class Voucher(

    @ColumnInfo(name = Constants.VOUCHER_NAME)
    @SerializedName(Constants.VOUCHER_NAME)
    var voucherName: String = "",

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = Constants.VOUCHER_ID)
    @SerializedName(Constants.VOUCHER_ID)
    var voucherId: Int = 0,

    @ColumnInfo(name = Constants.VOUCHER_SERVER_ID)
    @SerializedName(Constants.VOUCHER_SERVER_ID)
    var voucherServerID: Int = 0,

    @ColumnInfo(name = Constants.VOUCHER_KEY)
    @SerializedName(Constants.VOUCHER_KEY)
    var key: String = "",

    @ColumnInfo(name = Constants.VOUCHER_DATE_FROM)
    @SerializedName(Constants.VOUCHER_DATE_FROM)
    var dateFrom: Boolean = false,

    @ColumnInfo(name = Constants.VOUCHER_DATE_TO)
    @SerializedName(Constants.VOUCHER_DATE_TO)
    var dateTo: Boolean = false,

    @ColumnInfo(name = Constants.VOUCHER_DATE_TO_UNIT)
    @SerializedName(Constants.VOUCHER_DATE_TO_UNIT)
    var dateToUnit : String? = "",

    @ColumnInfo(name = Constants.VOUCHER_DATE_TO_LIMIT)
    @SerializedName(Constants.VOUCHER_DATE_TO_LIMIT)
    var dateToLimit : Int? = 0,

    @ColumnInfo(name = Constants.VOUCHER_WORK_OFFLINE)
    @SerializedName(Constants.VOUCHER_WORK_OFFLINE)
    var workOffline : Boolean = false,

    @ColumnInfo(name = Constants.VOUCHER_DATE_TO_FIXED)
    @SerializedName(Constants.VOUCHER_DATE_TO_FIXED)
    var dateToFixed : List<DateToFixed>? = null
): Serializable
