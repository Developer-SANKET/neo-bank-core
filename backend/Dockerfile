# Lightweight Java 17 runtime
FROM eclipse-temurin:17-jre-alpine

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot JAR (from build context)
COPY target/*.jar app.jar

# JVM memory limits (safe for medium EC2)
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Expose application port
EXPOSE 8080

# Health check for zero-downtime (Spring Boot Actuator required)
HEALTHCHECK --interval=30s --timeout=10s --retrilses=3 \
  CMD wget -qO- http://localhost:8080/actuator/health || exit 1

# Start application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
