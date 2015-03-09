package com.pope4president.clickonthefloatybits;

import android.app.Activity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

public class Chinchilla {

    public static Expect expect(Activity activity) {
        return new Expect(activity);
    }

    public static Expect expect(Callable callable) {
        return new Expect(callable);
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

    public static void click_text(final String text) throws Exception {
        final View[] view = new View[1];

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    view[0] = get_text_view(text);
                    view[0].performClick();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        get_current_activity().runOnUiThread(runnable);
        getInstrumentation().waitForIdleSync();

        if (!(view[0] instanceof View)) {
            throw new Exception();
        }
    }

    public static Activity get_current_activity() {
        return ClickOnTheFloatyBits.getCurrentActivity();
    }

    public static View get_view(int view_id) {
        return get_current_activity().findViewById(view_id);
    }

    public static View get_text_view(String viewText) throws Exception {
        ViewNodeIndex viewNodeIndex = new ViewNodeIndex(
            new ViewNode(
                get_root_view(
                    get_current_activity()
                )
            )
        );
        HashMap<String, ArrayList<Integer>> textIndex = viewNodeIndex.textIndex;

        ArrayList<Integer> textIndexValue = textIndex.get(viewText);

        if (textIndexValue.size() == 1) {
            return viewNodeIndex.idIndex.get(textIndexValue.get(0));
        } else {
            throw new Exception();
        }
    }

    public static View get_root_view(Activity activity) {
        return activity.getWindow()
                       .getDecorView()
                       .getRootView();
    }

}
