#!/bin/bash
javac -cp libs/gson-2.10.1.jar -d out src/server/*.java
java -cp "out:libs/gson-2.10.1.jar" server.Main