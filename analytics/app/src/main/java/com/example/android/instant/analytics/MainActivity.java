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

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    private EditText mTxtbxOrderNumber;
    private EditText mTxtbxOrderAmount;
    private EditText mTxtbxCurrency;

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
            status = getString(com.example.android.instant.analytics.R.string.status_installed);
        }

        mFirebaseAnalytics.setUserProperty(getString(com.example.android.instant.analytics.R.string.analytics_user_prop),
                status);

        // Set a TextWatcher to make sure that the user doesn't attempt to
        // submit when a EditText is empty.
        TextWatcher enableButtonOnTextChanged = setEnableButtonOnTextChange();

        mTxtbxOrderNumber = (EditText) findViewById(R.id.txtbx_order_number);
        mTxtbxOrderNumber.addTextChangedListener(enableButtonOnTextChanged);

        mTxtbxOrderAmount = (EditText) findViewById(R.id.txtbx_order_amount);
        mTxtbxOrderAmount.addTextChangedListener(enableButtonOnTextChanged);

        mTxtbxCurrency= (EditText) findViewById(R.id.txtbx_currency);
        mTxtbxCurrency.addTextChangedListener(enableButtonOnTextChanged);

        // Add button click handler to raise e-commerce purchase event.
        Button btnSendECommerceEvent = (Button)findViewById(R.id.btn_send_ecommerce_event);
        btnSendECommerceEvent.setEnabled(false);
        btnSendECommerceEvent.setOnClickListener(mOnClickListener);

        textViewInstant.setText(String.format(getString(com.example.android.instant.analytics.R.string.lbl_status_text),
                status));
    }

    // Declare and initialize onClickListener that sends an ECOMMERCE_PURCHASE event to Analytics.
    private View.OnClickListener mOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

        // Get order details.
        int orderId = Integer.parseInt(mTxtbxOrderNumber.getText().toString());
        double orderAmount = Double.parseDouble(mTxtbxOrderAmount.getText().toString());
        String orderCurrency = mTxtbxCurrency.getText().toString();

        // Create event details bundle.
        Bundle bundle = new Bundle();
        bundle.putInt(FirebaseAnalytics.Param.TRANSACTION_ID, orderId);
        bundle.putDouble(FirebaseAnalytics.Param.VALUE, orderAmount);
        bundle.putString(FirebaseAnalytics.Param.CURRENCY, orderCurrency);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.ECOMMERCE_PURCHASE, bundle);

        Toast.makeText(getApplicationContext(),
                String.format(Locale.US,
                        getString(com.example.android.instant.analytics.R.string.order_details_format),
                        orderId, orderAmount, orderCurrency),
                Toast.LENGTH_SHORT)
                .show();
        }
    };

    // Create a TextWatcher to enable the submit button when all text fields are populated.
    private TextWatcher setEnableButtonOnTextChange(){
        return new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Button btnSendECommerceEvent = (Button) findViewById(R.id.btn_send_ecommerce_event);
                btnSendECommerceEvent.setEnabled(!mTxtbxOrderNumber.getText().toString().isEmpty() &&
                        !mTxtbxOrderAmount.getText().toString().isEmpty() &&
                        !mTxtbxCurrency.getText().toString().isEmpty());
            }
        };

    }

}
