#!/bin/sh -e

echo "Starting PostgreSQL..."
docker-compose -f docker/postgres.yml up -d

echo

echo "Starting application..."
./gradlew bootRun -Dspring.profiles.active=verify,jpa
