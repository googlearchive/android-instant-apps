package com.instantappsamples.feature.hello

import android.content.Intent
import android.net.Uri
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasAction
import android.support.test.espresso.intent.matcher.IntentMatchers.hasCategories
import android.support.test.espresso.intent.matcher.IntentMatchers.hasData
import android.support.test.espresso.intent.matcher.UriMatchers.hasHost
import android.support.test.espresso.intent.matcher.UriMatchers.hasPath
import android.support.test.espresso.intent.matcher.UriMatchers.hasScheme
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.hasItem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class) class HelloActivityTest {

    @JvmField
    @Rule val testRule = object : IntentsTestRule<HelloActivity>(HelloActivity::class.java, true) {
        override fun getActivityIntent(): Intent {
            return Intent()
                    .addCategory(Intent.CATEGORY_BROWSABLE)
                    .setAction(Intent.ACTION_VIEW)
                    .setData(Uri.parse("https://hello-feature.instantappsample.com/hello"))
        }
    };

    @Test fun isAddressableViaUrl() {
        onView(withText(R.string.hello_instant_world)).check(matches(isDisplayed()))
    }

    /**
     * Tests whether the Intent to open GoodbyeActivity is correctly assembled and fired upon
     * button click.
     */
    @Test fun testUrlForGoodbyeFeature() {
        onView(withId(R.id.button)).perform(click())

        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasCategories(hasItem<String>(equalTo<String>(Intent.CATEGORY_BROWSABLE))),
                hasData(allOf(hasHost(equalTo<String>("hello-feature.instantappsample.com")),
                        hasScheme(equalTo<String>("https")),
                        hasPath(equalTo<String>("/goodbye"))))))
    }

}