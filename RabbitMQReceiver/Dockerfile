FROM openjdk:8-jdk-alpine
MAINTAINER jowagner@limago.de
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
VOLUME /tmp
EXPOSE 8081
ENV SPRING_APPLICATION_JSON='{"spring": {"rabbitmq": {"host": "localrabbit", "addresses": "rabbit-mq"}}}'
ENTRYPOINT ["java","-jar","/app.jar"]

