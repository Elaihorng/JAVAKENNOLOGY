# Use lightweight JDK 21 base image
FROM eclipse-temurin:21-jre-alpine

# Set working directory
WORKDIR /app

# Copy the Spring Boot JAR
COPY coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar .

# Expose default port (Render detects this)
EXPOSE 8089

# Run the app
CMD ["java", "-jar", "coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar"]

