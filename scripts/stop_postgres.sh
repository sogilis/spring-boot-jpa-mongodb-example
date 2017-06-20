#!/bin/sh -e

echo "Stopping database..."
docker-compose -f docker/postgres.yml stop
