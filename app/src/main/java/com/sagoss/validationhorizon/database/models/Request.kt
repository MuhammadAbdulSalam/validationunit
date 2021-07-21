package com.sagoss.validationhorizon.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sagoss.validationhorizon.utils.Constants


@Entity(tableName = Constants.TABLE_REQUESTS)
data class Request(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = Constants.REQUEST_ID)
        var id : Int = 0,

        @ColumnInfo(name = Constants.REQUEST_PLATE)
        var plate : String = "",

        @ColumnInfo(name = Constants.REQUEST_TOKEN)
        var token : String = "",

        @ColumnInfo(name = Constants.REQUEST_DATE_FROM)
        var dateFrom : String = "",

        @ColumnInfo(name = Constants.REQUEST_DATE_TO)
        var dateTo : String = "",

        @ColumnInfo(name = Constants.REQUEST_DATE_SAVED)
        var dateSaved : String = ""


)