/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.util

import com.sagoss.validationtesting.api.models.config.DateToFixed
import com.sagoss.validationtesting.database.models.Voucher

object Vouchers {

    /**
     * AcademyUser Voucher
     *
     * Should not ask for date from
     * Should ask for Date To in Daily units
     */
    fun academyUserVoucher(): Voucher {
        return Voucher(
            voucherName = Constants.ACADEMY_VOUCHER_NAME,
            voucherId = 0,
            voucherServerID = 0,
            key = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ2b3VjaGVyX2lkIjowLCJ2b3VjaGVyX3N" +
                    "lcnZlcl9pZCI6MCwibm9fdm91Y2hlciI6MSwicHJvZHVjdF9pZCI6IjI0OTgiLCJwcm9kd" +
                    "WN0X3NlcnZlcl9pZCI6IjEiLCJwYXltZW50X3R5cGUiOjEwLCJkZXZpY2VfaWQiOiI1NjA" +
                    "0IiwiZGV2aWNlX3NlcnZlcl9pZCI6IjEiLCJpYXQiOjE2MjkyODAyMTcsImV4cCI6MTk0N" +
                    "DgxMzAxN30.y37iDL_1DFA8EfJ39VSCkz5sraIBBeSS8vVqMi8GreY",
            dateFrom = false,
            dateTo = true,
            dateToUnit = "DAILY",
            dateToLimit = 0,
            workOffline = true,
            dateToFixed = null,
            )
    }

    /**
     * staff Voucher
     *
     * Should not ask for date from
     * Should ask for Date To no set Units from API
     * Should take to hotel config to select a duration
     */
    fun staffVoucher(): Voucher {
        return Voucher(
            voucherName = Constants.STAFF_VOUCHER_NAME,
            voucherId = 1,
            voucherServerID = 0,
            key = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ2b3VjaGVyX2lkIjowLCJ2b3VjaGVyX3Nlc" +
                    "nZlcl9pZCI6MCwibm9fdm91Y2hlciI6MSwicHJvZHVjdF9pZCI6IjMyNTYiLCJwcm9kdWN0X" +
                    "3NlcnZlcl9pZCI6IjEiLCJwYXltZW50X3R5cGUiOjEwLCJkZXZpY2VfaWQiOiI1NjA0IiwiZG" +
                    "V2aWNlX3NlcnZlcl9pZCI6IjEiLCJpYXQiOjE2MjkyODAyMTcsImV4cCI6MTk0NDgxMzAxN30" +
                    ".eYf3AW7zR227iCcsB1rrtMfKZYmqRvCqppeTOjDN6ME",
            dateFrom = false,
            dateTo = true,
            dateToUnit = null,
            dateToLimit = 0,
            workOffline = true,
            dateToFixed = listOf(
                DateToFixed("First Duration", 61910),
                DateToFixed("Second Duration", 112070),
                DateToFixed("Third Duration", 571770),)
        )
    }

    /**
     * Contractor Voucher
     *
     * Should not ask for date from
     * Should validate on auto selected date
     */
    fun contractorVoucher(): Voucher {
        return Voucher(
            voucherName = "Contractor",
            voucherId = 2,
            voucherServerID = 0,
            key = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ2b3VjaGVyX2lkIjowLCJ2b3VjaGVyX3NlcnZl" +
                    "cl9pZCI6MCwibm9fdm91Y2hlciI6MSwicHJvZHVjdF9pZCI6IjI0OTgiLCJwcm9kdWN0X3NlcnZl" +
                    "cl9pZCI6IjEiLCJwYXltZW50X3R5cGUiOjEwLCJkZXZpY2VfaWQiOiI1NjA0IiwiZGV2aWNlX3N" +
                    "lcnZlcl9pZCI6IjEiLCJpYXQiOjE2MjkyODAyMTcsImV4cCI6MTk0NDgxMzAxN30.y37iDL_1DFA" +
                    "8EfJ39VSCkz5sraIBBeSS8vVqMi8GreY",
            dateFrom = false,
            dateTo = false,
            dateToUnit = null,
            dateToLimit = 0,
            workOffline = true,
            dateToFixed = null
        )
    }

    /**
     * Disabled Voucher
     *
     * Should ask for date from
     * should take to hotel activity and select date_to_fixed item since only 1 item is there
     */
    fun disabledVoucher(): Voucher {
        return Voucher(
            voucherName = "Disabled",
            voucherId = 3,
            voucherServerID = 0,
            key = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ2b3VjaGVyX2lkIjowLCJ2b3VjaGVyX3NlcnZ" +
                    "lcl9pZCI6MCwibm9fdm91Y2hlciI6MSwicHJvZHVjdF9pZCI6IjI0OTgiLCJwcm9kdWN0X3Nlcn" +
                    "Zlcl9pZCI6IjEiLCJwYXltZW50X3R5cGUiOjEwLCJkZXZpY2VfaWQiOiI1NjA0IiwiZGV2aWNlX" +
                    "3NlcnZlcl9pZCI6IjEiLCJpYXQiOjE2MjkyODAyMTcsImV4cCI6MTk0NDgxMzAxN30.y37iDL_1D" +
                    "FA8EfJ39VSCkz5sraIBBeSS8vVqMi8GreY",
            dateFrom = false,
            dateTo = true,
            dateToUnit = null,
            dateToLimit = 0,
            workOffline = true,
            dateToFixed = listOf(DateToFixed("Third Duration", 571770))
        )
    }
}