# syntax=docker/dockerfile:1

RUN sudo apt-get -y install git

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