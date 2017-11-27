package com.app.locker.receiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.provider.Telephony;
import android.util.Log;

import com.app.locker.activity.LockActivity;
import com.app.locker.util.Constants;
import com.app.locker.util.Preference;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import org.apache.commons.lang.ArrayUtils;

public class OnAlarmReceiver extends BroadcastReceiver {
    ActivityManager activityManager;
    Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(Constants.TAG, "Alarm Service Receiver");
        mContext = context;

        if (Preference.getLockSetting(mContext)) {
            PackageManager pm = mContext.getPackageManager();
            List<ApplicationInfo> apps = pm.getInstalledApplications(0);

            String[] install = new String[apps.size()];
            int count = 0;

            for (ApplicationInfo app : apps) {
                install[count] = app.packageName;
                count++;
            }

            Intent dial_intent = new Intent(Intent.ACTION_DIAL);

            ResolveInfo dialLauncher = mContext.getPackageManager().resolveActivity(dial_intent, PackageManager.MATCH_DEFAULT_ONLY);
            String deafultDialStr = dialLauncher.activityInfo.packageName;

    //      get launcher package name
            Intent launcher_intent = new Intent(Intent.ACTION_MAIN);
            launcher_intent.addCategory(Intent.CATEGORY_HOME);
            ResolveInfo defaultLauncher = mContext.getPackageManager().resolveActivity(launcher_intent, PackageManager.MATCH_DEFAULT_ONLY);
            String deaultLauncherStr = defaultLauncher.activityInfo.packageName;

    //      get sms package name
            String sms_name = new String();
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            {
                sms_name = Telephony.Sms.getDefaultSmsPackage(mContext);
            }
            else {
                Intent sms_intent = new Intent(Intent.ACTION_VIEW).addCategory(Intent.CATEGORY_DEFAULT).setType("vnd.android-dir/mms-sms");
                final List<ResolveInfo> sms_resolveInfos = mContext.getPackageManager().queryIntentActivities(sms_intent, 0);
                if (sms_resolveInfos != null && !sms_resolveInfos.isEmpty())
                    sms_name = sms_resolveInfos.get(0).activityInfo.packageName;
            }

    //        remove launcher, sms and phone package
            install = (String[]) ArrayUtils.removeElement(install, deaultLauncherStr);
            install = (String[]) ArrayUtils.removeElement(install, sms_name);
            install = (String[]) ArrayUtils.removeElement(install, "com.android.systemui");
            install = (String[]) ArrayUtils.removeElement(install, deafultDialStr);

            activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            String[] activePackages;

            if (Build.VERSION.SDK_INT > 20) {
                activePackages = getActivePackages();
            } else {
                activePackages = getActivePackagesCompat();
            }

            for (int i = 0; i < activePackages.length; i++) {
                Log.e(Constants.TAG, "Package Name : " + activePackages[i]);
            }

            Log.e(Constants.TAG, "My Package Name : " + mContext.getPackageName());

            Intent pwdIntent = new Intent(context, LockActivity.class);
            pwdIntent.setFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TOP);

            Intent intent1 = new Intent("android.intent.action.MAIN");
            intent1.addCategory("android.intent.category.HOME");
            compareForHomeButton(this.mContext.getPackageManager().resolveActivity(intent1, 65536).activityInfo.packageName, activePackages);

            if (activePackages != null) {
                int length = activePackages.length;
                int i = 0;
                while (i < length) {
                    String activePackage = activePackages[i];
                    Log.e(Constants.TAG, activePackage);
                    for (int j = 0; j < install.length; j++) {
                        if (!activePackage.equalsIgnoreCase(mContext.getPackageName()) && activePackage.equalsIgnoreCase(install[j]) && getpreferences("Lock").equalsIgnoreCase("False")) {
                            Log.e("package name match", activePackage);
                            SavePreferences("Lock", "Still");
                            pwdIntent.putExtra("Packagename", activePackage);
                            this.mContext.startActivity(pwdIntent);
                        }
                    }
                    i++;
                }
            }
        }
    }


    private void SavePreferences(String key, String value) {
        SharedPreferences.Editor editor = this.mContext.getSharedPreferences("pref", 0).edit();
        editor.putString(key, value);
        editor.commit();
    }

    private String getpreferences(String key) {
        return this.mContext.getSharedPreferences("pref", 0).getString(key, "0");
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

    public void compareForHomeButton(String homePackagename, String[] activePackages) {
        if (activePackages != null) {
            for (String activePackage : activePackages) {
                if (homePackagename.equals(activePackage)) {
                    if (!getpreferences("Lock").equalsIgnoreCase("False")) {
                        SavePreferences("Lock", "False");
                    }
                    Log.e("current home page set", "true");
                }
            }
        }
    }
}
