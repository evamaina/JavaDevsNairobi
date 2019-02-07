package com.example.javadevsnairobi;

import android.content.pm.ActivityInfo;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import androidx.test.espresso.ViewAction;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.Espresso.onData;
import static com.googlecode.eyesfree.utils.LogUtils.TAG;
import static org.hamcrest.CoreMatchers.anything;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule public ActivityTestRule<MainActivity> mMainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        try {
            Thread.sleep(6000);
        }catch (Exception e) {
            Log.e(TAG, "Test setUp: "+e.getMessage());
        }
    }


    private  void loadIdle (){
        CountingIdlingResource mainActivityIdlingResource = mMainActivityTestRule.getActivity().getIdlingResourceInTest();
        IdlingRegistry.getInstance().register(mainActivityIdlingResource);
    }

    @Test
    public void clickOnSingleUserItemOpensDetailActivity() {

        loadIdle();
        onView(withId(R.id.my_recycler_view))
                .perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.username_detail)).check(matches(withText("k33ptoo")));
    }
    @Test
    public void testRecyclerView(){
        loadIdle();
        onView(withId(R.id.my_recycler_view))
                .check(matches(isDisplayed()));

    }


    @Test
    public void testToolbar() {
        loadIdle();
        onView(withId(R.id.toolbar_main)).check(matches(isDisplayed()));

    }

    @Test
    public void testSwipeRefreshLayout() {
        loadIdle();
        onView(withId(R.id.swipeRefresh)).check(matches(isDisplayed()));

    }

    @Test
    public void testMainActivityLayout() {
        loadIdle();
        onView(withId(R.id.main_activity)).check(matches(isDisplayed()));

    }

    @Test
    public void testRecyclerViewItemClicked() {
        loadIdle();
        onView(withId(R.id.my_recycler_view)).perform(RecyclerViewActions.scrollToPosition(5));

        onView(withId(R.id.my_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(5, click()));
    }

    @Test
    public void testSearchUserText() {
        loadIdle();
        onView(withId(R.id.txtSearch)).check(matches(isDisplayed()));

    }
    @Test
    public void testCoordinatorLayout() {
        loadIdle();
        onView(withId(R.id.main_activity)).check(matches(isDisplayed()));

    }





}
