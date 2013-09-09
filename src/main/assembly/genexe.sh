#!/bin/sh
if [ ! -d "bin" ] 
then
  mkdir -v "bin"
fi
if [ -f "bin/embed-test" ] 
then 
  echo "Removing old embed-test executable"
  rm -f "bin/embed-test"
fi
echo "Creating embed-test executable"
ARGS='"$@"'
(echo '#!/bin/sh
exec java -jar "$0" "$@"
'; cat target/embed-test.jar) > bin/embed-test && chmod +x bin/embed-test

cp src/main/assembly/runtest.sh bin/
