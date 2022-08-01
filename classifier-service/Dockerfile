FROM openjdk:17-jdk-slim
MAINTAINER ITAacademy

COPY target/classifier-service-0.0.1-SNAPSHOT.jar classifier-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=production","/classifier-service-0.0.1-SNAPSHOT.jar"]