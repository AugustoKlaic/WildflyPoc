#!/bin/bash

docker build -t postgres-voterdb -f ../Docker/Dockerfile .

docker run -d -p 5433:5432 --name voter-container postgres-voterdb