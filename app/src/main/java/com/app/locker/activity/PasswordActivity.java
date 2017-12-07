package com.app.locker.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
//import com.appthruster.object.GlobalClass;
//import com.appthruster.utils.AlertMessages;
import com.app.locker.R;
import com.app.locker.util.Constant1;
import com.app.locker.util.Utils;
//import com.google.android.gms.ads.AdRequest.Builder;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.drive.DriveFile;
//import com.google.android.gms.games.GamesStatusCodes;
//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.AsyncHttpResponseHandler;
//import com.loopj.android.http.RequestParams;

public class PasswordActivity extends Activity {
    String datas;
    Drawable icon;
    ImageView img_dot;
    ImageView img_dot1;
    ImageView img_dot2;
    ImageView img_dot3;
    ImageView img_dot4;
    RelativeLayout lout_clear;
    RelativeLayout lout_forgot_pass;
    RelativeLayout lout_main_passcode;
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
//    AlertMessages message;
    String passcode = "";
    String url = "http://jkrdevelopers.com/email/index.php/email/send_email/";

//    private class GetdatadResponseHandler extends AsyncHttpResponseHandler {
//        private GetdatadResponseHandler() {
//        }
//
//        public void onStart() {
//            super.onStart();
//        }
//
//        public void onSuccess(String content) {
//            super.onSuccess(content);
//            Log.e("data category wise", content);
//            NewActivity1.this.message.showCutomMessage("Please check your Email");
//        }
//
//        public void onFinish() {
//            super.onFinish();
//        }
//
//        public void onFailure(Throwable error, String content) {
//            super.onFailure(error, content);
//        }
//    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        this.lout_num1 = (RelativeLayout) findViewById(R.id.rel_num1);
        this.lout_num2 = (RelativeLayout) findViewById(R.id.rel_num2);
        this.lout_num3 = (RelativeLayout) findViewById(R.id.rel_num3);
        this.lout_num4 = (RelativeLayout) findViewById(R.id.rel_num4);
        this.lout_num5 = (RelativeLayout) findViewById(R.id.rel_num5);
        this.lout_num6 = (RelativeLayout) findViewById(R.id.rel_num6);
        this.lout_num7 = (RelativeLayout) findViewById(R.id.rel_num7);
        this.lout_num8 = (RelativeLayout) findViewById(R.id.rel_num8);
        this.lout_num9 = (RelativeLayout) findViewById(R.id.rel_num9);
        this.lout_num0 = (RelativeLayout) findViewById(R.id.rel_num0);
        this.lout_numback = (RelativeLayout) findViewById(R.id.rel_numback);
        this.lout_clear = (RelativeLayout) findViewById(R.id.rel_clear);
        this.lout_forgot_pass = (RelativeLayout) findViewById(R.id.lout_forgot_pass);
        this.lout_main_passcode = (RelativeLayout) findViewById(R.id.lout_main_passcode);
//        this.message = new AlertMessages(this);
        this.img_dot = (ImageView) findViewById(R.id.img_dot);
        this.img_dot1 = (ImageView) findViewById(R.id.img_dot1);
        this.img_dot2 = (ImageView) findViewById(R.id.img_dot2);
        this.img_dot3 = (ImageView) findViewById(R.id.img_dot3);
        this.img_dot4 = (ImageView) findViewById(R.id.img_dot4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.datas = extras.getString("Packagename");
        }
        try {
            this.icon = getPackageManager().getApplicationIcon(this.datas);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        this.img_dot.setImageDrawable(this.icon);
        ButtonClick();
    }

