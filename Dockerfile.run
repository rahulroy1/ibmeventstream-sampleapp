# Start with a base image containing Java runtime (mine java 8)
FROM openjdk:11

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/ibmeventstreams-sampleapp-0.0.1-SNAPSHOT /app/

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ibmeventstreams-sampleapp-0.0.1-SNAPSHOT.jar"]