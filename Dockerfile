FROM openjdk:17-jdk-slim
EXPOSE 8080
COPY target/calculator-web-app.war /usr/local/tomcat/webapps/calculator-web-app.war

