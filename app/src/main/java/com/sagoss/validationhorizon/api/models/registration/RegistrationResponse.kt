package com.sagoss.validationhorizon.api.models.registration

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    @SerializedName("access_token")
    val access_token: String,

    @SerializedName("expiry_date")
    val expiry_date: String,

    @SerializedName("refresh_token")
    val refresh_token: String,

    @SerializedName("company_id")
    val company_id: String,
)
