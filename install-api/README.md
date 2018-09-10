# Android Instant Apps - Install API sample

This sample app demonstrates how to use the [Install API](https://developers.google.com/android/reference/com/google/android/gms/instantapps/InstantApps.html#showInstallPrompt(android.app.Activity,%20android.content.Intent,%20int,%20java.lang.String)).

The API triggers Intent to install the app on device.
The call also accepts Intent, which is triggered after the installation is complete.

If an app wants to utilize this API, it needs an installable app on the Google Play Store.
Also the applicationIds on both the instant as well as the application module have to match.

## Launch URL

`https://install-api.instantappsample.com/`

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

