package com.pope4president.clickonthefloatybits;

import android.test.ActivityInstrumentationTestCase2;

import static com.pope4president.clickonthefloatybits.Chinchilla.click_text;
import static com.pope4president.clickonthefloatybits.Chinchilla.click_view_id;
import static com.pope4president.clickonthefloatybits.Chinchilla.expect;
import static com.pope4president.clickonthefloatybits.Chinchilla.get_current_activity;

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
        click_view_id(R.id.circle);
        click_view_id(R.id.square);
        expect(get_current_activity()).to_have_view_id(R.id.circle);
    }

    public void test_click_using_view_text() throws Exception {
        click_text("I'm a circle");
        click_text("Hey look, a square");
        expect(get_current_activity()).to_have_text("I'm a circle");
    }
}