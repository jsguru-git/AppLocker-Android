package com.app.locker.activity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.app.locker.MainActivity;
import com.app.locker.R;
import com.app.locker.util.Constant1;
import com.app.locker.util.Utils;
//import com.google.android.gcm.GCMRegistrar;
//import com.google.android.gms.auth.GoogleAuthUtil;

public class FirstActivity extends Activity {
    public static String DeviceId;
    public static String acc_type;
    public static String email;
    public static String name;
    public static String package_name;
    public static String track_country;
    //    ConnectionDetector cd;
    String datas;
    ImageView img_dot;
    ImageView img_dot1;
    ImageView img_dot2;
    ImageView img_dot3;
    ImageView img_dot4;
    Boolean isInternetPresent = Boolean.valueOf(false);
    RelativeLayout lout_clear;
    LinearLayout lout_main_passcode;
    RelativeLayout lout_num0;
    RelativeLayout lout_num1;
    RelativeLayout lout_num2;
    RelativeLayout lout_num3;
    RelativeLayout lout_num4;
    RelativeLayout lout_num5;
    RelativeLayout lout_num6;
    RelativeLayout lout_num7;
    RelativeLayout lout_num8;
    RelativeLayout lout_num9;
    RelativeLayout lout_numback;
    //    private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {
//        public void onReceive(Context context, Intent intent) {
//            String newMessage = intent.getExtras().getString("message");
//            WakeLocker.acquire(FirstActivity.this.getApplicationContext());
//            WakeLocker.release();
//        }
//    };
    AsyncTask<Void, Void, Void> mRegisterTask;
    String msg = "Mobile data is disabled. Connect to Wi-fi network instead, or enable mobile data and try again.";
    String passcode = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!Utils.getFromUserDefaults(this, Constant1.PIN).equals("")) {
            startActivityForResult(new Intent(this, MainActivity.class), 1);
            finish();
            return;
        }
        setContentView(R.layout.activity_first);
        initView();
    }

    public void initView() {
        this.lout_num1 = (RelativeLayout) findViewById(R.id.lout_num1);
        this.lout_num2 = (RelativeLayout) findViewById(R.id.lout_num2);
        this.lout_num3 = (RelativeLayout) findViewById(R.id.lout_num3);
        this.lout_num4 = (RelativeLayout) findViewById(R.id.lout_num4);
        this.lout_num5 = (RelativeLayout) findViewById(R.id.lout_num5);
        this.lout_num6 = (RelativeLayout) findViewById(R.id.lout_num6);
        this.lout_num7 = (RelativeLayout) findViewById(R.id.lout_num7);
        this.lout_num8 = (RelativeLayout) findViewById(R.id.lout_num8);
        this.lout_num9 = (RelativeLayout) findViewById(R.id.lout_num9);
        this.lout_num0 = (RelativeLayout) findViewById(R.id.lout_num0);
        this.lout_numback = (RelativeLayout) findViewById(R.id.lout_numback);
        this.lout_clear = (RelativeLayout) findViewById(R.id.lout_clear);
        this.lout_main_passcode = (LinearLayout) findViewById(R.id.lout_main_passcode);
        this.img_dot1 = (ImageView) findViewById(R.id.img_dot1);
        this.img_dot2 = (ImageView) findViewById(R.id.img_dot2);
        this.img_dot3 = (ImageView) findViewById(R.id.img_dot3);
        this.img_dot4 = (ImageView) findViewById(R.id.img_dot4);
//        this.cd = new ConnectionDetector(this);
//        this.isInternetPresent = Boolean.valueOf(this.cd.isConnectingToInternet());
//        if (this.isInternetPresent.booleanValue()) {
//            getgcm();
//        }
        ButtonClick();
    }

    private void ButtonClick() {
        this.lout_num1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (FirstActivity.this.passcode.length() != 4) {
                    FirstActivity firstActivity = FirstActivity.this;
                    firstActivity.passcode += "1";
                    FirstActivity.this.FeelDot(FirstActivity.this.passcode);
                }
            }
        });
        this.lout_num2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (FirstActivity.this.passcode.length() != 4) {
                    FirstActivity firstActivity = FirstActivity.this;
                    firstActivity.passcode += "2";
                    FirstActivity.this.FeelDot(FirstActivity.this.passcode);
                }
            }
        });
        this.lout_num3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (FirstActivity.this.passcode.length() != 4) {
                    FirstActivity firstActivity = FirstActivity.this;
                    firstActivity.passcode += "3";
                    FirstActivity.this.FeelDot(FirstActivity.this.passcode);
                }
            }
        });
        this.lout_num4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (FirstActivity.this.passcode.length() != 4) {
                    FirstActivity firstActivity = FirstActivity.this;
                    firstActivity.passcode += "4";
                    FirstActivity.this.FeelDot(FirstActivity.this.passcode);
                }
            }
        });
        this.lout_num5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (FirstActivity.this.passcode.length() != 4) {
                    FirstActivity firstActivity = FirstActivity.this;
                    firstActivity.passcode += "5";
                    FirstActivity.this.FeelDot(FirstActivity.this.passcode);
                }
            }
        });
        this.lout_num6.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (FirstActivity.this.passcode.length() != 4) {
                    FirstActivity firstActivity = FirstActivity.this;
                    firstActivity.passcode += "6";
                    FirstActivity.this.FeelDot(FirstActivity.this.passcode);
                }
            }
        });
        this.lout_num7.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (FirstActivity.this.passcode.length() != 4) {
                    FirstActivity firstActivity = FirstActivity.this;
                    firstActivity.passcode += "7";
                    FirstActivity.this.FeelDot(FirstActivity.this.passcode);
                }
            }
        });
        this.lout_num8.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (FirstActivity.this.passcode.length() != 4) {
                    FirstActivity firstActivity = FirstActivity.this;
                    firstActivity.passcode += "8";
                    FirstActivity.this.FeelDot(FirstActivity.this.passcode);
                }
            }
        });
        this.lout_num9.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (FirstActivity.this.passcode.length() != 4) {
                    FirstActivity firstActivity = FirstActivity.this;
                    firstActivity.passcode += "9";
                    FirstActivity.this.FeelDot(FirstActivity.this.passcode);
                }
            }
        });
        this.lout_num0.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (FirstActivity.this.passcode.length() != 4) {
                    FirstActivity firstActivity = FirstActivity.this;
                    firstActivity.passcode += "0";
                    FirstActivity.this.FeelDot(FirstActivity.this.passcode);
                }
            }
        });
        this.lout_numback.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                FirstActivity.this.backButtonClick(FirstActivity.this.passcode);
            }
        });
        this.lout_clear.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                FirstActivity.this.clearButtonClick();
            }
        });
    }

    private void backButtonClick(String pin1) {
        Log.e("clear", pin1);
        if (pin1.length() == 0) {
            return;
        }
        if (pin1.length() == 1) {
            this.passcode = pin1.substring(0, pin1.length() - 1);
            FeelDot(this.passcode);
        } else if (pin1.length() == 2) {
            this.passcode = pin1.substring(0, pin1.length() - 1);
            FeelDot(this.passcode);
        } else if (pin1.length() == 3) {
            this.passcode = pin1.substring(0, pin1.length() - 1);
            FeelDot(this.passcode);
        } else if (pin1.length() == 4) {
            this.passcode = pin1.substring(0, pin1.length() - 1);
            FeelDot(this.passcode);
        }
    }

    private void clearButtonClick() {
        this.passcode = "";
        FeelDot(this.passcode);
    }

    private void FeelDot(String pass) {
        Log.i("String Lenght", String.valueOf(pass.length()));
        if (pass.length() == 0) {
            try {
                Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.open_dot)).getBitmap();
                this.img_dot1.setImageBitmap(bitmap);
                this.img_dot2.setImageBitmap(bitmap);
                this.img_dot3.setImageBitmap(bitmap);
                this.img_dot4.setImageBitmap(bitmap);
            } catch (Exception e) {
                this.passcode = "";
                FeelDot(this.passcode);
            }
        }
        if (pass.length() == 1) {
            try {
                Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.feel_dot)).getBitmap();
                Bitmap bitmap1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.open_dot)).getBitmap();
                this.img_dot1.setImageBitmap(bitmap);
                this.img_dot2.setImageBitmap(bitmap1);
                this.img_dot3.setImageBitmap(bitmap1);
                this.img_dot4.setImageBitmap(bitmap1);
            } catch (Exception e2) {
                this.passcode = "";
                FeelDot(this.passcode);
            }
        }
        if (pass.length() == 2) {
            try {
                Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.feel_dot)).getBitmap();
                Bitmap bitmap1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.open_dot)).getBitmap();
                this.img_dot1.setImageBitmap(bitmap);
                this.img_dot2.setImageBitmap(bitmap);
                this.img_dot3.setImageBitmap(bitmap1);
                this.img_dot4.setImageBitmap(bitmap1);
            } catch (Exception e3) {
                this.passcode = "";
                FeelDot(this.passcode);
            }
        }
        if (pass.length() == 3) {
            try {
                Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.feel_dot)).getBitmap();
                Bitmap bitmap1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.open_dot)).getBitmap();
                this.img_dot1.setImageBitmap(bitmap);
                this.img_dot2.setImageBitmap(bitmap);
                this.img_dot3.setImageBitmap(bitmap);
                this.img_dot4.setImageBitmap(bitmap1);
            } catch (Exception e4) {
                this.passcode = "";
                FeelDot(this.passcode);
            }
        }
        if (pass.length() == 4) {
            try {
                Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.feel_dot)).getBitmap();
                Bitmap bitmap1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.open_dot)).getBitmap();
                this.img_dot1.setImageBitmap(bitmap);
                this.img_dot2.setImageBitmap(bitmap);
                this.img_dot3.setImageBitmap(bitmap);
                this.img_dot4.setImageBitmap(bitmap);
            } catch (Exception e5) {
                this.passcode = "";
                FeelDot(this.passcode);
            }
            Intent i = new Intent(this, ConfirmActivity.class);
            Bundle b = new Bundle();
            b.putString("Pin", pass);
            i.putExtras(b);
            startActivityForResult(i, 1);
            finish();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 1) {
            finish();
        }
    }

