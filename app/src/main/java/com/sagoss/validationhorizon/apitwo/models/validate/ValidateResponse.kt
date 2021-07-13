package com.sagoss.validationhorizon.apitwo.models.validate

import com.google.gson.annotations.SerializedName

data class ValidateResponse (
    @SerializedName("valid")
    private val valid: String
    )