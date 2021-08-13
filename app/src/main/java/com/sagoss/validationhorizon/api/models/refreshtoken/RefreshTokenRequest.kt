/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.api.models.refreshtoken

import com.google.gson.annotations.SerializedName

data class RefreshTokenRequest(

    @SerializedName("refresh_token")
    val refresh_token: String,

    @SerializedName("company_id")
    val company_id: String,
)
