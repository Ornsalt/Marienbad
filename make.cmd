@cd src
@for /r %%a in (.) do @(javac -d ../obj %%a\*.java)
@for /r %%a in (.) do @(javadoc -charset UTF8 -private -author -d ../doc  %%a\*.java)