# Android Instant Apps - Sample code collection

The samples in this repository demonstrate building and using APIs related to
[Android Instant Apps](https://d.android.com/topic/instant-apps).

## Getting started

Shared instructions on the samples are collected in this file.
For sample specific instructions, enter a sample's directory and
follow the corresponding README file.

## Available samples

`analytics` -> Usage of Firebase Analytics

`config-splits` -> Introduces Configuration splits API

`cookie-api` -> Usage of the Cookie API

`hello-java` -> Hello World written in the Java Programming Language.

`hello-kotlin` -> Hello World written in Kotlin.

`hello-feature-module` -> Hello World with feature modules

`multi-feature-module` -> More complex feature module sample

`flavors` -> product flavors in an Instant App


## Running an Instant App sample

### From Android Studio

1. Select the `instant` feature module run configuration
2. Run the selected configuration

Some samples provide multiple entry points.
In this case you can choose which URL to use before starting the Instant App.

### From the command line (Android O+)

#### Find the build output

1. Run a gradle build `./gradlew assembleDebug`.
2. Locate the zip file containing the instant app.
2.1 This is usually located at `./instant/build/outputs/debug/instant-debug.zip`
2.2 Some samples contain flavors. In these cases the output path is different.
    These build output paths will be specified in the sample in question.

#### Run the Instant App

From the sample's root directory, execute

```
cd instant/build/outputs/apk/debug # navigate to build dir
unzip instantapp-debug.zip # extract apks
adb install-multiple -r -t --instantapp *.apk # install apks

# launch entry point; you'll have to replace $(SAMPLE_ENTRY_POINT)
adb shell am start -a android.intent.action.VIEW -c android.intent.category.BROWSABLE -d $(SAMPLE_ENTRY_POINT)

cd - # takes you back to the root directory
```

### Troubleshooting

Refer to the [troubleshooting section](https://developer.android.com/topic/instant-apps/troubleshoot.html)
of the Android Instant Apps documentation.

If you find an issue with a sample, please file a [new issue](https://github.com/googlesamples/android-instant-apps/issues/new).

In case you have questions on Instant Apps, refer to [StackOverflow](https://stackoverflow.com/questions/tagged/android-instant-apps).

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

