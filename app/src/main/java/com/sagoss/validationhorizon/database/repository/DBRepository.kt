/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.database.repository

import com.sagoss.validationhorizon.database.dao.RequestDao
import com.sagoss.validationhorizon.database.dao.VoucherDao
import com.sagoss.validationhorizon.database.models.Request
import com.sagoss.validationhorizon.database.models.Voucher
import javax.inject.Inject

class DBRepository @Inject constructor(private val voucherDao: VoucherDao, private val requestDao: RequestDao) {

    suspend fun getAllVoucher() = voucherDao.getAll()
    fun insertVoucher(voucher: Voucher) = voucherDao.insert(voucher)
    fun insertAllVouchers(listVoucher: List<Voucher>) = voucherDao.insertAll(listVoucher)
    suspend fun deleteAllVouchers() = voucherDao.deleteAll()
    suspend fun getVoucher(name: String): Voucher = voucherDao.getVoucher(name)
    suspend fun getVoucherNames(): List<String> = voucherDao.getVoucherNames()
    suspend fun getVoucherCount(): Int = voucherDao.getCount()


    suspend fun getAllRequests(): List<Request> =  requestDao.getAll()
    fun insertRequest(request: Request) = requestDao.insert(request)
    suspend fun deleteAllRequests() = requestDao.deleteAll()
    suspend fun deleteOldRequestRecords() = requestDao.deleteOldRecords()
    suspend fun getRequest(id: Long): Request = requestDao.getRequest(id)
    suspend fun deleteSuccessfulRequest(id: Int) = requestDao.deleteSuccessfulRequest(id)
    suspend fun getRequestCount(): Int = requestDao.getCount()


}
