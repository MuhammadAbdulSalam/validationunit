/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sagoss.validationtesting.database.models.Voucher
import com.sagoss.validationtesting.utils.Constants

@Dao
interface VoucherDao {
    @Query("SELECT * from ${Constants.TABLE_VOUCHERS}")
    suspend fun getAll(): List<Voucher>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(voucher: Voucher)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(listVoucher : List<Voucher>)

    @Query("DELETE from ${Constants.TABLE_VOUCHERS}")
    suspend fun deleteAll()

    @Query("SELECT * FROM ${Constants.TABLE_VOUCHERS} WHERE ${Constants.VOUCHER_NAME}=:name")
    suspend fun getVoucher(name: String): Voucher

    @Query("SELECT ${Constants.VOUCHER_NAME} from ${Constants.TABLE_VOUCHERS}")
    suspend fun getVoucherNames(): List<String>

    @Query("SELECT count(*) FROM ${Constants.TABLE_VOUCHERS}")
    suspend fun getCount(): Int
}