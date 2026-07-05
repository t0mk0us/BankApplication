# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-alpine
LABEL maintainer="baeldung.com"

COPY target/BankApplication-0.0.1-SNAPSHOT.jar app.jar