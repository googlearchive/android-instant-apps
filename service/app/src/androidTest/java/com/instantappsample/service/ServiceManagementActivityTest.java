package com.instantappsample.service;

import android.content.Intent;
import android.net.Uri;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ServiceManagementActivityTest {

    @Rule
    public IntentsTestRule<ServiceManagementActivity> rule =
            new IntentsTestRule<ServiceManagementActivity>(ServiceManagementActivity.class, true) {
                @Override
                protected Intent getActivityIntent() {
                    return new Intent()
                            .addCategory(Intent.CATEGORY_BROWSABLE)
                            .setAction(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://service.instantappsample.com"));
                }
            };

    /**
     * Tests whether the Activity can be launched via its registered URL.
     */
    @Test
    public void isAddressableViaUrl() {
        onView(withId(R.id.text_explanation)).check(matches(isDisplayed()));
    }

    @Test
    public void bindService() {
        onView(withText(R.string.btn_service_bind)).perform(click());
    }

    @Test
    public void unbindService() {
        onView(withText(R.string.btn_service_bind)).perform(click());

        onView(withText(R.string.btn_service_unbind)).perform(click());
    }

    @Test
    public void startService() {
        onView(withText(R.string.btn_service_start)).perform(click());
    }

    @Test
    public void stopService() {
        onView(withText(R.string.btn_service_start)).perform(click());

        onView(withText(R.string.btn_service_stop)).perform(click());
    }

}
