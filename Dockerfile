 
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY . .
RUN mvn clean package -DskipTests
 
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/wallet-app-0.0.1-SNAPSHOT.jar wallet-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "wallet-app.jar"]
