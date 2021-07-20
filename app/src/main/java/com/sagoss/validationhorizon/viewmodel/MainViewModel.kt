package com.sagoss.validationhorizon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sagoss.validationhorizon.api.models.refreshtoken.RefreshTokenRequest
import com.sagoss.validationhorizon.utils.Resource
import com.sagoss.validationhorizon.api.models.registration.RegistrationRequest
import com.sagoss.validationhorizon.api.repository.ApiResponseRepository
import com.sagoss.validationhorizon.apitwo.repositiory.ApiTwoResponseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiOneRepository: ApiResponseRepository,
    private val apiTwoRepository: ApiTwoResponseRepository
) : ViewModel() {

    /**
     * @param registrationRequest Registration Request Param object
     *
     * Gets response from API One registration call
     */
    fun getRegistration(registrationRequest: RegistrationRequest) = liveData(Dispatchers.IO) {
        val data =
        emit(Resource.loading(data = null))
        try {
            emit(
                Resource.success(
                    data = apiOneRepository.getRegistrationResponse(
                        registrationRequest
                    )
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
     * @param plate Query param "plate"
     * @param token Access Token Query param "jtoken"
     * @param checkDateIn date in query param check_date_in
     *
     * Get response from API Two validation request
     */
    suspend fun checkDateIn(plate: String, token: String, checkDateIn: String) =
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
    suspend fun checkVoucher(plate: String, token: String, date_from: String, date_to: String?) =
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


}