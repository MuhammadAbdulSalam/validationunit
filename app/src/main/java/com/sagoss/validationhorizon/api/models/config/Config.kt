package com.sagoss.validationhorizon.api.models.config

import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName
import com.sagoss.validationhorizon.database.models.Voucher
import org.json.JSONArray
import org.json.JSONObject

data class Config(
    @SerializedName("status")
    val status: String,

    @SerializedName("site_id")
    val site_id: String,

    @SerializedName("site_group_id")
    val site_group_id: String,

    @SerializedName("location_name")
    val location_name: String,

    @SerializedName("vouchers")
    val vouchers: JsonArray
)