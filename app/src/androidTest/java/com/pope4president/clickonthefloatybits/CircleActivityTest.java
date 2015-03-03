package com.pope4president.clickonthefloatybits;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

public class CircleActivityTest extends ActivityInstrumentationTestCase2<CircleActivity> {
    public CircleActivityTest() {
        super(CircleActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testShapeMorph() {
        click(R.id.circle);
        click(R.id.square);
        expect(getView(R.id.circle)).toExist();
    }

    public Expect expect(View view) {
        return new Expect(view);
    }

    public void click(final int viewId) {
        getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View view = getView(viewId);
                view.performClick();
            }
        });

        getInstrumentation().waitForIdleSync();
    }

    public Activity getCurrentActivity() {
        return ((ClickOnTheFloatyBits) getActivity().getApplicationContext()).getCurrentActivity();
    }

    public View getView(int viewId) {
        return getCurrentActivity().findViewById(viewId);
    }
}