package com.sagoss.validationhorizon.api.models.registration

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    @SerializedName("access_token")
    private val access_token: String,

    @SerializedName("expiry_date")
    private val expiry_date : String,

    @SerializedName("refresh_token")
    private val refresh_token : String,

    @SerializedName("company_id")
    private val company_id : String,
    )
