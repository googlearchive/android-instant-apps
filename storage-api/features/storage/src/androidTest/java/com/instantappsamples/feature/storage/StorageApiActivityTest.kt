package com.instantappsamples.feature.storage

import android.content.Intent
import android.net.Uri
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.instantappsample.feature.storage.storage.R
import com.instantappsample.feature.storage.storage.StorageApiActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) class StorageApiActivityTest {

    @JvmField
    @Rule val testRule = object : ActivityTestRule<StorageApiActivity>(
            StorageApiActivity::class.java,
            true) {
        override fun getActivityIntent(): Intent {
            return Intent()
                    .addCategory(Intent.CATEGORY_BROWSABLE)
                    .setAction(Intent.ACTION_VIEW)
                    .setData(Uri.parse("https://storage-api.instantappsample.com/"))
        }
    };

    /**
     * Tests whether the Activity can be launched via its registered URL.
     */
    @Test fun isAddressableViaUrl() {
        onView(withText(R.string.usage)).check(matches(isDisplayed()))
    }
}
