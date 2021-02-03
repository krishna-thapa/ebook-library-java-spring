# Guide:
# https://blog.frankel.ch/hitchhiker-guide-containerizing-java-apps/

# Command to Build:
# docker build -t online-library-api:1.0 .

# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# For Java 11, try this
# Build step uses a JDK
FROM adoptopenjdk/openjdk11:alpine-slim as build

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src
RUN ./mvnw package -DskipTests

# Run step uses a JRE
FROM adoptopenjdk/openjdk11:alpine-jre

# Changed the working directory to /opt/app
WORKDIR /opt/app

ARG JAR_FILE=target/online-library-api-0.0.1-SNAPSHOT.jar

# cp spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8080