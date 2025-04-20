FROM openjdk:17-jdk-slim
LABEL authors="JohnSapp"
COPY target/Final-1.0-SNAPSHOT.war /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

ENTRYPOINT ["top", "-b"]