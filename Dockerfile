# Use OpenJDK 17 as the base image for the build stage
FROM openjdk:17-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and the project configuration files
COPY gradlew .
COPY gradle gradle

# Copy the project source code and resources
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Build the application
RUN ./gradlew clean build -x test

# Use OpenJDK 17 as the base image for the runtime stage
FROM openjdk:17.0.1-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Specify the default command to run when the container starts
CMD ["java", "-jar", "app.jar"]
