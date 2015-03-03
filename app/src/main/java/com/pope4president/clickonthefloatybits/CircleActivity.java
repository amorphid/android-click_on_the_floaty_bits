package com.pope4president.clickonthefloatybits;

import android.os.Bundle;
import android.view.View;

import org.json.JSONException;

import java.io.IOException;


public class CircleActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        View view = findViewById(R.id.circle);

        try {
            setBackGroundColor(view);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}