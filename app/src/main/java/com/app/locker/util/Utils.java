package com.app.locker.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.util.Patterns;

public class Utils {
    public static boolean isValidEmailAddress(String emailAddress) {
        return Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches();
    }

    public static void saveToUserDefaults(Context context, String key, String value) {
        Log.d("Utils", "Saving:" + key + ":" + value);
        Editor editor = context.getSharedPreferences(Constant1.SHARED_PREFS, 0).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getFromUserDefaults(Context context, String key) {
        Log.d("Utils", "Get:" + key);
        return context.getSharedPreferences(Constant1.SHARED_PREFS, 0).getString(key, "");
    }

    public static void saveToUserDefaults1(Context context, String key, int value) {
        Log.d("Utils", "Saving:" + key + ":" + value);
        Editor editor = context.getSharedPreferences(Constant1.SHARED_PREFS, 0).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getFromUserDefaults1(Context context, String key) {
        Log.d("Utils", "Get:" + key);
        return context.getSharedPreferences(Constant1.SHARED_PREFS, 0).getInt(key, 0);
    }
}