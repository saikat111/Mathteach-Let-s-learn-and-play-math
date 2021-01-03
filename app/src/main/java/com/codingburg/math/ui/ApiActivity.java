package com.codingburg.math.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.codingburg.math.R;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiActivity extends AppCompatActivity {
    private TextView data;
    private String key1, key2, type;
    private SimpleArcLoader simpleArcLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        data = findViewById(R.id.data);
        simpleArcLoader = findViewById(R.id.loader);
        try {
            type = getIntent().getExtras().getString("type");
            key1 = getIntent().getExtras().getString("key");
            key2 = getIntent().getExtras().getString("key2");

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(type.equals("number") ){

            numberData();

        }
        else if(type.equals("year")){

            yearData();

        }
        else if(type.equals("date_months") ){

            dateMonths();

        }
        else if(type.equals("random")){

            random();

        }

    }

    private void random() {
        simpleArcLoader.start();
        String url  = "http://numbersapi.com/random/year?json";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            data.setText(jsonObject.getString("text"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);
                        }

                        simpleArcLoader.stop();
                        simpleArcLoader.setVisibility(View.GONE);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ApiActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void dateMonths() {
        simpleArcLoader.start();
        String url1  = "http://numbersapi.com/";
        String url = url1 + key1 +"/" + key2 +"?json";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            data.setText(jsonObject.getString("text"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);
                        }

                        simpleArcLoader.stop();
                        simpleArcLoader.setVisibility(View.GONE);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ApiActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void yearData() {
        simpleArcLoader.start();
        String url1  = "http://numbersapi.com/";
        String url = url1 + key1 +"/" +"year?json";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            data.setText(jsonObject.getString("text"));
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                        simpleArcLoader.stop();
                        simpleArcLoader.setVisibility(View.GONE);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ApiActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void numberData() {
        simpleArcLoader.start();
        String url1  = "http://numbersapi.com/";
        String url = url1 + key1  +"?json";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            data.setText(jsonObject.getString("text"));
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                        simpleArcLoader.stop();
                        simpleArcLoader.setVisibility(View.GONE);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ApiActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void back(View view) {
        Intent homeIntent=new Intent(getApplicationContext(), FunActivity.class);
        startActivity(homeIntent);
        finish();
    }
}