/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.util

import android.os.Bundle
import com.sagoss.validationtesting.database.models.Voucher

object TestHelper {

    fun getValidationFragmentArgs(voucher: Voucher, plate: String, dateTo: String, dateFrom: String): Bundle {
        val validationFragmentArg = Bundle()
        validationFragmentArg.putSerializable(Constants.VOUCHER_ARG, voucher)
        validationFragmentArg.putString(Constants.PLATE_ARG, plate)
        validationFragmentArg.putString(Constants.DATE_TO_ARG, dateTo)
        validationFragmentArg.putString(Constants.DATE_FROM_ARG, dateFrom)
        return validationFragmentArg
    }

    fun getDateToArgs(voucher: Voucher, plate: String): Bundle {
        val dateToArgs = Bundle()
        dateToArgs.putSerializable(Constants.VOUCHER_ARG, voucher)
        dateToArgs.putString(Constants.PLATE_ARG, plate)
        return dateToArgs
    }
    fun getPlateRegistrationArgs(voucher: Voucher): Bundle {
        val plateRegArgs = Bundle()
        plateRegArgs.putSerializable(Constants.VOUCHER_ARG, voucher)
        return plateRegArgs
    }
}