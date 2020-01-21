#!/bin/bash

javac -d bin src/Run.java
cd bin
java Run
cd ..
rm -rf bin
cd src
rm *.class 2>/dev/null













