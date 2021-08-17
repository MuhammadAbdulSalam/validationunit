package com.sagoss.validationtesting.database.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\u000b\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\u001f\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u0011J\u000e\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0012J\u000e\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/sagoss/validationtesting/database/repository/DBRepository;", "", "voucherDao", "Lcom/sagoss/validationtesting/database/dao/VoucherDao;", "requestDao", "Lcom/sagoss/validationtesting/database/dao/RequestDao;", "(Lcom/sagoss/validationtesting/database/dao/VoucherDao;Lcom/sagoss/validationtesting/database/dao/RequestDao;)V", "deleteAllRequests", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllVouchers", "deleteOldRequestRecords", "deleteSuccessfulRequest", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRequests", "", "Lcom/sagoss/validationtesting/database/models/Request;", "getAllVoucher", "Lcom/sagoss/validationtesting/database/models/Voucher;", "getRequest", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRequestCount", "getVoucher", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVoucherCount", "getVoucherNames", "insertAllVouchers", "listVoucher", "insertRequest", "request", "insertVoucher", "voucher", "validationtesting_debug"})
public final class DBRepository {
    private final com.sagoss.validationtesting.database.dao.VoucherDao voucherDao = null;
    private final com.sagoss.validationtesting.database.dao.RequestDao requestDao = null;
    
    @javax.inject.Inject()
    public DBRepository(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.dao.VoucherDao voucherDao, @org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.dao.RequestDao requestDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllVoucher(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.sagoss.validationtesting.database.models.Voucher>> continuation) {
        return null;
    }
    
    public final void insertVoucher(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.models.Voucher voucher) {
    }
    
    public final void insertAllVouchers(@org.jetbrains.annotations.NotNull()
    java.util.List<com.sagoss.validationtesting.database.models.Voucher> listVoucher) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAllVouchers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getVoucher(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.database.models.Voucher> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getVoucherNames(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getVoucherCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllRequests(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.sagoss.validationtesting.database.models.Request>> continuation) {
        return null;
    }
    
    public final void insertRequest(@org.jetbrains.annotations.NotNull()
    com.sagoss.validationtesting.database.models.Request request) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAllRequests(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteOldRequestRecords(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRequest(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sagoss.validationtesting.database.models.Request> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteSuccessfulRequest(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRequestCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        return null;
    }
}