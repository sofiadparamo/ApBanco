cd src
"../../../x64/jdk1.8.0_181/bin/javac.exe" *.java
"../../../x64/jdk1.8.0_181/bin/jar.exe" cvfm ../out/artifacts/ApBanco/ApBanco.jar "../META-INF/MANIFEST.MF" *.class
del *.class
pause
