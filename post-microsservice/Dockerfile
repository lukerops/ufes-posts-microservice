# Use Ubuntu as the base image
FROM ubuntu:latest

# Set the working directory inside the container
WORKDIR /app

# Install OpenJDK 17 and other necessary packages
RUN apt-get update -y && \
    apt-get install -y openjdk-17-jdk && \
    apt-get install -y curl

# Copy the project files to the container
COPY . .

# Build the Kotlin/Spring Boot project
RUN ./gradlew build

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Define the command to run the Spring Boot application
CMD ["java", "-jar", "build/libs/post-microsservice-0.0.1-SNAPSHOT.jar"]
