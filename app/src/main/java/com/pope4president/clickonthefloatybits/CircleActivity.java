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
//        View circle_2 = findViewById(R.id.circle_2);

        circle_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morphShape(v);
            }
        });

//        circle_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                morphShape(v);
//            }
//        });

        try {
            setBackGroundColor(circle_1);
//            setBackGroundColor(circle_2);
        } catch (IOException | JSONException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}