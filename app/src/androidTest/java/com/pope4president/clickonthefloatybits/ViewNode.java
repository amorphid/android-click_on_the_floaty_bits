package com.pope4president.clickonthefloatybits;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewNode {
    public ArrayList<ViewNode> children    = new ArrayList<ViewNode>();
    public boolean             isTextView  = false;
    public boolean             isViewGroup = false;
    public String              text;
    public View                view;

    public ViewNode(View view) {
        setView(view);

        if (view instanceof ViewGroup) {
            setViewGroup((ViewGroup) view);
        }

        if (view instanceof TextView) {
            setTextView((TextView) view);
        }
    }

    public void setView (View view) {
        this.view = view;
    }

    public void setTextView (TextView view) {
        this.isTextView = true;
        this.text       = (String) view.getText();
    }

    public void setViewGroup (ViewGroup view) {
        this.isViewGroup = true;
        setViewGroupChildren(view, 0);
    }

    public void setViewGroupChildren (ViewGroup parent, int position) {
        View child = parent.getChildAt(position);

        if (child != null) {
            children.add(new ViewNode(child));
            setViewGroupChildren(parent, position + 1);
        }
    }
}