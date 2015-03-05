package com.pope4president.clickonthefloatybits;

import android.test.ActivityInstrumentationTestCase2;

import static com.pope4president.clickonthefloatybits.Chinchilla.clickId;
import static com.pope4president.clickonthefloatybits.Chinchilla.clickText;
import static com.pope4president.clickonthefloatybits.Chinchilla.expect;
import static com.pope4president.clickonthefloatybits.Chinchilla.getCurrentActivity;
import static com.pope4president.clickonthefloatybits.Chinchilla.getTextView;
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

    public void test_click_using_view_int_id() throws Exception {
        clickId(R.id.circle);
        clickId(R.id.square);
        expect(getView(R.id.circle)).toExist();
    }

    public void test_click_using_view_text() throws Exception {
//        ViewNodeIndex v = new ViewNodeIndex(new ViewNode(getRootView()));
        clickText(R.string.circle_text);
        clickText(R.string.square_text);
        expect(getTextView(
            getCurrentActivity().getApplicationContext().getString(R.string.circle_text)
        )).toExist();
    }
}