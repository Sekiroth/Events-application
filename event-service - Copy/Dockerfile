FROM openjdk:17-jdk-slim
MAINTAINER ITAacademy

COPY target/event-service-0.0.1-SNAPSHOT.jar event-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=production","/event-service-0.0.1-SNAPSHOT.jar"]