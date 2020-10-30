FROM maven:3.6.3-jdk-11-slim AS build
RUN mkdir -p /ioet
WORKDIR /ioet
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim
COPY --from=build /ioet/target/*.jar app.jar
COPY --from=build /ioet/sample.txt sample.txt
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]