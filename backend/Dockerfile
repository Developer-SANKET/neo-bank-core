# Lightweight Java 17 runtime
FROM eclipse-temurin:17-jre-alpine

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot fat JAR (not the .original one)
COPY target/neo-bank-core-1.0.0.jar app.jar

# JVM memory limits (safe for medium EC2)
# ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Expose application port
EXPOSE 8080

# Health check for zero-downtime (Spring Boot Actuator required)
HEALTHCHECK --interval=30s --timeout=10s --retries=3 \
  CMD wget -qO- http://localhost:8080/actuator/health || exit 1

# Start application
ENTRYPOINT ["java","-jar","app.jar"]