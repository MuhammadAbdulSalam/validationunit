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

    /**
     * get list of all vouchers
     */
    suspend fun getAllVoucher() = voucherDao.getAll()

    /**
     * Insert a voucher in db
     */
    fun insertVoucher(voucher: Voucher) = voucherDao.insert(voucher)

    /**
     * @param listVoucher list of voucher to be added to db
     * Insert all vouchers in DB
     */
    fun insertAllVouchers(listVoucher: List<Voucher>) = voucherDao.insertAll(listVoucher)

    /**
     * delete all current voucher in DB
     */
    suspend fun deleteAllVouchers() = voucherDao.deleteAll()

    /**
     * @param name name of voucher we need to get from DB
     */
    suspend fun getVoucher(name: String): Voucher = voucherDao.getVoucher(name)

    /**
     * get list of all voucher names
     */
    suspend fun getVoucherNames(): List<String> = voucherDao.getVoucherNames()

    /**
     * get current count of vouchers in DB
     */
    suspend fun getVoucherCount(): Int = voucherDao.getCount()

    /**
     * get all requests stored in DB
     */
    suspend fun getAllRequests(): List<Request> =  requestDao.getAll()

    /**
     * @param request request to be added to DB
     */
    fun insertRequest(request: Request) = requestDao.insert(request)

    /**
     * delete all requests stored in DB
     */
    suspend fun deleteAllRequests() = requestDao.deleteAll()

    /**
     * delete all requests records older then 15 days in DB
     */
    suspend fun deleteOldRequestRecords() = requestDao.deleteOldRecords()

    /**
     * @param id ID of request to be extracted from DB
     */
    suspend fun getRequest(id: Long): Request = requestDao.getRequest(id)

    /**
     * delete all request that were processed successfully
     */
    suspend fun deleteSuccessfulRequest(id: Int) = requestDao.deleteSuccessfulRequest(id)

    /**
     * get count of requests stored in DB
     */
    suspend fun getRequestCount(): Int = requestDao.getCount()


}
