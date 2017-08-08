# Android Instant Apps - Multi feature sample app

This sample app demonstrates the building of an installable and an instant app
with the same behaviors. The functionality of the instant app is split
in two features which can be individually launched on a device.

## Getting started

# CURRENTLY THIS SAMPLE IS BROKEN DUE TO A [KNOWN BUG](https://issuetracker.google.com/63814741)

### Prerequisites

1. Android Studio 3.0 Preview version

### Android Studio Instructions

1. Import project.
2. Build.
3. Open "Edit Configurations" in target selection dropdown. Type "https://multi-feature.instantappsample.com/main" in the URL field of "Launch Options section.
4. Run.

### Command Line Instructions

#### Run on Android O

```
$ unzip instantapp/build/outputs/apk/debug/instantapp-debug.zip
$ adb install-multiple -r -t --ephemeral *.apk
$ adb shell am start -a android.intent.action.VIEW -c android.intent.category.BROWSABLE -d https://multi-feature.instantappsample.com/main
```

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

