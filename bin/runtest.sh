#!/bin/sh

echo "Starting subscriber instance"
./bin/embed-test
sleep 5 # hackety hack

echo "Starting publisher instance"
./bin/embed-test publish
