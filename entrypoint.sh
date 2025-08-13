#!/bin/sh

result=$(($1 + $2))
echo "result=$result" >> $GITHUB_OUTPUT
echo "output file" > containerOutputFile.txt