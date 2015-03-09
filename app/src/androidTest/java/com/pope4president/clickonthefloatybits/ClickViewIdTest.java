package com.pope4president.clickonthefloatybits;

import android.test.ActivityInstrumentationTestCase2;

import static com.pope4president.clickonthefloatybits.Chinchilla.click_view_id;
import static com.pope4president.clickonthefloatybits.Chinchilla.expect;
import static com.pope4president.clickonthefloatybits.Chinchilla.get_current_activity;

public class ClickViewIdTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public ClickViewIdTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void test_click_view_id() throws Exception {
        click_view_id(R.id.test_click_view_id);
        expect(get_current_activity()).to_have_view_id(R.id.circle_1);
    }
}