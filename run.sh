echo "Starting application..."

./gradlew clean build -q

docker-compose up -d
