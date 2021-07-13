package com.sagoss.validationhorizon.api.models.registration

import com.google.gson.annotations.SerializedName

data class RegistrationRequest(

    @SerializedName("username")
    private val username: String,

    @SerializedName("password")
    private val password: String,

    @SerializedName("app_id")
    private val app_id: String,

    @SerializedName("mobile_id")
    private val mobile_id: String,

    @SerializedName("version")
    private val version : String
    )