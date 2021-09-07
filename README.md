# API-ASSESSMENT-DOW-JONES-INDEX

## Requirements

For building and running the application you need:

- [JDK 8](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org)
- [Docker](https://www.docker.com/)
- [Docker Compse](https://docs.docker.com/compose/install/)

## Running the application locally

```
./mvnw clean package -DskipTests
docker-compose up
```

## Test APIs in Postman

1. Import the collection below.
2. Update Basic Authorization password with spring generated password found in the terminal
3. Test Apis
```
src/main/resources/Api-Assessment.postman_collection.json
```

## APIs

* GET ```/api/v1/index```
    *   Requires ```state``` query parameter

* POST ```/api/v1/index```
    *   Requires valid ```Index```  object in request body

* POST ```/api/v1/index/bulk```
    *   Requires ```base64``` encoded string of ```dow_jones_index.data``` in request body

