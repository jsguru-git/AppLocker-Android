package com.app.locker.activity;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import java.util.Formatter;
import java.util.Locale;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.app.locker.R;

import org.w3c.dom.Text;

/**
 * Created by KBest on 11/24/2017.
 */

public class LockActivity extends Activity {

    String packageName;
    String appName;
    Drawable icon;
    ImageView img_dot;
    TextView txt_appName;
    TextView txt_notification;
    Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
        this.img_dot = (ImageView) findViewById(R.id.img_dot);
        this.txt_appName = (TextView) findViewById(R.id.txt_appName);
        this.txt_notification = (TextView) findViewById(R.id.txt_notification);
        this.back_button = (Button) findViewById(R.id.back_button);
        Bundle extras = getIntent().getExtras();

        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.US);

        if (extras != null) {
            this.packageName = extras.getString("Packagename");
        }
        try {
            final PackageManager pm = getPackageManager();
            this.icon = pm.getApplicationIcon(this.packageName);
            ApplicationInfo ai;
            try {
                ai = pm.getApplicationInfo(this.packageName, 0);
            } catch ( final PackageManager.NameNotFoundException e) {
                ai = null;
            }
            this.appName = (String) (ai != null ? pm.getApplicationLabel(ai) : "(unknown)");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        back_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent setIntent = new Intent(Intent.ACTION_MAIN);
                setIntent.addCategory(Intent.CATEGORY_HOME);
                setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(setIntent);
                return;
            }
        });

        this.img_dot.setImageDrawable(this.icon);
        this.txt_appName.setText(this.appName);
//        this.txt_notification.setText(formatter.format("The %s App had been locked", this.appName).toString());
        this.txt_notification.setText("This App Is Locked!");
    }

    @Override
    public void onBackPressed() {
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
        return;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
        return;
    }
}
