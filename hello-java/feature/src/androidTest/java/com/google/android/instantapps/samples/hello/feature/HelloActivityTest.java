/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.instantapps.samples.hello.feature;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class HelloActivityTest {

    @Rule
    public ActivityTestRule<HelloActivity> activityRule
            = new ActivityTestRule<HelloActivity>(HelloActivity.class, true) {
        @Override
        protected Intent getActivityIntent() {
            return new Intent()
                    .addCategory(Intent.CATEGORY_BROWSABLE)
                    .setAction(Intent.ACTION_VIEW)
                    .setData(Uri.parse("https://hello-flavors.instantappsample.com/hello"));
        }
    };

    /**
     * Tests whether the Activity can be launched via its registered URL.
     */
    @Test
    public void isAddressableViaUrl() {
        onView(withText(R.string.hello_instant_world)).check(matches(isDisplayed()));
    }

    /**
     * Tests whether the button click leads to GoodbyeActivity.
     */
    @Test
    public void navigateToGoodbyeActivity() {
        onView(withId(R.id.button)).perform(click());
        onView(withText(R.string.goodbye_instant_world)).check(matches(isDisplayed()));
    }
}
