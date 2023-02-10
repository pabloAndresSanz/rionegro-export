@echo off
set SINIDE_DB_HOST=138.197.65.231
set SINIDE_DB_PORT=5432
set SINIDE_DB_NAME=sinide
set SINIDE_DB_USERNAME=postgres
set SINIDE_DB_PASSWORD=.md5e8a48653851e28c69d!

java -cp . -jar target\sinide-export-0.0.1-SNAPSHOT.jar

