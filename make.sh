#!/bin/bash
@cd src
@javac -d ../obj $(find ./rootdir/* | grep .java)
@javadoc -charset UTF8 -private -author -d ../doc $(find ./rootdir/* | grep .java)