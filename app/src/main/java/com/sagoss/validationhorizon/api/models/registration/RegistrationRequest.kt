/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.api.models.registration

class RegistrationRequest(
    val username: String,
    val password: String,
    val app_id: String,
    val mobile_id: String,
    val version: String,
)