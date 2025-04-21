FROM tomcat:latest
EXPOSE 8080
COPY calculator-web-app.war /usr/local/tomcat/webapps/

