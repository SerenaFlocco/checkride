#!/bin/bash

set -e

source env.sh
source common.sh

check_var PREFIX
check_var SOAPSERVER_NAMESPACE

check_file SOAP_SERVER_JKS_PATH
check_file CA_JKS_PATH

oc process -f template-secure.yaml \
  -p PREFIX=${PREFIX} \
  -p NAMESPACE=${SOAPSERVER_NAMESPACE} \
  -p SOAP_SERVER_JKS=$(base64 -w 0 ${SOAP_SERVER_JKS_PATH}) \
  -p CA_JKS=$(base64 -w 0 ${CA_JKS_PATH}) | $(command $1 ${SOAPSERVER_NAMESPACE})

