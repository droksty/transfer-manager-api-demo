FROM amazoncorretto:17-alpine
ADD target/*.jar transfer-manager.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "transfer-manager.jar"]