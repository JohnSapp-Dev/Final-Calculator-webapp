FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy Maven wrapper and project files
COPY mvnw ./mvnw
COPY .mvn .mvn
COPY pom.xml ./

# Ensure mvnw is executable
RUN chmod +x mvnw

# Run Maven dependencies offline and build the project
RUN ./mvnw dependency:go-offline
RUN ./mvnw clean install -DskipTests

# Copy the source code
COPY src ./src

# Set the default command to run the app
CMD ["java", "-jar", "/opt/app/*.jar"]