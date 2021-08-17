/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.testpack.utils

import com.sagoss.validationhorizon.database.models.Voucher

object TestHelper {

    fun dateToVoucher(): Voucher {
        return Voucher(
            voucherName = "Academy User",
            voucherId = 0,
            voucherServerID = 0,
            key = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ2b3VjaGVyX2lkIjowLCJ2b3VjaGVyX3N" +
                    "lcnZlcl9pZCI6MCwibm9fdm91Y2hlciI6MSwicHJvZHVjdF9pZCI6IjI0OTgiLCJwcm9kdWN0" +
                    "X3NlcnZlcl9pZCI6IjEiLCJwYXltZW50X3R5cGUiOjEwLCJkZXZpY2VfaWQiOiI1NjA0IiwiZG" +
                    "V2aWNlX3NlcnZlcl9pZCI6IjEiLCJpYXQiOjE2MjkxMjg3MDEsImV4cCI6MTk0NDY2MTUwMX0" +
                    ".qkpu14p8FahywS9BUYUTUrcdKL6LgpX9OiLRUI2imeQ",
            dateFrom = false,
            dateTo = true,
            dateToUnit = "DAILY",
            dateToFixed = null,
            dateToLimit = 0,
            workOffline = false
        )
    }

}