#!/bin/bash

cd databaseFiles || exit
./dbScript.sh
cd ..
./gradlew war

#wget https://download.jboss.org/wildfly/16.0.0.Final/wildfly-16.0.0.Final.tar.gz

#tar xf wildfly-16.0.0.Final.tar.gz
#rm -rf wildfly-16.0.0.Final.tar.gz

cp build/libs/*.war wildfly-16.0.0.Final/standalone/deployments
echo "done copying war"

cd wildfly-16.0.0.Final/bin || exit
./standalone.sh
