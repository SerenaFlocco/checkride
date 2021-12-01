# Spring Boot SOAP WS

Tiger Bank are providing a simple Spring Boot service for the stub. The service takes in the details of a new customer and then generates a customer ID. It returns the generated Customer ID and a status to the caller.

The service is described by a SOAP wsdl which can be found [here](customerDetails.wsdl).

### Request message

The request message contains the following high and low level elements:
  * Service header
    * brand
  * Personal details
    * Name details
      * first name
      * last name
    * Contact details
      * Phone number
      * Address

### Response message

The response message contains the following elements:
  * status
  * customer_id



## Build the stub image

### Installing Java

In order to build (and run) the stub, you'll need to have java installed on your machine. During testing some problems were found with using the latest version of Java. A version that works is `openjdk 11.0.12 2021-07-20`.

On MacOS you can install this version by running: `brew install java11`.

### Building the stub

* In the current directory (``stub``), build the application

``./gradlew clean build``

## Run and Test the stub locally

* Run the soap stub locally:
  * cd to ``deployment/docker``
  * Run ``docker compose up --build``
    * use `up` option `-d` to run it in the background

* Test it out locally
  Open a new terminal and run the following command:

```
curl --location --request POST 'http://localhost:8080/ws' \
--header 'Content-Type: text/xml' \
--data-raw '<s11:Envelope xmlns:s11='\''http://schemas.xmlsoap.org/soap/envelope/'\''>
  <s11:Body>
    <sch:customerDetailsRequest xmlns:sch='\''http://ibm.com/CustomerDetails/'\''>
      <sch:customer_details>
        <sch:service_header>
          <sch:brand>IBM</sch:brand>
        </sch:service_header>
        <sch:personal_details>
          <sch:name_details>
            <sch:first_name>saad</sch:first_name>
            <sch:last_name>mia</sch:last_name>
          </sch:name_details>
          <sch:contact_details>
            <sch:phone>333-7777777</sch:phone>
            <sch:address>123 Main Street</sch:address>
          </sch:contact_details>
        </sch:personal_details>
      </sch:customer_details>
    </sch:customerDetailsRequest>
  </s11:Body>
</s11:Envelope>'
```

A response like this will be returned:

```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"><SOAP-ENV:Header/><SOAP-ENV:Body><ns2:customerDetailsResponse xmlns:ns2="http://ibm.com/CustomerDetails/"><ns2:status>success</ns2:status><ns2:customer_id>78b8f278-c1bb-4704-ac12-b12e2b3da5c0</ns2:customer_id></ns2:customerDetailsResponse></SOAP-ENV:Body></SOAP-ENV:Envelope>
```

Or you can use the postman request `customer-details-non-secure` from the collection [here](postman/customer-details-spring-ws.postman_collection.json[]).

## Deploy the stub on OpenShift

### Log into the OpenShift command line

From the OpenShift console **Administrator** panel, click your username.

Select ``Copy Login Command``. A new browser tab will open.

Click ``Display Token``.

Copy the login command and run it in your command line in a terminal session:

This will be the command which begins ``oc login --token=...``

### Create an OpenShift project for the SOAP stub

Run the following command:

* ``oc new-project soapserver``

Change to the new ``soapserver`` project: ``oc project soapserver``

### Build and push the SOAP server image to OpenShift

1. Expose the OpenShift Internal Image Registry as a route:

Expose the Docker registry as a route

Openshift does not normally expose the internal docker registry on a route by default. You will need to set this up before running the scripts

```
$ oc patch configs.imageregistry.operator.openshift.io/cluster --patch '{"spec":{"defaultRoute":true}}' --type=merge
```

Check it is exposed using this command:

```
$ oc get routes -n openshift-image-registry -o=jsonpath='{.items[0].spec.host}{"\n"}'
```

The expected output should look like this

```
default-route-openshift-image-registry.cp4i-intcp-43-3cd0ec11030dfa215f262137faf739f1-0000.eu-gb.containers.appd
```

2. Run the *generate_image* script:

  * Navigate to the ``deployment/ocp`` directory

  * Run this script: ``generate_image.sh``

  This will create the image and tag it with the name of the route to the internal image registry for your cluster. It will then push the image and it will be available as an *image stream*.

  **NOTE:** if this step fails with the following error when the script attempts to push the image then you can continue to deploy using the image we have pushed to quay.io. Intructiuons on this option are included in the subsequent sections.

  ```
  Client.Timeout exceeded while attempting headers
  ```

  This error seems to happen when the clusters are slow or particular data centers are heavily utilised.

3. Validate that the image stream is available:
  * Run ``oc get is -n soapserver`` to display the image stream. The output should look like this:

  ```
  NAME         IMAGE REPOSITORY                                                         TAGS      UPDATED
  soapserver   image-registry.openshift-image-registry.svc:5000/soapserver/soapserver   v1        14 seconds ago
  ```

  Additionally you can view the image stream on the OpenShift Console by Clicking ``Builds`` > ``Image Streams``

  ![Image Streams](../images/image-streams.png "Image Streams on OCP console")

### Deploy the soap server to OpenShift

Navigate to ``deployment/ocp``.

* Print the yaml definition for the *deployment*, *service* and *route*:
  * ``deploy.sh ocp`` - prints the definitions with the container image you pushed to OCP populated in the deployment's image field
  * ``deploy.sh quay`` - prints the definitions with the container image on quay.io populated in the deployment's image field

  The output will look like this:

