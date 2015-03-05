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

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morphShape(v);
            }
        });

        try {
            setBackGroundColor(view);
        } catch (IOException | JSONException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}