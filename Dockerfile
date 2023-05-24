

FROM openjdk:17

WORKDIR /app

ARG JAR_FILE=/target/*.jar

COPY ${JAR_FILE} /app/countries.jar

COPY /asset /app/asset

ENV SPRING_PROFILES_ACTIVE=prod

CMD ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "countries.jar"]
