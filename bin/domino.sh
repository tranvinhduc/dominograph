#!/bin/sh

java -jar domino-v1.2.jar ; sed '2 i\
rankdir=LR; ' myFile.dot > myFile2.dot ; dot -Tpdf ./myFile2.dot -o myFile2.pdf; open ./myFile2.pdf &



