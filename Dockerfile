FROM eclipse-temurin:17-jre

LABEL authors="wail"

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]