```
  {
    "kind": "List",
    "apiVersion": "v1",
    "metadata": {},
    "items": [
        {
            "apiVersion": "apps/v1",
            "kind": "Deployment",
            "metadata": {
                "name": "soapserver"
            },
            "spec": {
                "replicas": 1,
                "selector": {
                    "matchLabels": {
                        "app": "soapserver"
                    }
                },
                "template": {
                    "metadata": {
                        "labels": {
                            "app": "soapserver"
                        }
                    },
                    "spec": {
                        "containers": [
                            {
                                "image": "image-registry.openshift-image-registry.svc:5000/soapserver/soapserver:v1",
                                "imagePullPolicy": "Always",
                                "name": "soapserver"
                            }
                        ]
                    }
                }
            }
        },
        {
            "apiVersion": "v1",
            "kind": "Service",
            "metadata": {
                "name": "soapserver"
            },
            "spec": {
                "ports": [
                    {
                        "name": "web",
                        "port": 8080,
                        "protocol": "TCP",
                        "targetPort": 8080
                    }
                ],
                "selector": {
                    "app": "soapserver"
                }
            }
        },
        {
            "apiVersion": "route.openshift.io/v1",
            "kind": "Route",
            "metadata": {
                "name": "soapserver"
            },
            "spec": {
                "port": {
                    "targetPort": "web"
                },
                "to": {
                    "kind": "Service",
                    "name": "soapserver"
                }
            }
        }
    ]
}
```

* Apply the configuration by issuing the following command:
  * ``deploy.sh ocp apply``

If the previous generate-image.sh step failed to push the image, deploy using the **quay.io** image:

* Apply the configuration by issuing the following command:
  * ``deploy.sh quay apply``

  You will see the following output:

  ```
  deployment.apps/soapserver created
  service/soapserver created
  route.route.openshift.io/soapserver created
  ```

### Review the deployed SOAP service

1. In OpenShift select the ``soapserver`` project

![soapserver project](../images/soapserver-project.png "soapserver project")

2. View the Deployment, by clicking ``Workloads`` > ``Deployments`` > ``soapserver``

![soapserver deployment](../images/soapserver-deployment-1.png "soapserver deployment 1")

![soapserver deployment](../images/soapserver-deployment-2.png "soapserver deployment 2")

3. View the Pod, by selecting ``Pods`` from the Deployment page and then clicking on the ``soapserver`` pod

![soapserver pods](../images/soapserver-pods-1.png "soapserver pods 1")

![soapserver pods](../images/soapserver-pods-2.png "soapserver pods 2")

4. View the Service (hostname internal to the cluster) by clicking ``Networking`` > ``Services`` > ``soapserver``

![soapserver service](../images/soapserver-service-1.png "soapserver service 1")

![soapserver service](../images/soapserver-service-2.png "soapserver service 2")

5. View the Route (hostname external to the cluster) by clicking ``Networking`` > ``Routes`` > ``soapserver``

![soapserver route](../images/soapserver-route-1.png "soapserver route 1")

![soapserver route](../images/soapserver-route-2.png "soapserver route 2")


### Test the deployed SOAP service

1. If you have not done so already, import the postman collection into Postman on your workstation.

There is a button at the top of Postman which allows you to import the collection:

![Import Button](../images/postman-import-button.png "Postman Import Button")

YOu can then browse for the collection on your workstation, the Import wizzard will show the **customer-details-spring-ws** collection.

![Postman Import](../images/postman-import-collection.png "Import Collection")

Click ``Import``.

2. Navigate the collection

On the left hand side of Postman navigate to the new collection, expand it and selct the ``customer-details-non-secure`` **POST** request.

![Collection POST Request](../images/postman-collection.png)

3. Review the message body

When the POST request displays in Postman, click ``Body`` and review the test payload

![POST body](../images/postman-post-body.png)

4. Set the hostname to invoke the stub on OpenShift

Run the following command to diaply the hostname of the route created for the stub on OpenShift:

``oc get route soapserver -n soapserver``

The result will look like the snippet below, copy the hostname into your buffer:

```
NAME         HOST/PORT                                                                                                     PATH      SERVICES     PORT      TERMINATION   WILDCARD
soapserver   soapserver-soapserver.ace-mq-test-01-3cd0ec11030dfa215f262137faf739f1-0000.eu-gb.containers.appdomain.cloud             soapserver   web                     None
```

Next to the **POST** operation on Postman, replace ``localhost:8080`` in the adress bar, with the value from the route.

The resulting address should look like this:

```
http://soapserver-soapserver.ace-mq-test-01-3cd0ec11030dfa215f262137faf739f1-0000.eu-gb.containers.appdomain.cloud/ws
```

![Postman route](../images/postman-set-route.png "Postman route address")

5. Invoke the stub from Postman

Click ``Send``.

You should see a response returned like this:

![Postman Response](../images/postman-response.png "Postman response to stub")

The payload will be a SOAP envelope containing a **status** and a **customer_id** field.

```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:customerDetailsResponse xmlns:ns2="http://ibm.com/CustomerDetails/">
            <ns2:status>success</ns2:status>
            <ns2:customer_id>7273d81a-df58-4e06-a187-e4f79bd2ec7a</ns2:customer_id>
        </ns2:customerDetailsResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

