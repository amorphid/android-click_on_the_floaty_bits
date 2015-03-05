package com.pope4president.clickonthefloatybits;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewNodeIndex {
    public ArrayList<ViewNode> viewNodes = new ArrayList<ViewNode>();
    public HashMap             textIndex = new HashMap();

    public ViewNodeIndex(ViewNode node) {
        setViewNodes(node);
    }

    public void setViewNodes(ViewNode parent) {
        this.viewNodes.add(parent);

        for (ViewNode child : parent.children) {
            setViewNodes(child);
        }

        for (ViewNode node : viewNodes) {
            if (node.isTextView) {
                TextView textView = (TextView) node.view;
                textIndex.put(textView.getText(), textView);
            }
        }
    }
}
