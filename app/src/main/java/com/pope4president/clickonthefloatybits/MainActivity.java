package com.pope4president.clickonthefloatybits;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends Activity {
    public char[] values = {
        '0', '1', '2', '3',
        '4', '5', '6', '7',
        '8', '9', 'a', 'b',
        'c', 'd', 'e', 'f'
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.circle);

        try {
            setCircleBackGroundColor(view);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String randomHexColor() throws IOException, InterruptedException, JSONException {
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread.join();

        return (String) new JSONObject(response.toString()).get("color");
    }

    public void setCircleBackGroundColor(View view) throws IOException, JSONException, InterruptedException {
        GradientDrawable shape = (GradientDrawable) view.getBackground();
        shape.setColor(Color.parseColor(randomHexColor()));
    }
}
