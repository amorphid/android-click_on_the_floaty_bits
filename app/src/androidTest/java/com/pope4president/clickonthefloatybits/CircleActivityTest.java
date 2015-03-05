package com.pope4president.clickonthefloatybits;

import android.test.ActivityInstrumentationTestCase2;

import static com.pope4president.clickonthefloatybits.Chinchilla.click;
import static com.pope4president.clickonthefloatybits.Chinchilla.expect;
import static com.pope4president.clickonthefloatybits.Chinchilla.getRootView;
import static com.pope4president.clickonthefloatybits.Chinchilla.getView;

public class CircleActivityTest extends ActivityInstrumentationTestCase2<CircleActivity> {
    public CircleActivityTest() {
        super(CircleActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testShapeMorph() throws Exception {
        ViewNodeIndex v = new ViewNodeIndex(new ViewNode(getRootView()));
        click(R.id.circle);
        click(R.id.square);
        expect(getView(R.id.circle)).toExist();
    }
}