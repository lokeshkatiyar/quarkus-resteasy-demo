# rest-api-demo project

This project uses Open JDK 11, Quarkus(the Supersonic Subatomic Java Framework), Docker and Maven 3.6.3+.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Keycloak installaton using docker
For Authorization and authentication this project is using Keycloak for realm.
to install keycloak
```shell script
docker run --name keycloak -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8180:8080 jboss/keycloak
```
Create the new realm using 'realm.json' file available in resources folder (see https://www.keycloak.org/docs/latest/server_admin/index.html#_create-realm).

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `rest-api-demo-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/rest-api-demo-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable
install GraalVM (https://www.graalvm.org/downloads/), if not installed </br>
make sure "native-image" tool is installed otherwise execute below script at path GRAALVM_HOME\bin
```shell script
gu install native-image
```
You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/rest-api-demo-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

##Generate token for the rest api
For 'alice' user
``` shell script
curl -X POST \
  http://localhost:8180/auth/realms/quarkus/protocol/openid-connect/token \
  -H 'authorization: Basic YmFja2VuZC1zZXJ2aWNlOnNlY3JldA==' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: 8aaf6eec-d8f8-3945-2a90-fc8ca386a955' \
  -d 'username=alice&password=alice&grant_type=password'
```

For 'admin' user
``` shell script
curl -X POST \
  http://localhost:8180/auth/realms/quarkus/protocol/openid-connect/token \
  -H 'authorization: Basic YmFja2VuZC1zZXJ2aWNlOnNlY3JldA==' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: d06e8507-9bca-3ef7-2304-114fcbce1582' \
  -d 'username=admin&password=admin&grant_type=password'
```