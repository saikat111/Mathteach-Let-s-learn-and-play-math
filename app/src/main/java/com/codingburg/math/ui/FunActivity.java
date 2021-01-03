package com.codingburg.math.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.codingburg.math.R;
import com.codingburg.math.utils.DateMonths;
import com.codingburg.math.utils.InputBox;
import com.codingburg.math.utils.InputYear;

public class FunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun);
    }

    public void number(View view) {
        openDialog();
    }

    public void date(View view) {
        openDialog3();
    }

    public void year(View view) {
        openDialog2();
    }

    public void random(View view) {
        Intent intent = new Intent(getApplicationContext(), ApiActivity.class);
        intent.putExtra("type", "random");
        startActivity(intent);
    }
    public void openDialog() {
        InputBox exampleDialog = new InputBox();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    public void openDialog2() {
        InputYear exampleDialog = new InputYear();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
    public void openDialog3() {
        DateMonths exampleDialog = new DateMonths();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
}