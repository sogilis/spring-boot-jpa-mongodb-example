#!/bin/sh -e

case "${1}" in
     "mongodb")
        echo "Starting MongoDB..."
        docker-compose -f docker/mongodb.yml up -d
        db_profile=mongodb
        ;;
    *)
        echo "Starting PostgreSQL..."
        docker-compose -f docker/postgres.yml up -d
        db_profile=jpa
        ;;
esac

echo

echo "Starting application..."
./gradlew bootRun -Dspring.profiles.active=verify,${db_profile}
