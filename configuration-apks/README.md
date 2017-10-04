# Android Instant Apps - Configuration APKs Sample

This sample displays the usage of
[Configuration APKs](https://developer.android.com/topic/instant-apps/guides/config-splits.html)
within gradle.

The setup of Configuration APKs can be seen within the `features/build.gradle` file.

After a build, the resulting zip file (`instant/build/output/apk/debug/instant-debug.zip`)
holds several APKs, each with a specific configuration.

In a production environment, APKs that are relevant to users' display density and locale are
served to the users. This reduces the file size over the wire and on device.

## Launch URL

`https://config.instantappsample.com`

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

