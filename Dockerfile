FROM maven:3-openjdk-11
COPY ./usr/src/community-tracker-java
WORKDIR /usr/src/community-tracker-java
RUN mvn -Dmaven.test.skip=true package
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]




