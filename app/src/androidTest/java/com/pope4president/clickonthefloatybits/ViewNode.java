package com.pope4president.clickonthefloatybits;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewNode {
    public ArrayList<ViewNode> children = new ArrayList<ViewNode>();
    public boolean             isTextView;
    public boolean             isViewGroup;
    public View view;


    public ViewNode(View view) {
        try {
            this.view = (ViewGroup) view;
            this.isViewGroup = true;
        } catch (Exception e) {
            this.isViewGroup = false;
        }

        try {
            this.view = (TextView) view;
            this.isTextView = true;
        } catch (Exception e) {
            this.isTextView = false;
        }

        if (this.view == null) {
            this.view = (View) view;
        }

        if (this.isViewGroup) {
            View    child;
            int     count = 0;
            ViewNode node;

            while (true) {
                child = ((ViewGroup) this.view).getChildAt(count);

                if (child != null) {
                    children.add(new ViewNode(child));
                    count += 1;
                } else {
                    break;
                }
            }
        }
    }
}