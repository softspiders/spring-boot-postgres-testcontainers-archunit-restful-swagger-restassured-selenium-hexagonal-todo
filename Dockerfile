FROM openjdk:18-jdk-alpine
MAINTAINER softspiders.org
COPY domain/target/domain-1.0.0.jar adapter/target/adapter-1.0.0.jar application/target/application-1.0.0.jar ./
ENTRYPOINT ["java","-jar","/application-1.0.0.jar"]