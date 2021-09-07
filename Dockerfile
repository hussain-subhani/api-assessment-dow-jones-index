FROM adoptopenjdk:8-jre-hotspot
ADD target/api-assessment-0.0.1-SNAPSHOT.jar api-assessment.jar
ENTRYPOINT ["java", "-jar", "api-assessment.jar"]
EXPOSE 8080