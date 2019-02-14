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

package com.google.android.instantapps.samples.feature.cookie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.nio.charset.Charset

/**
 * Demonstrates usage of the Instant App Cookie API within the Framework.
 * This can be accessed from API 26 onwards.
 *
 * **Cookie API TL;DR:**
 *
 * The Cookie API is available to both the instant and installed app.
 * It can be used to transfer user data out of the instant app, making the migration to the
 * installed app seamless.
 *
 * **When in an Instant App context,
 * the cookie will get cleared together with the app at some point.**
 *
 * **Usage:**
 *
 * First check if the cookie fits, by calling `packageManager#instantAppCookieMaxBytes` and
 * comparing the result against the cookie size.
 *
 * Then store the cookie via `packageManager#updateInstantAppCookie(...)`.
 * The cookie can be read and cleared as well, via `packageManager.getInstantAppCookie`
 * and `packageManager.clearInstantAppCookie()`.
 *
 * @see [android.content.pm.PackageManager.updateInstantAppCookie]
 * @see [android.content.pm.PackageManager.getInstantAppCookie]
 * @see [android.content.pm.PackageManager.clearInstantAppCookie]
 */
class CookieStorageActivity : AppCompatActivity() {

    private var input: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        input = findViewById(R.id.cookie_text)
        findViewById<View>(R.id.update_cookie).setOnClickListener(clickListener)
        findViewById<View>(R.id.read_cookie).setOnClickListener(clickListener)
        findViewById<View>(R.id.clear_cookie).setOnClickListener(clickListener)
    }

    /**
     * Click listener
     */
    private val clickListener = View.OnClickListener {
        val result = when (it.id) {
            R.id.update_cookie -> updateCookieClick()
            R.id.read_cookie -> readCookie()
            R.id.clear_cookie -> clearCookie()
            else -> "Click handler not defined"
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()
    }

    /**
     * Updates the Instant App Cookie if the amount of data to be stored is smaller than the
     * max allowed size.
     */
    private fun updateCookieClick(): String {

        return with(packageManager) {
            val cookieContent = input?.text.toString().toByteArray(Charsets.UTF_8)
            // Check if the new cookie fits the size limit.
            if (cookieContent.size <= instantAppCookieMaxBytes) {
                // Store the new cookie.
                updateInstantAppCookie(cookieContent)
                return@with "Stored:" +
                        "\n${cookieContent.toString(Charset.defaultCharset())}" +
                        "\nStored / Max size: " +
                        "${cookieContent.size} / $instantAppCookieMaxBytes"
            }
            return@with "Tried to store too much information."
        }
    }

    /**
     * Reads the Instant App Cookie
     */
    private fun readCookie() = packageManager.instantAppCookie.toString(Charsets.UTF_8)

    /**
     * Clear the Instant App Cookie
     */
    private fun clearCookie(): String {
        packageManager.clearInstantAppCookie()
        return "Cookie cleared"
    }
}
