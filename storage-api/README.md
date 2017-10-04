# Android Instant Apps - Storage API sample

This sample app demonstrates how to use the Storage API.

It is relevant to devices running on Android versions
**lower than API level 26**.

On devices running on API level 26 or higher, the Android framework takes
care of migrating user data from instant app to installed app.

After installation is completed, the installed app transfers the stored data
from the instant app by using this API, providing a seamless experience for the user.

# Usage

In the installed app, call the [Storage API](https://developers.google.com/android/reference/com/google/android/gms/instantapps/InstantAppsClient.html#getInstantAppData()).
The API lets you access the data stored in the instant app.

For more information about data storage, see [the documentation](https://developers.google.com/android/reference/com/google/android/gms/instantapps/InstantAppsClient.html#getInstantAppData()).

## Launch URL

`https://storage-api.instantappsample.com/`

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

