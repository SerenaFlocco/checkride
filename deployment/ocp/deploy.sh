#!/bin/bash

set -e

source env.sh
source common.sh

check_var SOAPSERVER_NAMESPACE

STUBIMAGE=$1
if [[ $1 = "ocp" ]]; then
  STUBIMAGE=image-registry.openshift-image-registry.svc:5000/${SOAPSERVER_NAMESPACE}/soapserver:v1
  echo "Will deploy using the Stub image from the internal registry"
else
  STUBIMAGE=quay.io/tquigly/soapstub:latest
  echo "Warning - will deploy using the Stub image from quay.io, not the internal registry"
fi

oc process -f template.yaml \
  -p IMAGE=$STUBIMAGE | $(command $2 ${SOAPSERVER_NAMESPACE})
