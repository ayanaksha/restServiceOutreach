#!/bin/bash

cd ..
cd online-sales-service
source ./env-variable.sh
mvn clean package -Dmaven.test.skip=true
docker build -t sales-app .
cd ..
