export SINIDE_DB_HOST=pg-staging.die.educacion.gob.ar
export SINIDE_DB_PORT=5432
export SINIDE_DB_NAME=sinideprod
export SINIDE_DB_USERNAME=
export SINIDE_DB_PASSWORD=
export SINIDE_DB_ESQUEMA=jujuy

java -cp . -jar target/sinide-export-0.0.1-SNAPSHOT.jar

