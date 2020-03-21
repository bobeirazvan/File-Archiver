#!/usr/bin/bash

javac -d bin src/encode.java
cd bin
java encode
cd ..
rm -rf bin
cd src
rm *.class 2>/dev/null













