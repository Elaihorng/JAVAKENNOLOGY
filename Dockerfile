FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY build/libs/coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar .

EXPOSE 8089

CMD ["java", "-jar", "coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar"]
