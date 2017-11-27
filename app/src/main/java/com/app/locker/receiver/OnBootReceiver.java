package com.app.locker.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.app.locker.util.Constants;

import java.util.Calendar;

import static android.app.AlarmManager.RTC_WAKEUP;

/**
 * Created by KBest on 11/25/2017.
 */

public class OnBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(Constants.TAG, "Boot up Complete");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, new Intent(context, OnAlarmReceiver.class), 0);
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        manager.setRepeating(RTC_WAKEUP, calendar.getTimeInMillis(), 1000, pendingIntent);
        Log.e(Constants.TAG, "Alarm Manager Complete");
    }
}
