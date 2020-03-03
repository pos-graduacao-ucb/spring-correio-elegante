FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} elegantez-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/elegantez-0.0.1-SNAPSHOT.jar"]

LABEL version="0.1.0" description="Correio elegante" maintainer="Gabriela Guedes <zooiv3rde@gmail.com>"
