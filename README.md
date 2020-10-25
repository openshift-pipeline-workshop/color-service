# color-service

This project is a sample project for [Quarkus](https://quarkus.io/), [Kubernetes](https://kubernetes.io/), [OpenShift](https://www.openshift.com/), [Tekton](https://tekton.dev/) and [Knative](https://knative.dev/).

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `color-service-<version>-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/color-service-<version>-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/blue-green-deployment-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Run the color-service locally

Color service can be run just as any other container. It has been tested using podman. The container exposes the Quarkus default port 8080 for its webservice:

```
$ podman run -p 8080:8080 -it quay.io/jritter/color-service
```

## Deploy color-service using Knative

```
$ kn service create color-service --image quay.io/jritter/color-service --request cpu=100m,memory=256Mi --limit cpu=200m,memory=512Mi -l app.openshift.io/runtime=quarkus -a app.openshift.io/vcs-ref=refs/heads/develop -a app.openshift.io/vcs-uri=https://github.com/jritter/color-service
```

## Change the color using Knative

```
$ kn service update color-service -e COLOR_SERVICE_COLOR=blue
```

Possible colors are:
* red
* green
* blue
* yellow

## Delete color-service using Knative

```
$ kn service delete color-service
```