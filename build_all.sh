#!/bin/bash

set -e  # Exit immediately if a command exits with a non-zero status.
projects=("analytics" "flavors" "hello" "hello-feature-module" "hello-kotlin" "service")

for p in ${projects[@]}; do
   echo
   echo
   echo Building $p
   echo "====================================================================="

   pushd $p > /dev/null  # Silent pushd
   ./gradlew $@  assemble | sed "s@^@$p @"  # Prefix every line with directory
   code=${PIPESTATUS[0]}
   if [ "$code" -ne "0" ]; then
       exit $code
   fi
   popd > /dev/null  # Silent popd
done

echo
echo "All done"
