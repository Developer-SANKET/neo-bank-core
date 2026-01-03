# Use lightweight JRE base image
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built Spring Boot JAR into the container
COPY backend/target/neobank.jar app.jar

# JVM memory options (optimized for small EC2 instances)
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Expose application port
EXPOSE 8080

# Healthcheck for zero-downtime deployments
HEALTHCHECK --interval=30s --timeout=10s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]