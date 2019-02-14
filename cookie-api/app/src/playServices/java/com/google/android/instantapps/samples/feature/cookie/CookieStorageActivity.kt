package com.google.android.instantapps.samples.feature.cookie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.instantapps.InstantApps
import java.nio.charset.Charset

/**
 * Demonstrates usage of the Instant App Cookie API via the InstantApps Play Services.
 * This can be accessed from any Instant App and installable app regardless of API level.
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
 * First check if the cookie fits, by calling `packageManagerCompat.getInstantAppCookieMaxSize` and
 * comparing the result against the cookie size.
 *
 * Then store the cookie via `packageManagerCompat.setInstantAppCookie(...)`.
 * The cookie can be read and cleared as well, via `packageManagerCompat.getInstantAppCookie`
 * and `packageManager.setInstantAppCookie(null)`.
 *
 * @see [com.google.android.gms.instantapps.PackageManagerCompat.setInstantAppCookie]
 * @see [com.google.android.gms.instantapps.PackageManagerCompat.getInstantAppCookie]
 * @see [com.google.android.gms.instantapps.PackageManagerCompat.getInstantAppCookieMaxSize]
 */
class CookieStorageActivity : AppCompatActivity() {

    private var input: EditText? = null
    private val packageManagerCompat by lazy { InstantApps.getPackageManagerCompat(this) }

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

        input?.setText(result)
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()
    }

    /**
     * Updates the Instant App Cookie if the amount of data to be stored is smaller than the
     * max allowed size.
     */
    private fun updateCookieClick(): String {
        val cookieContent = input?.text.toString().toByteArray(Charsets.UTF_8)

        with(packageManagerCompat) {
            if (cookieContent.size <= instantAppCookieMaxSize) {
                // Store the new cookie.
                instantAppCookie = cookieContent
                return "Stored:" +
                        "\n${cookieContent.toString(Charset.defaultCharset())}" +
                        "\nStored / Max size: " +
                        "${cookieContent.size} / $instantAppCookieMaxSize"
            }
            return "Tried to store too much information"
        }
    }

    /**
     * Reads the Instant App Cookie
     */
    private fun readCookie() = packageManagerCompat.instantAppCookie?.toString(Charsets.UTF_8)
            ?: "No stored cookie"


    /**
     * Clear the Instant App Cookie
     */
    private fun clearCookie(): String {
        packageManagerCompat.instantAppCookie = null
        return "Cookie cleared"

    }

}
