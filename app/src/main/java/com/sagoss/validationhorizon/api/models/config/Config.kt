/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.api.models.config

import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName

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