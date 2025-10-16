# Use OpenJDK 21 (Render supports it)
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the jar file
COPY coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
