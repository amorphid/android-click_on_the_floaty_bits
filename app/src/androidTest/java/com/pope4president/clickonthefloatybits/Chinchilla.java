package com.pope4president.clickonthefloatybits;

import android.app.Activity;
import android.view.View;

import java.util.HashMap;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

public class Chinchilla {

    public static Expect expect(Activity activity) {
        return new Expect(activity);
    }

    public static void click_view_id(final int view_id) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                View view = get_view(view_id);
                view.performClick();
            }
        };

        get_current_activity().runOnUiThread(runnable);

        getInstrumentation().waitForIdleSync();
    }

    public static void click_text(final String text) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                View view = get_text_view(text);
                view.performClick();
            }
        };

        get_current_activity().runOnUiThread(runnable);

        getInstrumentation().waitForIdleSync();
    }

    public static Activity get_current_activity() {
        return ClickOnTheFloatyBits.getCurrentActivity();
    }

    public static View get_view(int view_id) {
        return get_current_activity().findViewById(view_id);
    }

    public static View get_text_view(String viewText) {
        HashMap textIndex = new ViewNodeIndex(
            new ViewNode(
                get_root_view(
                    get_current_activity()
                )
            )
        ).textIndex;

        return (View) textIndex.get(viewText);
    }

    public static View get_root_view(Activity activity) {
        return activity.getWindow()
                       .getDecorView()
                       .getRootView();
    }

}
