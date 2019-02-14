package com.instantappsample.storage

import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
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