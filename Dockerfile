FROM adoptopenjdk/openjdk8
WORKDIR /
ARG ListingService-0.0.1-SNAPSHOT.jar
ADD ListingService-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8100
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]