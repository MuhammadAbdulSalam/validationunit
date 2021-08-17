package com.sagoss.validationtesting.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0004\u00a8\u0006!"}, d2 = {"Lcom/sagoss/validationtesting/utils/HelperUtil;", "", "()V", "getCurrentDateTimeString", "", "format", "getDateByString", "Ljava/util/Date;", "dateString", "getDateTimeString", "dateMillis", "", "getDateTo", "durationInMinutes", "", "dateFrom", "getDayOfMonthSuffix", "date", "getErrorDialog", "Landroid/app/AlertDialog$Builder;", "context", "Landroid/content/Context;", "title", "msg", "buttons", "", "getFormattedDate", "getMillisecondsByDate", "getTokenFormat", "accessToken", "isNetworkAvailable", "tokenIsExpiring", "expiryDate", "validationtesting_debug"})
public final class HelperUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.sagoss.validationtesting.utils.HelperUtil INSTANCE = null;
    
    private HelperUtil() {
        super();
    }
    
    /**
     * @param context current activity
     * @param title title of alert dialog
     * @param msg message to show on dialog
     * @param buttons show buttons or no
     *
     * @return alert dialog for different error messages
     */
    @org.jetbrains.annotations.NotNull()
    public final android.app.AlertDialog.Builder getErrorDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String msg, boolean buttons) {
        return null;
    }
    
    /**
     * @param accessToken
     * @return token in correct format to make api call
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTokenFormat(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken) {
        return null;
    }
    
    /**
     * @return Boolean of current network status as connected true or disconnected false
     */
    public final boolean isNetworkAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * @param format format of date time eg YY:MM:DD hh:mm:ss
     *
     * @return string of current date time
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentDateTimeString(@org.jetbrains.annotations.NotNull()
    java.lang.String format) {
        return null;
    }
    
    /**
     * @param dateString date in string
     * @param format format of date required
     *
     * Converts date string to Date.class
     *
     * @return get date from date string
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getDateByString(@org.jetbrains.annotations.NotNull()
    java.lang.String dateString, @org.jetbrains.annotations.NotNull()
    java.lang.String format) {
        return null;
    }
    
    /**
     * @param date date to extract suffix from
     *
     * @return day of month suffix to be added to date string
     */
    private final java.lang.String getDayOfMonthSuffix(java.util.Date date) {
        return null;
    }
    
    /**
     * @param date date to be converted to string
     *
     * @return Formatted date as our server requires
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFormattedDate(@org.jetbrains.annotations.NotNull()
    java.util.Date date) {
        return null;
    }
    
    /**
     * @param dateString date to be converted to milli seconds
     * @param format format of date time
     *
     * @return milli seconds of date time
     */
    private final long getMillisecondsByDate(java.lang.String dateString, java.lang.String format) {
        return 0L;
    }
    
    /**
     * @param dateMillis date in millis
     * @param format format of required date string
     *
     * @return Date time to string
     */
    private final java.lang.String getDateTimeString(long dateMillis, java.lang.String format) {
        return null;
    }
    
    /**
     * @param durationInMinutes duration amount or units as of x minute to add
     * @param dateFrom starting point of date
     *
     * @return add duration to current date time to get date to
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDateTo(int durationInMinutes, @org.jetbrains.annotations.NotNull()
    java.lang.String dateFrom) {
        return null;
    }
    
    public final boolean tokenIsExpiring(@org.jetbrains.annotations.NotNull()
    java.lang.String expiryDate) {
        return false;
    }
}