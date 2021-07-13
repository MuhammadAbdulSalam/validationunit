package com.sagoss.validationhorizon.api.models.refreshtoken

import com.google.gson.annotations.SerializedName

data class RefreshTokenRequest(

    @SerializedName("refresh_token")
    private val refresh_token: String,

    @SerializedName("company_id")
    private val company_id: String,

    )
