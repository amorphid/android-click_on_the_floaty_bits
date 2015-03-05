package com.pope4president.clickonthefloatybits;

import android.app.Activity;
import android.view.View;

import java.util.HashMap;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

public class Chinchilla {

    public static Expect expect(View view) {
        return new Expect(view);
    }

    public static void clickId(final int viewId) {
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

    public static void clickText(final int textViewId) {
        final String textViewText = getCurrentActivity().getApplicationContext().getString(textViewId);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                View view = getTextView(textViewText);
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
        HashMap iDindex = new ViewNodeIndex(new ViewNode(getRootView())).idIndex;

        return (View) iDindex.get(viewId);
    }

    public static View getTextView(String viewText) {
        HashMap textIndex = new ViewNodeIndex(new ViewNode(getRootView())).textIndex;

        return (View) textIndex.get(viewText);
    }

    public static View getRootView() {
        return getCurrentActivity()
                   .getWindow()
                   .getDecorView()
                   .getRootView();
    }

}
