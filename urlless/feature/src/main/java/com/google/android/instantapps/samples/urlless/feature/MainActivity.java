/*
 * Copyright 2018 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.instantapps.samples.urlless.feature;

import android.content.Intent;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.instantapps.samples.greet.GreetActivity;
import com.google.android.play.core.splitinstall.SplitInstallHelper;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "UrlLess";

    private SplitInstallManager splitInstallManager;

    /**
     * Perform actions on callbacks of state updates for the install session.
     */
    private SplitInstallStateUpdatedListener stateListener =
            new SplitInstallStateUpdatedListener() {
        @Override
        public void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
            if (splitInstallSessionState.status() == SplitInstallSessionStatus.FAILED &&
                    splitInstallSessionState.sessionId() < 0) {
                Log.d(TAG, "Service process died");
                return;
            }
            if (splitInstallSessionState.status() == SplitInstallSessionStatus.CANCELED) {
                Log.d(TAG, "Installation cancelled");
            } else if (splitInstallSessionState.status() == SplitInstallSessionStatus.FAILED) {
                Log.e(TAG, "Install failed");
            } else if (splitInstallSessionState.status() == SplitInstallSessionStatus.INSTALLED) {
                Log.d(TAG, "Split successfully installed, launching GreetActivity");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    // Update app context with the code and resources of the installed module.
                    SplitInstallHelper.updateAppInfo(MainActivity.this);
                }
                startActivity(new Intent(MainActivity.this, GreetActivity.class));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        requestInstall();
                    }
                });

        splitInstallManager = SplitInstallManagerFactory.create(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        splitInstallManager.registerListener(stateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        splitInstallManager.unregisterListener(stateListener);
    }

    private void requestInstall() {
        SplitInstallRequest request = SplitInstallRequest.newBuilder()
                .addModule("greet")
                .build();

        splitInstallManager.startInstall(request);
    }

}
