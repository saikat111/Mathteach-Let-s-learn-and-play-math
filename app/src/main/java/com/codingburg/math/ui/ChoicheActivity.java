package com.codingburg.math.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.codingburg.math.R;
import com.onesignal.OneSignal;

public class ChoicheActivity extends AppCompatActivity {
    private static final String ONESIGNAL_APP_ID = "f8ac5050-6457-4df6-ae90-13f9a0da58af";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choiche);
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }

    public void learnMath(View view) {
        Intent homeIntent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(homeIntent);
    }

    public void api(View view) {
        Intent homeIntent=new Intent(getApplicationContext(), FunActivity.class);
        startActivity(homeIntent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAffinity();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}