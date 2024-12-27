# FROM openjdk:23
# WORKDIR /app
# COPY . .
# RUN "mvn clean package"
# EXPOSE 8080
# CMD ["java", "-jar", "/target/react-app-0.0.1-SNAPSHOT.jar"]

# Use the official Maven image to build the application
FROM maven:latest AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY . .

RUN mvn clean package -DskipTests

# Use a smaller base image to run the application
FROM openjdk:latest

# Set the working directory
WORKDIR /app

# Copy the jar file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port (default is 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
