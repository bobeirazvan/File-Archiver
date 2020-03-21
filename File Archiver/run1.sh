#!/usr/bin/env bash

javac -d bin src/decode.java
cd bin
java decode
cd ..
rm -rf bin
cd src
rm *.class 2>/dev/null

