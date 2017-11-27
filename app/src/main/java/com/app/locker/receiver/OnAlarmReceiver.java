package com.app.locker.receiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.app.locker.activity.LockActivity;
import com.app.locker.util.Constants;
import com.app.locker.util.Preference;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class OnAlarmReceiver extends BroadcastReceiver {
    ActivityManager activityManager;
    Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(Constants.TAG, "Alarm Service Receiver");
        mContext = context;
        activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        String[] activePackages;

        if (Build.VERSION.SDK_INT > 20) {
            activePackages = getActivePackages();
        } else {
            activePackages = getActivePackagesCompat();
        }

        for(int i = 0 ; i < activePackages.length ; i++)
        {
            Log.e(Constants.TAG, "Package Name : " + activePackages[i]);
        }

        Log.e(Constants.TAG, "My Package Name : " + mContext.getPackageName());

        Intent pwdIntent = new Intent(context, LockActivity.class);
        pwdIntent.setFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TOP);

        if (activePackages != null) {
            int length = activePackages.length;
            int i = 0;
            while (i < length) {
                String activePackage = activePackages[i];
                Log.e(Constants.TAG, activePackage);
            if (Preference.getLockSetting(mContext) && !activePackage.equalsIgnoreCase("com.android.mms")&& !activePackage.equalsIgnoreCase("com.android.contacts") && !activePackage.equalsIgnoreCase(mContext.getPackageName())) {
                    Log.e("package name match", activePackage);
                    pwdIntent.putExtra("Packagename", activePackage);
                    this.mContext.startActivity(pwdIntent);
                }
                i++;
            }
        }
    }


    public String[] getActivePackagesCompat() {
        return new String[]{((ActivityManager.RunningTaskInfo) this.activityManager.getRunningTasks(1).get(0)).topActivity.getPackageName()};
    }

    public String[] getActivePackages() {
        Set<String> activePackages = new HashSet();
        for (ActivityManager.RunningAppProcessInfo processInfo : this.activityManager.getRunningAppProcesses()) {
            if (processInfo.importance == 100) {
                activePackages.addAll(Arrays.asList(processInfo.pkgList));
            }
        }
        return (String[]) activePackages.toArray(new String[activePackages.size()]);
    }

}
