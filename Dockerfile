# syntax=docker/dockerfile:1

FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
COPY target/BankApplication-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
