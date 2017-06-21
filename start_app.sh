#!/bin/sh -e

db_profile=
db_container_id=

start_postgres() {
    docker_postgres_args="            \
        -e POSTGRES_USER=postgres     \
        -e POSTGRES_PASSWORD=postgres \
        -e POSTGRES_DB=spring-boot-jpa-mongo-exemple"

    echo "Starting PostgreSQL..."
    db_profile=jpa
    db_container_id=$(docker run -d -p 5432:5432 ${docker_postgres_args} postgres:9.6)

    echo "Waiting for PostgreSQL to be ready..."
    until docker run -it --rm        \
        -e PGPASSWORD=postgres       \
        --link ${db_container_id}:pg \
        postgres:9.6                 \
        psql -U postgres -h pg -c "select 1" -d postgres; do sleep 1; done > /dev/null
}

start_mongo() {
    echo "Starting MongoDB..."
    db_profile=mongodb
    db_container_id=$(docker run -d -p 27017:27017 mongo:3.4)
}

stop_database() {
    echo
    echo "Stopping database..."
    docker stop ${db_container_id} > /dev/null
    docker rm ${db_container_id}   > /dev/null
}

run_application() {
    echo
    echo "Starting application..."
    ./gradlew bootRun -Dspring.profiles.active=verify,${db_profile}
}


case "${1}" in
    "mongodb")
        start_mongo
        ;;
    *)
        start_postgres
        ;;
esac

run_application
stop_database
