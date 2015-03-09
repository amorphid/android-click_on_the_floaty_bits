package com.pope4president.clickonthefloatybits;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewNodeIndex {
    public HashMap<ViewNode, Integer>           viewNodes = new HashMap<>();
    public HashMap<String, ArrayList<Integer>> textIndex = new HashMap<>();
    public HashMap<Integer, View>               idIndex   = new HashMap<>();

    public ViewNodeIndex(ViewNode node) {
        setViewNodes(node);
        indexViewNodes();
    }

    public void setViewNodes (ViewNode node) {
        // using HashMap instead of List to remove duplicates
        this.viewNodes.put(node, 0);

        for (ViewNode child : node.children) {
            setViewNodes(child);
        }
    }

    public void indexViewNodes () {
        ViewNode node;
        View     view;
        TextView textView;
        ArrayList<Integer> textIndexValue;

        for (Object key : viewNodes.keySet()) {
            node = (ViewNode) key;
            view = node.view;

            idIndex.put(view.getId(), view);

            if (node.isTextView) {
                textView = (TextView) view;

                //noinspection SuspiciousMethodCalls
                textIndexValue = textIndex.get(textView.getText());

                if (textIndexValue == null) {
                    textIndexValue = new ArrayList<>();
                }

                textIndexValue.add(textView.getId());

                textIndex.put((String) textView.getText(), textIndexValue);
            }
        }
    }
}
