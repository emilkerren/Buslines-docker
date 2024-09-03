# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

WORKDIR /app/backend
COPY ./target/backend-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["java", "-jar", "app.jar"]