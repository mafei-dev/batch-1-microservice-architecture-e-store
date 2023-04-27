FROM openjdk:8-jre
COPY target/*.jar api-gateway.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","/api-gateway.jar"]
#java -Dspring.profiles.active=docker -jar /api-gateway.jar
EXPOSE 8080