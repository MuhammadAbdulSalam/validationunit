/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.apitwo.models.validate

import com.google.gson.annotations.SerializedName

data class ValidateResponse (
    @SerializedName("valid")
    val valid: String
    )