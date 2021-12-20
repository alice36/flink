ARG dockerRegistry

FROM eu.europa.schengen.cs/common-flink-baseimage:latest

ARG jarFileName
ARG VCS_REF

ENV FLINK_CONF=/opt/flink/conf/flink-conf.yaml

LABEL vcs-ref=$VCS_REF

#ADD --chown=flink:flink $jarName /opt/flink/lib/job.jar
COPY FlinkAppPrometheus-1.0-SNAPSHOT-all.jar /opt/flink/lib/job.jar
COPY flink-conf.yaml /opt/flink/conf/flink-conf.yaml
RUN ls -la /opt/flink/conf
RUN ls -la /opt/flink/lib
RUN ls -la /opt/flink/bin
RUN cat /opt/flink/conf/logback-console.xml
RUN cp /opt/flink/conf/logback-console.xml /opt/flink/logback-console.xml
RUN ls -la /opt/flink
#COPY runTaskmanager.sh /runTaskmanager.sh
ENV FLINK_HOME=/opt/flink
RUN #chmod +x /runTaskmanager.sh
RUN chmod 777 /opt/flink/conf
RUN chmod 777 /opt/flink/log

USER flink

ENTRYPOINT ["./bin/flink", "run", "-c", "com.demo.Start", "/opt/flink/lib/job.jar"]
