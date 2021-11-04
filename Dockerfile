FROM adoptopenjdk/openjdk11:latest
EXPOSE 8080
ADD target/my-tasks-ms.jar my-tasks-ms.jar
ENTRYPOINT ["java", "-jar", "my-tasks-ms.jar"]