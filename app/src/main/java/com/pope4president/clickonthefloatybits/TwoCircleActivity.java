package com.pope4president.clickonthefloatybits;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import org.json.JSONException;

import java.io.IOException;


public class TwoCircleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_circle);

        View            circle_1 = findViewById(R.id.circle_1);
        View            circle_2 = findViewById(R.id.circle_2);
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                morphShape(SquareActivity.class);
            }
        };

        circle_1.setOnClickListener(listener);
        circle_2.setOnClickListener(listener);

        try {
            setBackGroundColor(circle_1);
            setBackGroundColor(circle_2);
        } catch (IOException | JSONException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
