# Spring boot + JPA + MongoDB application sample

This application demonstrate how to build a Spring Boot application which can switch between JPA and MongoDB with only configuration changes.

# Prerequisite

- [Docker-compose](https://docs.docker.com/compose/)

# How to run application with JPA (PostgreSQL database)

```bash
./scripts/start_app.sh
```

This will start PostgreSQL database through a docker image (`docker/postgres.yml`), and then, start the application.

If you see following message, it means the application works great:

```text
People found:
Perceval
Karadoc
```

Then, you can stop PostgresSQL docker image with:

```bash
./scripts/stop_postgres.sh
```

# How to run all tests

```bash
./gradlew check
```