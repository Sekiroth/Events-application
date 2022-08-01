FROM openjdk:17-jdk-slim
MAINTAINER ITAacademy

COPY target/user-service-0.0.1-SNAPSHOT.jar user-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=production","/user-service-0.0.1-SNAPSHOT.jar"]