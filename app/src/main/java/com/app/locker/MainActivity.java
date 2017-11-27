package com.app.locker;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.app.locker.receiver.OnAlarmReceiver;
import com.app.locker.util.Constants;
import com.app.locker.util.Preference;

import java.util.Calendar;

import static android.app.AlarmManager.RTC_WAKEUP;

public class MainActivity extends AppCompatActivity {
    CheckBox lockCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lockCheckBox = this.findViewById(R.id.lock_check_box);

        lockCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                Preference.setLockSetting(MainActivity.this, isCheck);
            }
        });

        lockCheckBox.setChecked(Preference.getLockSetting(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(this, OnAlarmReceiver.class), 0);
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        manager.setRepeating(RTC_WAKEUP, calendar.getTimeInMillis(), 300, pendingIntent);
        Log.e(Constants.TAG, "Alarm Manager Complete");
    }
}
