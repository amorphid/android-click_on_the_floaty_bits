package com.pope4president.clickonthefloatybits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity activity = this;

        findViewById(R.id.test_click_view_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, CircleActivity.class));
            }
        });

        findViewById(R.id.test_click_view_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, SquareActivity.class));
            }
        });

        findViewById(R.id.test_click_duplicate_view_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, TwoCircleActivity.class));
            }
        });
    }
}
