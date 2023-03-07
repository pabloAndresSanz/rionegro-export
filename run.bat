@echo off
set SINIDE_DB_HOST=pg-staging.die.educacion.gob.ar
set SINIDE_DB_PORT=5432
set SINIDE_DB_NAME=sinideprod
set SINIDE_DB_USERNAME=
set SINIDE_DB_PASSWORD=
set SINIDE_DB_ESQUEMA=jujuy

java -cp . -jar target\sinide-export-0.0.1-SNAPSHOT.jar

