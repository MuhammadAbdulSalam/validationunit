package com.sagoss.validationtesting;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/sagoss/validationtesting/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "internetStateReceiver", "Landroid/content/BroadcastReceiver;", "noInternetButton", "Lcom/google/android/material/floatingactionbutton/ExtendedFloatingActionButton;", "getNoInternetButton", "()Lcom/google/android/material/floatingactionbutton/ExtendedFloatingActionButton;", "setNoInternetButton", "(Lcom/google/android/material/floatingactionbutton/ExtendedFloatingActionButton;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStop", "Companion", "validationtesting_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton noInternetButton;
    @org.jetbrains.annotations.NotNull()
    public static final com.sagoss.validationtesting.MainActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.sagoss.validationtesting.utils.InternetConnectionInterface connectionListener;
    private static boolean isDisconnected = false;
    
    /**
     * Internet broadcast receiver
     *
     * Gets network status to update network button and inform fragments
     */
    private final android.content.BroadcastReceiver internetStateReceiver = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton getNoInternetButton() {
        return null;
    }
    
    public final void setNoInternetButton(@org.jetbrains.annotations.NotNull()
    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Register Internet broadcast to listen to internet connection
     */
    @java.lang.Override()
    protected void onResume() {
    }
    
    /**
     * Unregister Internet broadcast
     */
    @java.lang.Override()
    protected void onStop() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/sagoss/validationtesting/MainActivity$Companion;", "", "()V", "connectionListener", "Lcom/sagoss/validationtesting/utils/InternetConnectionInterface;", "getConnectionListener", "()Lcom/sagoss/validationtesting/utils/InternetConnectionInterface;", "setConnectionListener", "(Lcom/sagoss/validationtesting/utils/InternetConnectionInterface;)V", "isDisconnected", "", "()Z", "setDisconnected", "(Z)V", "validationtesting_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.sagoss.validationtesting.utils.InternetConnectionInterface getConnectionListener() {
            return null;
        }
        
        public final void setConnectionListener(@org.jetbrains.annotations.Nullable()
        com.sagoss.validationtesting.utils.InternetConnectionInterface p0) {
        }
        
        public final boolean isDisconnected() {
            return false;
        }
        
        public final void setDisconnected(boolean p0) {
        }
    }
}