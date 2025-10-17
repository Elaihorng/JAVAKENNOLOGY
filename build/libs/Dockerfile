# Use lightweight JDK 21 base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle settings.gradle ./

# Copy source code
COPY src/ src/

# Give execute permission to Gradle wrapper
RUN chmod +x ./gradlew

# Build the JAR inside the container (skip tests)
RUN ./gradlew clean build -x test

# Copy the built JAR to the root of /app
RUN cp build/libs/coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar ./app.jar

# Expose port
EXPOSE 8089

# Run the app
CMD ["java", "-jar", "app.jar"]
