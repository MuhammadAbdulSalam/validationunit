/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.database.models

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sagoss.validationhorizon.api.models.config.DateToFixed

class DateToFixedConverters {

    @TypeConverter
    fun fromObjToJson(list: List<DateToFixed>?): String {
        return Gson().toJson(list)
    }

    /**
     * Convert a json to a list of Images
     */
    @TypeConverter
    fun fromJsonToObj(jsonImages: String): List<DateToFixed>? {
        val notesType = object : TypeToken<List<DateToFixed>>() {}.type
        return Gson().fromJson<List<DateToFixed>>(jsonImages, notesType)
    }
}