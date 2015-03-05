package com.pope4president.clickonthefloatybits;

import android.app.Activity;
import android.view.View;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

public class Chinchilla {

    public static Expect expect(View view) {
        return new Expect(view);
    }

    public static void click(final int viewId) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                View view = getView(viewId);
                view.performClick();
            }
        };

        getCurrentActivity().runOnUiThread(runnable);

        getInstrumentation().waitForIdleSync();
    }

    public static Activity getCurrentActivity() {
        return ClickOnTheFloatyBits.getCurrentActivity();
    }

    public static View getView(int viewId) {
        return getCurrentActivity().findViewById(viewId);
    }

    public static View getRootView() {
        return getCurrentActivity()
                   .getWindow()
                   .getDecorView()
                   .getRootView();
    }

}
