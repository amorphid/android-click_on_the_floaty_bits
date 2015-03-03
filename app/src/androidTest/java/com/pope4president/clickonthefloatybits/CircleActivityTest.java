package com.pope4president.clickonthefloatybits;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class CircleActivityTest extends ActivityInstrumentationTestCase2<CircleActivity> {
    public CircleActivityTest() {
        super(CircleActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testShapeMorph() {
        onView(withId(R.id.circle))
            .perform(click());

        onView(withId(R.id.square))
            .perform(click());

        onView(withId(R.id.circle))
            .check(matches(isDisplayed()));

        onView(withId(R.id.square))
            .check(doesNotExist());
    }
}