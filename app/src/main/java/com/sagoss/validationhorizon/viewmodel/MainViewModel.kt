/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.google.gson.JsonArray
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationhorizon.utils.Resource
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import com.sagoss.validationhorizon.api.repository.ApiResponseRepository
import com.sagoss.validationhorizon.apitwo.repositiory.ApiTwoResponseRepository
import com.sagoss.validationhorizon.database.models.Request
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.database.repository.DBRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiOneRepository: ApiResponseRepository,
    private val apiTwoRepository: ApiTwoResponseRepository,
    private val dbRepository: DBRepository
    ) : ViewModel() {

    /**
     * @param registrationRequest Registration Request Param object
     *
     * Gets response from API One registration call
     */
    fun getRegistration(registrationRequest: RegistrationRequest) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(
                Resource.success(
                    data = apiOneRepository.getRegistrationResponse(registrationRequest)
                )
            )
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    /**
     * @param accessToken Current Access token stored
     * @param refreshTokenRequest RefreshTokenRequest Params to be passed as Object
     *
     * Gets Response from API One for Token Refresh call
     */
    fun getRefreshToken(accessToken: String, refreshTokenRequest: RefreshTokenRequest) =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(
                    Resource.success(
                        data = apiOneRepository.getRefreshTokenResponse(
                            accessToken, refreshTokenRequest
                        )
                    )
                )
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }

    /**
     * @param accessToken Current Access token stored
     *
     * Gets Response from API One for Token Refresh call
     */
    fun getConfig(accessToken: String) =

    liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
            try {
                emit(Resource.success(data = apiOneRepository.getConfig(accessToken)))
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }

    /**
     * @param plate Query param "plate"
     * @param token Access Token Query param "jtoken"
     * @param checkDateIn date in query param check_date_in
     *
     * Get response from API Two validation request
     */
    fun checkDateIn(plate: String, token: String, checkDateIn: String) =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(
                    Resource.success(
                        data = apiTwoRepository.checkDateIn(
                            plate,
                            token,
                            checkDateIn
                        )
                    )
                )
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }


    /**
     * @param plate Query param "plate"
     * @param token Access Token Query param "jtoken"
     * @param date_from date from query param date_from
     * @param date_to date to query param date_to
     *
     * Get response from API Two validation request
     */
    fun checkVoucher(plate: String, token: String, date_from: String, date_to: String) =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(
                    Resource.success(
                        data = apiTwoRepository.checkVoucher(
                            plate, token,
                            date_from, date_to
                        )
                    )
                )
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }

    /**
     * Get list of all vouchers
     */
    fun getAllVouchers() =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try{
                emit(Resource.success(data = dbRepository.getAllVoucher()))
            }
            catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }

        }

    /**
     * @param  request offline validation request to be added
     *
     * Store request in db for later validation
     */
    fun saveRequest(request: Request) =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try{
                emit(Resource.success(data = dbRepository.insertRequest(request)))
            }
            catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }
}