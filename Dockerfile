#
# Build stage
#
FROM maven:3.1.1-jdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-alpine
COPY --from=build /target/books-0.0.1-SNAPSHOT.jar app.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]