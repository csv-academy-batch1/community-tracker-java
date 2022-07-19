FROM maven:3-openjdk-11

COPY . /usr/src/ct
WORKDIR /usr/src/ct

RUN mvn -Dmaven.test.skip=true package
ENTRYPOINT ["java", "-jar", "/usr/src/ct/target/Community-Management-0.0.1-SNAPSHOT.jar"]
