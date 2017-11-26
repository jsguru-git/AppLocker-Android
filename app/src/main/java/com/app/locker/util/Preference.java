package com.app.locker.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by KBest on 11/24/2017.
 */

public class Preference {
    private static Context mContext;

    private static SharedPreferences sharedPrefs;

    public static boolean getLockSetting(Context context)
    {
        if( sharedPrefs == null)
            sharedPrefs = getSharedPrefs(context);

        return sharedPrefs.getBoolean("lock", false);
    }

    public static void setLockSetting(Context context, Boolean value)
    {
        if( sharedPrefs == null)
            sharedPrefs = getSharedPrefs(context);

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("lock", value);
        editor.commit();
    }

    public static SharedPreferences getSharedPrefs(Context context) {
        if(mContext == null)
            mContext = context;

        return mContext.getSharedPreferences( "setting", Context.MODE_PRIVATE);
    }
}
