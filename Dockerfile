FROM openjdk:8-jre-alpine3.9

COPY shortly-app/target/shortly-app-0.0.1-SNAPSHOT.jar /shortly.jar

CMD ["java", "-jar", "/shortly.jar"]

