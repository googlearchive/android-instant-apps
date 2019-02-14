package com.google.android.instantapps.samples.install

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.google.android.gms.instantapps.InstantApps

/**
 * An Activity that shows usage of the Install API, [documented here](https://developer.android.com/topic/instant-apps/reference.html#showinstallprompt).
 *
 * This sample does not have an installed app counterpart from the Play Store.
 * To see how this sample works, follow the instructions in the accompanying README.md
 */
class InstallApiActivity : AppCompatActivity() {
    /**
     * Intent to launch after the app has been installed.
     */
    private val postInstallIntent = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://install-api.instantappsample.com/")).
            addCategory(Intent.CATEGORY_BROWSABLE).
            putExtras(Bundle().apply {
                putString("The key to", "sending data via intent")
            })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_install)
        val isInstantApp = InstantApps.getPackageManagerCompat(this).isInstantApp
        findViewById<Button>(R.id.start_installation).apply {
            isEnabled = isInstantApp
            // Show the installation prompt only for an instant app.
            if (isInstantApp) {
                setOnClickListener {
                    InstantApps.showInstallPrompt(this@InstallApiActivity,
                            postInstallIntent,
                            REQUEST_CODE,
                            REFERRER)
                }
            }
        }
    }

    companion object {
        private val REFERRER = "InstallApiActivity"
        private val REQUEST_CODE = 7
    }
}
