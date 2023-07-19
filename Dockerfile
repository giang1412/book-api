# syntax=docker/dockerfile:1

RUN sudo apt-get update; \
    sudo apt-get -y upgrade; \
    sudo apt-get install -y gnupg2 wget lsb-release \

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# clean up the file
RUN sed -i 's/\r$//' mvnw
# run with the SH path
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]