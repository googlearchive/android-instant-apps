# Android Instant Apps - Without URL.

This sample demonstrates building a simple instant app without associated website. It uses SplitInstall API out of the PlayCore library to fetch another split.


## Steps to run
```shell
./gradlew assembleDebug
ia run ./instantapp/build/outputs/apk/debug/instantapp-debug.zip
```

## How do I get 'ia' CLI?
Install Instant Apps Development SDK (revision: 1.2.0) from Android SDK Manager.

Add $ANDROID_HOME/extras/google/instantapps to your path
```shell
export PATH=$PATH:$ANDROID_HOME/extras/google/instantapps
```


## License

```
Copyright 2018 Google Inc.

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
