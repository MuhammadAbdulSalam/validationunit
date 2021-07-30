package com.sagoss.validationhorizon.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.utils.Constants
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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