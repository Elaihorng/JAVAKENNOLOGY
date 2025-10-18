FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn package -DskipTests

FROM eclipse-temurin:17-alpine 
COPY --from=build /target/*.jar coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT [ "java","-jar", "coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar" ]
