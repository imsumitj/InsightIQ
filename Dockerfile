# Use a base image with Gradle installed
FROM gradle:latest AS build

# Set the working directory
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle.kts .
COPY src ./src

# Build the project
RUN gradle build

# Use a base image with Java and JRE installed
FROM openjdk:latest

# Copy the built JAR file from the previous stage
COPY /build/libs/LexyLynx-*.jar ./app.jar

# Copy the secret file into the container
#COPY --from=build /run/secrets/api_key_secret /run/secrets/api_key_secret
#COPY --from=build /run/secrets/api_key_secret /path/inside/container/api_key_secret

# Specify the command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
