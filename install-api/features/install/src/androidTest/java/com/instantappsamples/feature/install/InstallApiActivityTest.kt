package com.instantappsamples.feature.install

import android.content.Intent
import android.net.Uri
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) class InstallApiActivityTest {

    @JvmField
    @Rule val testRule = object : IntentsTestRule<InstallApiActivity>(
            InstallApiActivity::class.java,
            true) {
        override fun getActivityIntent(): Intent {
            return Intent()
                    .addCategory(Intent.CATEGORY_BROWSABLE)
                    .setAction(Intent.ACTION_VIEW)
                    .setData(Uri.parse("https://install-api.instantappsample.com/"))
        }
    };

    /**
     * Tests whether the Activity can be launched via its registered URL.
     */
    @Test fun isAddressableViaUrl() {
        onView(withText(R.string.install_text)).check(matches(isDisplayed()))
    }
}