#!/bin/bash

docker build -t postgretest -f ../Docker/Dockerfile .

docker run -d -p 5433:5432 postgretest