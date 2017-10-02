# Android Instant Apps - Flavors Sample

This sample introduces the usage of product flavors within
an Instant App.

There are two flavors available:

* `free`
* `paid`

These flavors are declared within `features/base/build.gradle`.
The implementation details can be found within `features/base/src`.

Each feature module that depends on the base feature module will have to declare
at least the same product flavors within its `build.gradle` file.

## Launch URLs

```
https://hello-flavors.instantappsample.com/hello -> HelloActivity
https://hello-flavors.instantappsample.com/goodbye -> GoodbyeActivity
```

## Build paths

The build paths for this sample differ from the default build path.
Depending on the flavor, the debug build output is within either of the following:

```
instant/build/outputs/apk/free/debug
instant/build/outputs/apk/paid/debug
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

