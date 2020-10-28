FROM maven:3.6.3-jdk-11-slim AS build
RUN mkdir -p /ioet
WORKDIR /ioet
COPY ["pom.xml", "sample.txt", "src", "/ioet"]
RUN mvn -B -f pom.xml clean package -DskipTests

FROM openjdk:11-jdk-slim
COPY --from=build /ioet/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]