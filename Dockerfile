FROM alpine/java:21-jre

LABEL authors="denys.ryhal"

WORKDIR /app

COPY ./config/build/libs/actions-demo.jar actions-demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "actions-demo.jar"]