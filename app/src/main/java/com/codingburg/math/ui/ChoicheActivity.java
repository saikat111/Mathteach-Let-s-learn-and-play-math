package com.codingburg.math.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.codingburg.math.R;

public class ChoicheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choiche);
    }

    public void learnMath(View view) {
        Intent homeIntent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(homeIntent);
    }

    public void api(View view) {
        Intent homeIntent=new Intent(getApplicationContext(), FunActivity.class);
        startActivity(homeIntent);
    }
}