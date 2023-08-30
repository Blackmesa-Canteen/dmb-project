FROM openjdk:19-jdk-alpine

# Metadata as arguments (can be passed during docker build)
ARG JAR_FILE=build/libs/*.jar

# Copy the JAR file to the image
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