//    private void getgcm() {
//        for (Account account : AccountManager.get(this).getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE)) {
//            email = account.name;
//            Constant.email = email;
//            acc_type = account.type;
//            Log.i("Email ID:-", email);
//        }
//        name = getResources().getString(R.string.app_name);
//        Log.e("APP Name:-", name);
//        package_name = getApplicationContext().getPackageName();
//        Constant.package_name = package_name;
//        Log.i("Pakage Name:-", package_name);
//        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
//        track_country = telephonyManager.getSimCountryIso();
//        Constant.track_country = track_country;
//        Log.i("Country Code:-", track_country);
//        DeviceId = getDeviceID(telephonyManager);
//        Constant.DeviceId = DeviceId;
//        Log.i("DEVICE ID:-", DeviceId);
//        GCMRegistrar.checkDevice(this);
//        GCMRegistrar.checkManifest(this);
//        registerReceiver(this.mHandleMessageReceiver, new IntentFilter("com.infinity.wallpaper.DISPLAY_MESSAGE"));
//        if (GCMRegistrar.getRegistrationId(this).equals("")) {
//            GCMRegistrar.register(this, "526067876836");
//        } else if (!GCMRegistrar.isRegisteredOnServer(this)) {
//            final Context context = this;
//            this.mRegisterTask = new AsyncTask<Void, Void, Void>() {
//                protected Void doInBackground(Void... params) {
//                    ServerUtilities.register(context, "e", "e", "e");
//                    return null;
//                }
//
//                protected void onPostExecute(Void result) {
//                    FirstActivity.this.mRegisterTask = null;
//                }
//            };
//            this.mRegisterTask.execute(new Void[]{null, null, null});
//        }
//    }

//    private String getDeviceID(TelephonyManager phonyManager) {
//        String id = phonyManager.getDeviceId();
//        if (id == null) {
//            id = "not available";
//        }
//        switch (phonyManager.getPhoneType()) {
//        }
//        return id;
//    }

    protected void onDestroy() {
//        if (this.mRegisterTask != null) {
//            this.mRegisterTask.cancel(true);
//        }
//        try {
//            unregisterReceiver(this.mHandleMessageReceiver);
//            GCMRegistrar.onDestroy(this);
//        } catch (Exception e) {
//            Log.e("UnRegister Receiver Error", "> " + e.getMessage());
//        }
        super.onDestroy();
    }
}
