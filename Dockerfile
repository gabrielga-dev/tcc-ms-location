FROM openjdk:11
EXPOSE 8083
ADD target/my-events-ms-location-docker.jar my-events-ms-location-docker.jar
ENTRYPOINT ["java", "-jar", "/my-events-ms-location-docker.jar"]
