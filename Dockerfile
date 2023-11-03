FROM openjdk:11
EXPOSE 8085
ADD target/my-events-ms-location-docker.jar my-events-ms-location-docker.jar
ENTRYPOINT ["java", "-jar", "/my-events-ms-location-docker.jar"]
