FROM openjdk:8-jre
COPY target/*.jar eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]
EXPOSE 8085