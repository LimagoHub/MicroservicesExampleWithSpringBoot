FROM openjdk:8-jdk-alpine
MAINTAINER jowagner@limago.de
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

