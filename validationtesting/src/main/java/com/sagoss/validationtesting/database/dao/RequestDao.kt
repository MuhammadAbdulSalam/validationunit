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
import com.sagoss.validationtesting.database.models.Request
import com.sagoss.validationtesting.utils.Constants

@Dao
interface RequestDao {
    @Query("SELECT * from ${Constants.TABLE_REQUESTS}")
    suspend fun getAll(): List<Request>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(request: Request)

    @Query("DELETE from ${Constants.TABLE_REQUESTS}")
    suspend fun deleteAll()

    @Query("DELETE FROM ${Constants.TABLE_REQUESTS} WHERE ${Constants.REQUEST_DATE_SAVED} <= DATETIME('now', '-15 days')")
    suspend fun deleteOldRecords()

    @Query("SELECT * FROM ${Constants.TABLE_REQUESTS} WHERE ${Constants.REQUEST_ID}=:id")
    suspend fun getRequest(id: Long): Request

    @Query("DELETE FROM ${Constants.TABLE_REQUESTS} WHERE ${Constants.REQUEST_ID}=:id")
    suspend fun deleteSuccessfulRequest(id: Int)

    @Query("SELECT count(*) FROM ${Constants.TABLE_REQUESTS}")
    suspend fun getCount(): Int
}