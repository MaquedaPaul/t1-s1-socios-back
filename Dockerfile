
FROM maven as stage1
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean install -Dmaven.test.skip=true
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=stage1 /app/target/*.jar ./app.jar
EXPOSE 80
CMD ["java", "-jar", "app.jar"]
