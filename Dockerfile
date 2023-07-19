FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# clean up the file
RUN sed -i 's/\r$//' mvnw
# run with the SH path
RUN ./mvnw dependency:go-offline

COPY src ./src
EXPOSE 8080
CMD ["./mvnw", "spring-boot:run"]