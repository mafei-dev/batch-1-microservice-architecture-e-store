FROM openjdk:8-jre
COPY target/*.jar user-service.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","/user-service.jar"]
EXPOSE 8080