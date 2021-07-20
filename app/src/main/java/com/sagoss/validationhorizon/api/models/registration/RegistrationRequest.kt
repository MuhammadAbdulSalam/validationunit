package com.sagoss.validationhorizon.api.models.registration

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Field

class RegistrationRequest(
    val username: String,
    val password: String,
    val app_id: String,
    val mobile_id: String,
    val version: String,
)