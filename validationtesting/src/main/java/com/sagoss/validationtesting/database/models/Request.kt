/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sagoss.validationtesting.utils.Constants


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