FROM openjdk:17-jdk-slim
EXPOSE 8080
ADD target/CalculatorWebApp.jar CalculatorWebApp.jar
ENTRYPOINT["java","-war","/CalculatorWebApp.war"]
