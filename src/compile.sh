#!/bin/bash
rm -rf bin
mkdir bin
javac -d bin main/global/*.java main/model/*.java main/view/*.java main/controller/*.java main/*.java