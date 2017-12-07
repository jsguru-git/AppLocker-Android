package com.app.locker.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.locker.MainActivity;
import com.app.locker.R;
import com.app.locker.util.Constant1;
import com.app.locker.util.Utils;

public class ConfirmActivity extends Activity {
    String datas;
    ImageView img_dot;
    ImageView img_dot1;
    ImageView img_dot2;
    ImageView img_dot3;
    ImageView img_dot4;
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
    String passcode = "";
    String setpin;
    TextView txt_Confirm_password;
    TextView txt_enter_password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        this.setpin = getIntent().getExtras().getString("Pin");
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
        this.txt_enter_password = (TextView) findViewById(R.id.txt_enter_password);
        this.txt_Confirm_password = (TextView) findViewById(R.id.txt_Confirm_password);
        this.txt_enter_password.setVisibility(View.GONE);
        this.txt_Confirm_password.setVisibility(View.VISIBLE);
        ButtonClick();
    }

    private void ButtonClick() {
        this.lout_num1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ConfirmActivity.this.passcode.length() != 4) {
                    ConfirmActivity confirmActivity = ConfirmActivity.this;
                    confirmActivity.passcode += "1";
                    ConfirmActivity.this.FeelDot(ConfirmActivity.this.passcode);
                }
            }
        });
        this.lout_num2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ConfirmActivity.this.passcode.length() != 4) {
                    ConfirmActivity confirmActivity = ConfirmActivity.this;
                    confirmActivity.passcode += "2";
                    ConfirmActivity.this.FeelDot(ConfirmActivity.this.passcode);
                }
            }
        });
        this.lout_num3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ConfirmActivity.this.passcode.length() != 4) {
                    ConfirmActivity confirmActivity = ConfirmActivity.this;
                    confirmActivity.passcode += "3";
                    ConfirmActivity.this.FeelDot(ConfirmActivity.this.passcode);
                }
            }
        });
        this.lout_num4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ConfirmActivity.this.passcode.length() != 4) {
                    ConfirmActivity confirmActivity = ConfirmActivity.this;
                    confirmActivity.passcode += "4";
                    ConfirmActivity.this.FeelDot(ConfirmActivity.this.passcode);
                }
            }
        });
        this.lout_num5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ConfirmActivity.this.passcode.length() != 4) {
                    ConfirmActivity confirmActivity = ConfirmActivity.this;
                    confirmActivity.passcode += "5";
                    ConfirmActivity.this.FeelDot(ConfirmActivity.this.passcode);
                }
            }
        });
        this.lout_num6.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ConfirmActivity.this.passcode.length() != 4) {
                    ConfirmActivity confirmActivity = ConfirmActivity.this;
                    confirmActivity.passcode += "6";
                    ConfirmActivity.this.FeelDot(ConfirmActivity.this.passcode);
                }
            }
        });
        this.lout_num7.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ConfirmActivity.this.passcode.length() != 4) {
                    ConfirmActivity confirmActivity = ConfirmActivity.this;
                    confirmActivity.passcode += "7";
                    ConfirmActivity.this.FeelDot(ConfirmActivity.this.passcode);
                }
            }
        });
        this.lout_num8.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ConfirmActivity.this.passcode.length() != 4) {
                    ConfirmActivity confirmActivity = ConfirmActivity.this;
                    confirmActivity.passcode += "8";
                    ConfirmActivity.this.FeelDot(ConfirmActivity.this.passcode);
                }
            }
        });
        this.lout_num9.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ConfirmActivity.this.passcode.length() != 4) {
                    ConfirmActivity confirmActivity = ConfirmActivity.this;
                    confirmActivity.passcode += "9";
                    ConfirmActivity.this.FeelDot(ConfirmActivity.this.passcode);
                }
            }
        });
        this.lout_num0.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ConfirmActivity.this.passcode.length() != 4) {
                    ConfirmActivity confirmActivity = ConfirmActivity.this;
                    confirmActivity.passcode += "0";
                    ConfirmActivity.this.FeelDot(ConfirmActivity.this.passcode);
                }
            }
        });
        this.lout_numback.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ConfirmActivity.this.backButtonClick(ConfirmActivity.this.passcode);
            }
        });
        this.lout_clear.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ConfirmActivity.this.clearButtonClick();
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
            if (this.setpin.equals(pass)) {
                Intent i = new Intent(this, MainActivity.class);
//                Intent i = new Intent(this, ConfirmEmailActivity.class);
                Bundle b = new Bundle();
                b.putString("Pin", pass);
                i.putExtras(b);
                Utils.saveToUserDefaults(this, Constant1.PIN, pass);

                startActivityForResult(i, 1);
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

    private String getpreferences(String key) {
        return getSharedPreferences("pref", 0).getString(key, "0");
    }
}
