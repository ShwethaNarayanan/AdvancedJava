# Use Maven as the base image
FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder

# Set the working directory
WORKDIR /webappmaven

# Copy pom.xml and other files
COPY pom.xml .
COPY src ./src

#Run maven install
RUN mvn clean install -DskipTests

# Use Tomcat 
FROM tomcat:11.0.1-jdk21

#Remove the default web apps folder
RUN rm -rf /usr/local/tomcat/webapps/*

#Copy the built WAR file from the builder stage  to the Tomcat webapps directory
COPY --from=builder /webappmaven/target/WebAppMaven1.war /usr/local/tomcat/webapps/

# Expose the port that Tomcat runs on
EXPOSE 8080

# Command to run Tomcat[the default command is already set]
CMD ["catalina.sh", "run"] 