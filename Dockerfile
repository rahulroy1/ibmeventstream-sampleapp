# Start with a base image containing Java runtime (mine java 8)
FROM openjdk:11
# Add Maintainer Info
LABEL maintainer="rahul.roy@in.ibm.com"

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file (when packaged)
ARG JAR_FILE=target/ibmeventstreams-sampleapp-0.0.1-SNAPSHOT.jar
# Add the application's jar to the container
ADD ${JAR_FILE} ibmeventstreams-sampleapp-0.0.1-SNAPSHOT.jar
# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ibmeventstreams-sampleapp-0.0.1-SNAPSHOT.jar"]