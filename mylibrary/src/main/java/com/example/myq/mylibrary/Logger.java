package com.example.myq.mylibrary;

import android.util.Log;

/**
 * 打印日志
 */
public class Logger {
    public static boolean debug = true;
    public static final String TAG = "TAG";

    public static void enableDebug(boolean debug) {
        Logger.debug = debug;
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        if (debug)
            Log.e(tag, msg);
    }

    public static void d(String msg) {
        if (debug)
            d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (debug)
            Log.d(tag, msg);
    }

    public static void i(String msg) {
        if (debug)
            i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (debug)
            Log.i(tag, msg);
    }
}
