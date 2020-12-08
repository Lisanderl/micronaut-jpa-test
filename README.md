Build project -> gradle build

Build native and Run in dcoker ->  docker-compose up
For local running you need postgres db:
docker run --name test-postgres -e POSTGRES_PASSWORD=root -e POSTGRES_USER=root -e POSTGRES_DB=micro -p 5432:5432 -d postgres:11