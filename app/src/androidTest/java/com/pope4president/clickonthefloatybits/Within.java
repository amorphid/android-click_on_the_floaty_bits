package com.pope4president.clickonthefloatybits;

import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static com.pope4president.clickonthefloatybits.Chinchilla.get_current_activity;
import static com.pope4president.clickonthefloatybits.Chinchilla.get_view;

public class Within {
    public ViewNodeIndex viewNodeIndex;


    public Within(int view_id) {
        this.viewNodeIndex = get_view_node_index(view_id);
    }

    public void click_text(String view_text) throws Exception {
        final View view = get_text_view(view_text);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                view.performClick();
            }
        };

        get_current_activity().runOnUiThread(runnable);
        getInstrumentation().waitForIdleSync();
    }

    public ViewNodeIndex get_view_node_index (int view_id) {
        ViewNode viewNode = get_view_node(view_id);
        return new ViewNodeIndex(viewNode);
    }

    public ViewNode get_view_node (int view_id) {
        View view = get_current_activity().findViewById(view_id);
        return new ViewNode(view);
    }

    public View get_text_view(String view_text) throws Exception {
        int view_id = get_text_view_id(view_text);
        return get_view(view_id);
    }

    public int get_text_view_id (String view_text) throws Exception {
        HashMap<String, ArrayList<Integer>> textIndex          = viewNodeIndex.textIndex;
        ArrayList<Integer>                  text_view_ids_list = textIndex.get(view_text);
        vet_text_view_list(text_view_ids_list);
        return text_view_ids_list.get(0);
    }

    public void vet_text_view_list (ArrayList<Integer> text_view_ids_list) throws Exception {
        boolean has_one_element = (text_view_ids_list.size() == 1);
        if (!has_one_element) {
            throw new Exception();
        }
    }
}
