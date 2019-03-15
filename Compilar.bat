cd src
"../../../x64/jdk1.8.0_181/bin/javac.exe" -verbose *.java
jar cvfm ../out/ApBanco.jar ../MANIFEST *.class
del *.class
pause
