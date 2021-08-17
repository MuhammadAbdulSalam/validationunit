package com.sagoss.validationtesting.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/sagoss/validationtesting/utils/ThemeUtil;", "", "()V", "getAppIcon", "", "companyID", "", "getDefaultThemeColor", "getInitialGreetingsDirection", "Landroidx/navigation/NavDirections;", "getInitialNoConfigDirections", "validationtesting_debug"})
public final class ThemeUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.sagoss.validationtesting.utils.ThemeUtil INSTANCE = null;
    
    private ThemeUtil() {
        super();
    }
    
    /**
     * @param companyID company ID as recieved and stored
     *
     * Direction of app to be set according to company ID
     * Once No config fragment is reached rest of directions
     * will be selected from main_nav.xml directions accordingly
     *
     * @return initial no config fragment direction
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.navigation.NavDirections getInitialNoConfigDirections(@org.jetbrains.annotations.NotNull()
    java.lang.String companyID) {
        return null;
    }
    
    /**
     * @param companyID company ID as recieved and stored
     *
     * Direction of app to be set according to company ID
     * Once Greetings fragment is reached rest of directions
     * will be selected from main_nav.xml directions accordingly
     *
     * @return initial greetings fragment direction
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.navigation.NavDirections getInitialGreetingsDirection(@org.jetbrains.annotations.NotNull()
    java.lang.String companyID) {
        return null;
    }
    
    /**
     * @param companyID company ID as received and stored
     *
     * @return Default theme color for app
     */
    public final int getDefaultThemeColor(@org.jetbrains.annotations.NotNull()
    java.lang.String companyID) {
        return 0;
    }
    
    /**
     * @param companyID as stored or received in response
     *
     * @return if regiestered return company logo else sagoss logo
     */
    public final int getAppIcon(@org.jetbrains.annotations.NotNull()
    java.lang.String companyID) {
        return 0;
    }
}