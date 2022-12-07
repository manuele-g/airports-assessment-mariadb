FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/developer-assessment-mariadb.jar 
COPY ${JAR_FILE}  developer-assessment-mariadb.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=development","developer-assessment-mariadb.jar"]
EXPOSE 8080