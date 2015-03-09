package com.pope4president.clickonthefloatybits;

import android.test.ActivityInstrumentationTestCase2;

import java.util.concurrent.Callable;

import static com.pope4president.clickonthefloatybits.Chinchilla.click_text;
import static com.pope4president.clickonthefloatybits.Chinchilla.click_view_id;
import static com.pope4president.clickonthefloatybits.Chinchilla.expect;
import static com.pope4president.clickonthefloatybits.Chinchilla.get_current_activity;
import static com.pope4president.clickonthefloatybits.Chinchilla.within_view_id;

public class ClickDuplicateViewTextTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public ClickDuplicateViewTextTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
        click_view_id(R.id.test_click_duplicate_view_text);
    }

    public void test_click_duplicate_text_view_throws_exception() throws Exception {
        Callable click_event = new Callable() {
            @Override
            public Void call() throws Exception {
                click_text("I'm a circle");
                return null;
            }
        };

        expect(click_event).to_throw_exception();
    }

    public void test_click_duplicate_text_view_does_not_throw_exception() throws Exception {
        within_view_id(R.id.circle_1)
            .click_text("I'm a circle");
        expect(get_current_activity())
            .to_be_instance_of(SquareActivity.class);
    }
}