# Use lightweight JDK 21 base image
FROM eclipse-temurin:21-jre-alpine

# Set working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR into the container
COPY coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar .

# Expose the port the app will run 
EXPOSE 8080

# Command to run the Spring Boot app
CMD ["sh", "-c", "java -Dserver.port=$PORT -jar coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar"]
