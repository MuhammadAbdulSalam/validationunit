package com.sagoss.validationtesting.database.models;

import java.lang.System;

@androidx.room.Entity(tableName = "vouchers")
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0011J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\tH\u00c6\u0003J\t\u00107\u001a\u00020\tH\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\t\u0010:\u001a\u00020\tH\u00c6\u0003J~\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\t2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u00c6\u0001\u00a2\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020\t2\b\u0010>\u001a\u0004\u0018\u00010?H\u00d6\u0003J\t\u0010@\u001a\u00020\u0005H\u00d6\u0001J\t\u0010A\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\u001e\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015\u00a8\u0006B"}, d2 = {"Lcom/sagoss/validationtesting/database/models/Voucher;", "Ljava/io/Serializable;", "voucherName", "", "voucherId", "", "voucherServerID", "key", "dateFrom", "", "dateTo", "dateToUnit", "dateToLimit", "workOffline", "dateToFixed", "", "Lcom/sagoss/validationtesting/api/models/config/DateToFixed;", "(Ljava/lang/String;IILjava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;ZLjava/util/List;)V", "getDateFrom", "()Z", "setDateFrom", "(Z)V", "getDateTo", "setDateTo", "getDateToFixed", "()Ljava/util/List;", "setDateToFixed", "(Ljava/util/List;)V", "getDateToLimit", "()Ljava/lang/Integer;", "setDateToLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDateToUnit", "()Ljava/lang/String;", "setDateToUnit", "(Ljava/lang/String;)V", "getKey", "setKey", "getVoucherId", "()I", "setVoucherId", "(I)V", "getVoucherName", "setVoucherName", "getVoucherServerID", "setVoucherServerID", "getWorkOffline", "setWorkOffline", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;IILjava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;ZLjava/util/List;)Lcom/sagoss/validationtesting/database/models/Voucher;", "equals", "other", "", "hashCode", "toString", "validationtesting_debug"})
public final class Voucher implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "voucher_name")
    @com.google.gson.annotations.SerializedName(value = "voucher_name")
    private java.lang.String voucherName;
    @androidx.room.ColumnInfo(name = "voucher_id")
    @androidx.room.PrimaryKey(autoGenerate = false)
    @com.google.gson.annotations.SerializedName(value = "voucher_id")
    private int voucherId;
    @androidx.room.ColumnInfo(name = "voucher_server_id")
    @com.google.gson.annotations.SerializedName(value = "voucher_server_id")
    private int voucherServerID;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "key")
    @com.google.gson.annotations.SerializedName(value = "key")
    private java.lang.String key;
    @androidx.room.ColumnInfo(name = "date_from")
    @com.google.gson.annotations.SerializedName(value = "date_from")
    private boolean dateFrom;
    @androidx.room.ColumnInfo(name = "date_to")
    @com.google.gson.annotations.SerializedName(value = "date_to")
    private boolean dateTo;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "date_to_unit")
    @com.google.gson.annotations.SerializedName(value = "date_to_unit")
    private java.lang.String dateToUnit;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "date_to_limit")
    @com.google.gson.annotations.SerializedName(value = "date_to_limit")
    private java.lang.Integer dateToLimit;
    @androidx.room.ColumnInfo(name = "work_offline")
    @com.google.gson.annotations.SerializedName(value = "work_offline")
    private boolean workOffline;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "date_to_fixed")
    @com.google.gson.annotations.SerializedName(value = "date_to_fixed")
    private java.util.List<com.sagoss.validationtesting.api.models.config.DateToFixed> dateToFixed;
    
    @org.jetbrains.annotations.NotNull()
    public final com.sagoss.validationtesting.database.models.Voucher copy(@org.jetbrains.annotations.NotNull()
    java.lang.String voucherName, int voucherId, int voucherServerID, @org.jetbrains.annotations.NotNull()
    java.lang.String key, boolean dateFrom, boolean dateTo, @org.jetbrains.annotations.Nullable()
    java.lang.String dateToUnit, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dateToLimit, boolean workOffline, @org.jetbrains.annotations.Nullable()
    java.util.List<com.sagoss.validationtesting.api.models.config.DateToFixed> dateToFixed) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Voucher() {
        super();
    }
    
    public Voucher(@org.jetbrains.annotations.NotNull()
    java.lang.String voucherName, int voucherId, int voucherServerID, @org.jetbrains.annotations.NotNull()
    java.lang.String key, boolean dateFrom, boolean dateTo, @org.jetbrains.annotations.Nullable()
    java.lang.String dateToUnit, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dateToLimit, boolean workOffline, @org.jetbrains.annotations.Nullable()
    java.util.List<com.sagoss.validationtesting.api.models.config.DateToFixed> dateToFixed) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVoucherName() {
        return null;
    }
    
    public final void setVoucherName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getVoucherId() {
        return 0;
    }
    
    public final void setVoucherId(int p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getVoucherServerID() {
        return 0;
    }
    
    public final void setVoucherServerID(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKey() {
        return null;
    }
    
    public final void setKey(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getDateFrom() {
        return false;
    }
    
    public final void setDateFrom(boolean p0) {
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getDateTo() {
        return false;
    }
    
    public final void setDateTo(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDateToUnit() {
        return null;
    }
    
    public final void setDateToUnit(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getDateToLimit() {
        return null;
    }
    
    public final void setDateToLimit(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getWorkOffline() {
        return false;
    }
    
    public final void setWorkOffline(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.sagoss.validationtesting.api.models.config.DateToFixed> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.sagoss.validationtesting.api.models.config.DateToFixed> getDateToFixed() {
        return null;
    }
    
    public final void setDateToFixed(@org.jetbrains.annotations.Nullable()
    java.util.List<com.sagoss.validationtesting.api.models.config.DateToFixed> p0) {
    }
}