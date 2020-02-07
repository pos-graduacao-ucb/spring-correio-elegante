FROM openjdk:8-jdk-alpine
WORKDIR /usr/src/app
COPY ./spring-correio-elegante/ .
RUN ./mvnw package -Dmaven.test.skip=true
ENTRYPOINT ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]

LABEL version="0.1.0" description="Correio elegante" maintainer="Gabriela Guedes <zooiv3rde@gmail.com>"
