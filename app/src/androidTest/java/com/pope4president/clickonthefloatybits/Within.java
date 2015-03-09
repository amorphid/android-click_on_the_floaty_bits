package com.pope4president.clickonthefloatybits;

import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static com.pope4president.clickonthefloatybits.Chinchilla.get_current_activity;
import static com.pope4president.clickonthefloatybits.Chinchilla.get_view;

public class Within {
    public int view_id;

    public Within(int view_id) {
        this.view_id = view_id;
    }

    public void click_text(String view_text) throws Exception {
        ViewNodeIndex                       viewNodeIndex = new ViewNodeIndex(new ViewNode(get_view(view_id)));
        HashMap<String, ArrayList<Integer>> textIndex     = viewNodeIndex.textIndex;
        ArrayList<Integer> textIndexValue                 = textIndex.get(view_text);

        if (textIndexValue.size() == 1) {
            final View view = viewNodeIndex.idIndex.get(textIndexValue.get(0));

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    view.performClick();
                }
            };

            get_current_activity().runOnUiThread(runnable);
            getInstrumentation().waitForIdleSync();

        } else {
            throw new Exception();
        }
    }
}
