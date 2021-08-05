/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sagoss.validationhorizon.database.dao.RequestDao
import com.sagoss.validationhorizon.database.dao.VoucherDao
import com.sagoss.validationhorizon.database.models.DateToFixedConverters
import com.sagoss.validationhorizon.database.models.Request
import com.sagoss.validationhorizon.database.models.Voucher

@Database(entities = [
    (Request::class),
    (Voucher::class)
], version = 1, exportSchema = false)
@TypeConverters(DateToFixedConverters::class)
abstract class ValidationDatabase : RoomDatabase() {
    /**
     * Connects the database to the DAO.
     */
    abstract fun voucherDao() : VoucherDao
    abstract fun requestDao() :  RequestDao
}