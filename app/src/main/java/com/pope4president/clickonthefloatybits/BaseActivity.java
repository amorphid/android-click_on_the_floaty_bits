package com.pope4president.clickonthefloatybits;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class BaseActivity extends Activity {
    protected ClickOnTheFloatyBits mClickOnTheFloatyBits;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mClickOnTheFloatyBits = (ClickOnTheFloatyBits)this.getApplicationContext();
    }

    protected void onResume() {
        super.onResume();
        mClickOnTheFloatyBits.setCurrentActivity(this);
    }
    protected void onPause() {
        clearReferences();
        super.onPause();
    }
    protected void onDestroy() {
        clearReferences();
        super.onDestroy();
    }

    private void clearReferences(){
        Activity currActivity = mClickOnTheFloatyBits.getCurrentActivity();
        if (currActivity != null && currActivity.equals(this))
            mClickOnTheFloatyBits.setCurrentActivity(null);
    }

    public void setBackGroundColor(View view) throws IOException, JSONException, InterruptedException {
        final GradientDrawable shape = (GradientDrawable) view.getBackground();

        final String urlString       = "http://rack-random-color.herokuapp.com/";
        URL url                      = new URL(urlString);
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        final StringBuilder response = new StringBuilder();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    while ((inputLine = reader.readLine()) != null) {
                        response.append(inputLine);
                    }
                    reader.close();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String color = (String) new JSONObject(response.toString()).get("color");
                                shape.setColor(Color.parseColor(color));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    public void morphShape(View view) {
        Class klass = (this.getClass() == CircleActivity.class) ? SquareActivity.class : CircleActivity.class;
        Intent intent = new Intent(this, klass);
        startActivity(intent);
    }
}
