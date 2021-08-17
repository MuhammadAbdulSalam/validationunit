package com.sagoss.validationtesting.database;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.sagoss.validationtesting.database.models.DateToFixedConverters.class})
@androidx.room.Database(entities = {com.sagoss.validationtesting.database.models.Request.class, com.sagoss.validationtesting.database.models.Voucher.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/sagoss/validationtesting/database/ValidationDatabase;", "Landroidx/room/RoomDatabase;", "()V", "requestDao", "Lcom/sagoss/validationtesting/database/dao/RequestDao;", "voucherDao", "Lcom/sagoss/validationtesting/database/dao/VoucherDao;", "validationtesting_debug"})
public abstract class ValidationDatabase extends androidx.room.RoomDatabase {
    
    public ValidationDatabase() {
        super();
    }
    
    /**
     * Connects the database to the DAO.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.sagoss.validationtesting.database.dao.VoucherDao voucherDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.sagoss.validationtesting.database.dao.RequestDao requestDao();
}