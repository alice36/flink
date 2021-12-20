#!/bin/bash
echo "EES: starting taskmanager"
export FLINK_PROPERTIES=$(cat /opt/flink/ees/flink-conf.yaml)
echo "Showing FLINK_PROPERTIES: $FLINK_PROPERTIES"
/docker-entrypoint.sh taskmanager #this script is reading $FLINK_PROPERTIES and rewriting flink-config.yaml
