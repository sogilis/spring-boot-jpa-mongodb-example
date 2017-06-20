#!/bin/sh -e

echo "Stopping database..."
docker-compose -f docker/mongodb.yml stop
