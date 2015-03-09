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

        View circle_1 = findViewById(R.id.circle_1);

        circle_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morphShape(SquareActivity.class);
            }
        });

        try {
            setBackGroundColor(circle_1);
        } catch (IOException | JSONException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}