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