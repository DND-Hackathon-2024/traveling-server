FROM openjdk:latest

COPY ./build/libs/traveling-server-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]