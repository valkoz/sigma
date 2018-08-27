package com.github.valkoz.sigma;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class UITest {

    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void basicTest() {
        onView(withId(R.id.swipe_refresh))
                .check(matches(isDisplayed()));
        onView(withId(R.id.recycler_view))
                .check(matches(isDisplayed()));
    }

    @Test
    public void swipeDownTest() {
        onView(withId(R.id.recycler_view)).perform(swipeDown());
    }

    @Test
    public void swipeUpTest() {
        onView(withId(R.id.recycler_view)).perform(swipeUp());
    }

}
