#!/bin/bash
dir="target/class";

if [ ! -f $dir ]; then
        mkdir -p $dir
fi
javac -sourcepath src/main/java/ -classpath $dir src/main/java/fr/nicoPaul/*/*.java -d $dir

java -classpath $dir fr.nicoPaul.miniHearstone.app
