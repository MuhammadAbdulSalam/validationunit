package com.sagoss.validationhorizon.api.models.refreshtoken

import com.google.gson.annotations.SerializedName

data class RefreshTokenResponse(
    @SerializedName("access_token")
    private val access_token: String,

    @SerializedName("expiry_date")
    private val expiry_date: String,

    @SerializedName("refresh_token")
    private val refresh_token: String,
)
