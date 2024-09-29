FROM openjdk:22-jdk

FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package

ADD target/eurekaDiscovery_service-0.0.1-SNAPSHOT.jar  app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/app.jar"]