    private void ButtonClick() {
        this.lout_num1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                if (PasswordActivity.this.passcode.length() <= 3) {
                    PasswordActivity pwActivity = PasswordActivity.this;
                    pwActivity.passcode += "1";
                    PasswordActivity.this.FeelDot(PasswordActivity.this.passcode);
                }
            }
        });
        this.lout_num2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                if (PasswordActivity.this.passcode.length() <= 3) {
                    PasswordActivity pwActivity = PasswordActivity.this;
                    pwActivity.passcode += "2";
                    PasswordActivity.this.FeelDot(PasswordActivity.this.passcode);
                }
            }
        });
        this.lout_num3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                if (PasswordActivity.this.passcode.length() <= 3) {
                    PasswordActivity pwActivity = PasswordActivity.this;
                    pwActivity.passcode += "3";
                    PasswordActivity.this.FeelDot(PasswordActivity.this.passcode);
                }
            }
        });
        this.lout_num4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                if (PasswordActivity.this.passcode.length() <= 3) {
                    PasswordActivity pwActivity = PasswordActivity.this;
                    pwActivity.passcode += "4";
                    PasswordActivity.this.FeelDot(PasswordActivity.this.passcode);
                }
            }
        });
        this.lout_num5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                if (PasswordActivity.this.passcode.length() <= 3) {
                    PasswordActivity pwActivity = PasswordActivity.this;
                    pwActivity.passcode += "5";
                    PasswordActivity.this.FeelDot(PasswordActivity.this.passcode);
                }
            }
        });
        this.lout_num6.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                if (PasswordActivity.this.passcode.length() <= 3) {
                    PasswordActivity pwActivity = PasswordActivity.this;
                    pwActivity.passcode += "6";
                    PasswordActivity.this.FeelDot(PasswordActivity.this.passcode);
                }
            }
        });
        this.lout_num7.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                if (PasswordActivity.this.passcode.length() <= 3) {
                    PasswordActivity pwActivity = PasswordActivity.this;
                    pwActivity.passcode += "7";
                    PasswordActivity.this.FeelDot(PasswordActivity.this.passcode);
                }
            }
        });
        this.lout_num8.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                if (PasswordActivity.this.passcode.length() <= 3) {
                    PasswordActivity pwActivity = PasswordActivity.this;
                    pwActivity.passcode += "8";
                    PasswordActivity.this.FeelDot(PasswordActivity.this.passcode);
                }
            }
        });
        this.lout_num9.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                if (PasswordActivity.this.passcode.length() <= 3) {
                    PasswordActivity pwActivity = PasswordActivity.this;
                    pwActivity.passcode += "9";
                    PasswordActivity.this.FeelDot(PasswordActivity.this.passcode);
                }
            }
        });
        this.lout_num0.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                if (PasswordActivity.this.passcode.length() <= 3) {
                    PasswordActivity pwActivity = PasswordActivity.this;
                    pwActivity.passcode += "0";
                    PasswordActivity.this.FeelDot(PasswordActivity.this.passcode);
                }
            }
        });
        this.lout_numback.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                PasswordActivity.this.backButtonClick(PasswordActivity.this.passcode);
            }
        });
        this.lout_clear.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Utils.getFromUserDefaults1(PasswordActivity.this, Constant1.PARAM_VALID_SOUND) == 0) {
                    MediaPlayer.create(PasswordActivity.this, R.raw.click).start();
                }
                PasswordActivity.this.clearButtonClick();
            }
        });
        this.lout_forgot_pass.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
//                PasswordActivity.this.getData();
            }
        });
    }

//    public void getData() {
//        RequestParams params = new RequestParams();
//        params.put("email", Utils.getFromUserDefaults(getApplicationContext(), Constant1.PARAM_VALID_EMAIL));
//        params.put("password", Utils.getFromUserDefaults(getApplicationContext(), Constant1.PARAM_VALID_PASSWORD));
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.setTimeout(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED);
//        client.post(this.url, params, new GetdatadResponseHandler());
//    }

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
                this.img_dot1.setImageBitmap(bitmap);
                this.img_dot2.setImageBitmap(bitmap);
                this.img_dot3.setImageBitmap(bitmap);
                this.img_dot4.setImageBitmap(bitmap);
            } catch (Exception e5) {
                this.passcode = "";
                FeelDot(this.passcode);
            }

            if (this.passcode.equalsIgnoreCase(Utils.getFromUserDefaults(this, Constant1.PIN))) {
//            if (this.passcode.equalsIgnoreCase(Utils.getFromUserDefaults(this, Constant1.PARAM_VALID_PASSWORD))) {
                SavePreferences("Lock", "True");
                finish();
                return;
            }
            try {
                findViewById(R.id.shakelayout).startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake));
                if (getpreferences("Vibrate").equalsIgnoreCase("Yes")) {
                    ((Vibrator) getApplicationContext().getSystemService("vibrator")).vibrate(200);
                }
                this.passcode = "";
                FeelDot(this.passcode);
            } catch (Exception e6) {
                this.passcode = "";
                FeelDot(this.passcode);
            }
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent startMain = new Intent("android.intent.action.MAIN");
        startMain.addCategory("android.intent.category.HOME");
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
        return super.onKeyDown(keyCode, event);
    }

    private void SavePreferences(String key, String value) {
        Editor editor = getSharedPreferences("pref", 0).edit();
        editor.putString(key, value);
        editor.commit();
    }

    private String getpreferences(String key) {
        return getSharedPreferences("pref", 0).getString(key, "0");
    }

    @Override
    protected void onPause() {
        super.onPause();

        ActivityManager activityManager = (ActivityManager) getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);

        activityManager.moveTaskToFront(getTaskId(), 0);
    }

}
