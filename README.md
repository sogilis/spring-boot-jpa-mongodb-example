# Spring boot + JPA + MongoDB application sample

This application demonstrate how to build a Spring Boot application which can switch between JPA and MongoDB with only configuration changes.

## Prerequisites

- [Docker](https://docs.docker.com/)

## Run with JPA (PostgreSQL database)

```bash
./start_app.sh jpa
```

This will start PostgreSQL database through a docker image (`postgres:9.6`), and then start the application.
If you see following message, it means the application works great:

```text
People found:
Perceval
Karadoc
```

## Run with MongoDB

```bash
./start_app.sh mongodb
```

## Run all tests

```bash
./gradlew check
```
