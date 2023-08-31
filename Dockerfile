# Use Gradle 8.3.0 with JDK 17 on Alpine Linux for the build stage
FROM gradle:8.3.0-jdk17-alpine AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the source code into the container
COPY . .

# Run Gradle to build the application, skipping tests
RUN gradle build -x test

# Start a new stage for running the application
FROM adoptopenjdk:17-jdk-hotspot-alpine AS run

# Set the working directory
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
