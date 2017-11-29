#!/bin/bash

set -e  # Exit immediately if a command exits with a non-zero status.
projects=("analytics" "configuration-apks" "cookie-api" "flavors"
    "hello-java" "hello-feature-module" "hello-kotlin" "install-api"
    "multi-feature-module" "service" "storage-api")

for p in ${projects[@]}; do
   echo
   echo
   echo Building $p
   echo "====================================================================="

   pushd $p > /dev/null  # Silent pushd
   ./gradlew $@ | sed "s@^@$p @"  # Prefix every line with directory
   code=${PIPESTATUS[0]}
   if [ "$code" -ne "0" ]; then
       exit $code
   fi
   popd > /dev/null  # Silent popd
done

echo
echo "All done"
