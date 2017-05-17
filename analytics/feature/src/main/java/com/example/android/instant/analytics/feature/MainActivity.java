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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.android.instantapps.InstantApps;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    // Declare and initialize onClickListener that sends an ECOMMERCE_PURCHASE event to Analytics.
    private View.OnClickListener mOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            // Get order details.
            EditText txtbxOrderNumber = (EditText)findViewById(R.id.txtbx_order_number);
            int orderId = Integer.parseInt(txtbxOrderNumber.getText().toString());

            EditText txtbxOrderAmount = (EditText)findViewById(R.id.txtbx_order_amount);
            double orderAmount = Double.parseDouble(txtbxOrderAmount.getText().toString());

            EditText txtbxCurrency = (EditText)findViewById(R.id.txtbx_currency);
            String orderCurrency = txtbxCurrency.getText().toString();

            // Create event details bundle.
            Bundle bundle = new Bundle();
            bundle.putInt(FirebaseAnalytics.Param.TRANSACTION_ID, orderId);
            bundle.putDouble(FirebaseAnalytics.Param.VALUE, orderAmount);
            bundle.putString(FirebaseAnalytics.Param.CURRENCY, orderCurrency);
            mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.ECOMMERCE_PURCHASE, bundle);

            Toast toast = Toast.makeText(getApplicationContext(),
                    String.format(Locale.US,
                            getString(R.string.order_details_format),
                            orderId, orderAmount, orderCurrency),
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,
                    0, 0);
            toast.show();
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        TextView textViewInstant = (TextView) findViewById(R.id.instant_status_text);
        String status = "";

        // Determine the current app context, either installed or instant, then
        // set the corresponding user property for Google Analytics.
        if (InstantApps.isInstantApp(this)) {
            status = getString(R.string.status_instant);
        } else {
            status = getString(R.string.status_installed);
        }

        mFirebaseAnalytics.setUserProperty(getString(R.string.analytics_user_prop),
                status);

        // Add button click handler to raise ecommerce purchase event.
        Button btnSendECommerceEvent = (Button)findViewById(R.id.btn_send_ecommerce_event);
        btnSendECommerceEvent.setOnClickListener(mOnClickListener);

        textViewInstant.setText(String.format(getString(R.string.lbl_status_text),
                status));
    }
}
