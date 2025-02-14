# Use a Java runtime as the base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory
VOLUME /tmp

# Copy the built JAR file into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the JAR file
ENTRYPOINT ["java","-jar","/app.jar"]