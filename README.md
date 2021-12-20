gradle shadowJar
rm config/FlinkAppPrometheus-1.0-SNAPSHOT-all.jar
cp build/libs/FlinkAppPrometheus-1.0-SNAPSHOT-all.jar config/FlinkAppPrometheus-1.0-SNAPSHOT-all.jar
gradle docker

docker run -p 8082:8081 -p 6124:6123 org.example/flinkappprometheus
docker-compose up
