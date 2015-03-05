package com.pope4president.clickonthefloatybits;

import java.util.ArrayList;

public class ViewNodeIndex {
    public ArrayList<ViewNode> viewNodes = new ArrayList<ViewNode>();

    public ViewNodeIndex(ViewNode node) {
        setViewNodes(node);
    }

    public void setViewNodes(ViewNode parent) {
        this.viewNodes.add(parent);

        for (ViewNode child : parent.children) {
            setViewNodes(child);
        }
    }
}
