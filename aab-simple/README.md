# Android Instant Apps - Android App Bundle

This sample is ready to be built using Android App Bundle format and published via Play Console.

## Get your instant app ready
To get your instant app ready for Android App Bundle, make sure you
have set up `AndroidManifest.xml` correctly:
1. Amend `<manifest>` tag by adding the following:
```
xmlns:dist="http://schemas.android.com/apk/distribution"
```
2. Inside `<manifest>` tag, add the following declaration:
```
<dist:module
    dist:instant="true">
</dist:module>
```

Which would make your manifest look something like:
```
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:dist="http://schemas.android.com/apk/distribution"
    package="com.google.android.instantapps.samples.instantenabledandroidappbundle">

    <dist:module
        dist:instant="true">
    </dist:module>

    <application>
    ...
   </application>
</manifest>
```

3. In Android Studio, build the bundle: `Build` > `Generate Signed Bundle / APK…` > `Bundle`

4. On the Play Developer Console, only upload this bundle once to the installed track. For the
instant track, you can simply select "Add from Library" to import the already uploaded
instant-enabled bundle.

## License

```
Copyright 2018 Google LLC.

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
