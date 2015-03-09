package com.pope4president.clickonthefloatybits;

import android.test.ActivityInstrumentationTestCase2;

import static com.pope4president.clickonthefloatybits.Chinchilla.click_text;
import static com.pope4president.clickonthefloatybits.Chinchilla.expect;
import static com.pope4president.clickonthefloatybits.Chinchilla.get_current_activity;

public class ClickViewTextTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public ClickViewTextTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void test_click_view_text() throws Exception {
        click_text("Test Click View Text");
        expect(get_current_activity()).to_have_text("Hey look, a square");
    }
}