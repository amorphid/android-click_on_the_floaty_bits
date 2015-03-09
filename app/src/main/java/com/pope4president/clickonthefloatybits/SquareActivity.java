package com.pope4president.clickonthefloatybits;

import android.os.Bundle;
import android.view.View;

import org.json.JSONException;

import java.io.IOException;


public class SquareActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        View view = findViewById(R.id.square);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morphShape(CircleActivity.class);
            }
        });

        try {
            setBackGroundColor(view);
        } catch (IOException | JSONException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
