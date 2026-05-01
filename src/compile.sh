#!/bin/bash
rm -rf bin
find . -name "*.class" -type f -delete
mkdir bin
javac -d bin main/global/*.java main/model/*.java main/view/*.java main/controller/*.java main/*.java