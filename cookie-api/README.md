# Android Instant Apps - Cookie API Sample

This sample app demonstrates how to use the Cookie API.

It contains storage and retrieval of values using both, the Android Framework API
and the InstantApps Play Services API.

# Usage

This API is available to both, the Instant App as well as the Installed App, and allows
to migrate user-generated data from an instant app to an installed app.

The flow for this API is as follows:

1. Check whether the cookie fits the allowance.
2. Store data within the instant app.
3. Retrieve data from the installed app.

> This API is available for API 26 or higher via [PackageManager](https://developer.android.com/reference/android/content/pm/PackageManager.html)
  and for API levels lesser than 26 via [PackageManagerCompat](https://developers.google.com/android/reference/com/google/android/gms/instantapps/PackageManagerCompat).

### Build Variants

This sample has two build variants:

 * `framework` -> Android 8.0 (API level 26) or higher
 * `playServices` -> Any API level

The two build variants provide the same features, but one uses
the Framework API whereas the other one uses the InstantApps Play Services API.

### Testing the API with this sample

1. Run the _instant_ configuration
2. Store some data
3. Run the _installed_ configuration
4. Retrieve the data stored earlier

## Launch URL

`https://hello-cookie.instantappsample.com`

## License

```
Copyright 2017 Google Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```

