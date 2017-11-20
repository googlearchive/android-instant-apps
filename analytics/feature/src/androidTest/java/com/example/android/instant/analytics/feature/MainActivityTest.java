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

package com.example.android.instant.analytics.feature;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule rule = new ActivityTestRule<MainActivity>(MainActivity.class, true) {
        @Override
        protected Intent getActivityIntent() {
            return new Intent()
                    .addCategory(Intent.CATEGORY_BROWSABLE)
                    .setAction(Intent.ACTION_VIEW)
                    .setData(Uri.parse("https://instant.android.example.com/analytics"));
        }
    };

    @Test
    public void isAddressableViaUrl() {
        onView(withText(R.string.btn_send_ecommerce_event)).check(matches(isDisplayed()));
    }

    @Test
    public void submitDisabledWhileDataIncomplete() {
        checkButtonDisabled();

        onView(withId(R.id.txtbx_currency)).perform(typeText("EUR"));
        checkButtonDisabled();
        onView(withId(R.id.txtbx_currency)).perform(clearText());

        onView(withId(R.id.txtbx_order_amount)).perform(typeText("100"));
        checkButtonDisabled();
        onView(withId(R.id.txtbx_order_amount)).perform(clearText());

        onView(withId(R.id.txtbx_order_number)).perform(typeText("1"));
        checkButtonDisabled();
        onView(withId(R.id.txtbx_order_number)).perform(clearText());

        onView(withId(R.id.txtbx_currency)).perform(typeText("EUR"));
        onView(withId(R.id.txtbx_order_amount)).perform(typeText("100"));
        checkButtonDisabled();
        onView(withId(R.id.txtbx_currency)).perform(clearText());
        onView(withId(R.id.txtbx_order_amount)).perform(clearText());

        onView(withId(R.id.txtbx_currency)).perform(typeText("EUR"));
        onView(withId(R.id.txtbx_order_number)).perform(typeText("1"));
        checkButtonDisabled();
        onView(withId(R.id.txtbx_currency)).perform(clearText());
        onView(withId(R.id.txtbx_order_number)).perform(clearText());

        onView(withId(R.id.txtbx_order_amount)).perform(typeText("100"));
        onView(withId(R.id.txtbx_order_number)).perform(typeText("1"));
        checkButtonDisabled();
        onView(withId(R.id.txtbx_order_amount)).perform(clearText());
        onView(withId(R.id.txtbx_order_number)).perform(clearText());

    }

    @Test
    public void submitData() {
        onView(withId(R.id.txtbx_currency)).perform(typeText("EUR"));
        onView(withId(R.id.txtbx_order_amount)).perform(typeText("100"));
        onView(withId(R.id.txtbx_order_number)).perform(typeText("1"));

        onView(withId(R.id.btn_send_ecommerce_event)).perform(click());
    }

    @NonNull
    private void checkButtonDisabled() {
        onView(withId((R.id.btn_send_ecommerce_event))).check(matches(not(isEnabled())));
    }

}