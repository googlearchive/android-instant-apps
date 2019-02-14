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

package com.example.android.instant.analytics;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
        onView(withText(com.example.android.instant.analytics.R.string.btn_send_ecommerce_event)).check(matches(isDisplayed()));
    }

    @Test
    public void submitDisabledWhileDataIncomplete() {
        checkButtonDisabled();

        onView(withId(com.example.android.instant.analytics.R.id.txtbx_currency)).perform(typeText("EUR"));
        checkButtonDisabled();
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_currency)).perform(clearText());

        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_amount)).perform(typeText("100"));
        checkButtonDisabled();
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_amount)).perform(clearText());

        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_number)).perform(typeText("1"));
        checkButtonDisabled();
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_number)).perform(clearText());

        onView(withId(com.example.android.instant.analytics.R.id.txtbx_currency)).perform(typeText("EUR"));
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_amount)).perform(typeText("100"));
        checkButtonDisabled();
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_currency)).perform(clearText());
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_amount)).perform(clearText());

        onView(withId(com.example.android.instant.analytics.R.id.txtbx_currency)).perform(typeText("EUR"));
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_number)).perform(typeText("1"));
        checkButtonDisabled();
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_currency)).perform(clearText());
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_number)).perform(clearText());

        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_amount)).perform(typeText("100"));
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_number)).perform(typeText("1"));
        checkButtonDisabled();
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_amount)).perform(clearText());
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_number)).perform(clearText());

    }

    @Test
    public void submitData() {
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_currency)).perform(typeText("EUR"));
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_amount)).perform(typeText("100"));
        onView(withId(com.example.android.instant.analytics.R.id.txtbx_order_number)).perform(typeText("1"));

        onView(withId(com.example.android.instant.analytics.R.id.btn_send_ecommerce_event)).perform(click());
    }

    @NonNull
    private void checkButtonDisabled() {
        onView(withId((com.example.android.instant.analytics.R.id.btn_send_ecommerce_event))).check(matches(not(isEnabled())));
    }

}
