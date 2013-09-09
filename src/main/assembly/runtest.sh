#!/bin/sh

echo "Starting subscriber instance"
./bin/embed-test &

echo "Sleeping for a while to let the first instance register its handler"
sleep 10 # hackety hack

echo "Starting publisher instance"
./bin/embed-test publish
